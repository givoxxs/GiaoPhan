using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Serialization;
using MySql.Data.MySqlClient;

namespace CalenderApp
{
    public partial class Form1 : Form
    {
        string connectionString = "server=localhost;uid=root;pwd=;database=calendar;sslmode=none";

        #region Properties
        private string filePath = "data.xml";
        private List<List<Button>> matrix;
        private int appTime;
 
        public List<List<Button>> Matrix { 
            get => matrix; 
            set => matrix = value; 
        }

        private PlanData job;
        public PlanData Job { get => job; set => job = value; }
        public int AppTime { get => appTime; set => appTime = value; }

        private List<string> dateOfWeek = new List<string> { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        #endregion
        public Form1()
        {
            InitializeComponent();
            tmNotify.Start();
            appTime = 0;
            LoadMatrix();

            try
            {
                Job = DeserializeFromXML(filePath) as PlanData;
            } 
            catch
            {
                SetDefaultJob();
            }
        }

        void SetDefaultJob()
        {
            Job = new PlanData();
            Job.Job = new List<PlanItem>();
            Job.Job.Add(new PlanItem() { 
                Date = DateTime.Now, 
                FromTime = new Point(4, 0), 
                ToTime = new Point(5, 0), 
                Job = "Test 1", 
                Status = PlanItem.statusList[(int)EPlanItem.COMING] 
            });
            Job.Job.Add(new PlanItem()
            {
                Date = DateTime.Now.AddDays(1),
                FromTime = new Point(4, 0),
                ToTime = new Point(5, 0),
                Job = "Test 2",
                Status = PlanItem.statusList[(int)EPlanItem.COMING]
            });
            Job.Job.Add(new PlanItem()
            {
                Date = DateTime.Now.AddDays(-1),
                FromTime = new Point(4, 0),
                ToTime = new Point(5, 0),
                Job = "Test 0",
                Status = PlanItem.statusList[(int)EPlanItem.COMING]
            });

        }

        void LoadMatrix()
        {
            Matrix = new List<List<Button>>();

            Button oldBtn = new Button() { Width = 0, Height = 0, Location = new Point(-Cons.margin, 0) };
            for (int i = 0; i < Cons.DayOfColumn; i++)
            {
                Matrix.Add(new List<Button>());
                for (int j = 0; j < Cons.DayOfWeek; j++)
                {
                    Button btn = new Button() { Width = Cons.dateButtonWidth, Height = Cons.dateButtonHeight };
                    btn.Location = new Point(oldBtn.Location.X + oldBtn.Width + Cons.margin, oldBtn.Location.Y);
                    btn.Click += btn_Click;

                    pnlMatrix.Controls.Add(btn);
                    Matrix[i].Add(btn);

                    oldBtn = btn;
                }
                oldBtn = new Button() { Width = 0, Height = 0, Location = new Point(-Cons.margin, oldBtn.Location.Y + Cons.dateButtonHeight) };

            }
            SetDefaultDate();
        }

        void btn_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty((sender as Button).Text))
                return;

            DailyPlan daily = new DailyPlan(new DateTime(dtpkDate.Value.Year, dtpkDate.Value.Month, Convert.ToInt32((sender as Button).Text)), Job);
            daily.ShowDialog();
        }

        int DayOfMonth(DateTime date)
        {
            switch (date.Month)
            {
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                case 2:
                    if ((date.Year % 4 == 0 && date.Year % 100 != 0) || (date.Year % 400 == 0))
                        return 29;
                    else
                        return 28;
                default:
                    return 31;
            }
        }

        void AddNumberIntoMatrixByDay(DateTime date)
        {
            ClearMatrix();
            DateTime useDate = new DateTime(date.Year, date.Month, 1);
            int line = 0;
            
            for (int i = 1; i <= DayOfMonth(date); i++)
            {
                int column = dateOfWeek.IndexOf(useDate.DayOfWeek.ToString());
                Button btn = Matrix[line][column];
                btn.Text = i.ToString();

                if (isEqualDate(useDate, DateTime.Now))
                    btn.BackColor = Color.Yellow;
                else
                    btn.BackColor = Color.White;

                if (isEqualDate(useDate, date))
                    btn.BackColor = Color.Aqua;

                if (column >= 6)
                    line++;
                useDate = useDate.AddDays(1);            }

        }

        bool isEqualDate(DateTime date1, DateTime date2)
        {
            return date1.Year == date2.Year && date1.Month == date2.Month && date1.Day == date2.Day;
        }

        void ClearMatrix()
        {
            for (int i = 0; i < Matrix.Count; i++)
                for (int j = 0; j < Matrix[i].Count; j++)
                {
                    Button btn = Matrix[i][j];
                    btn.Text = "";
                    btn.BackColor = Color.White;
                }    
        }

        void SetDefaultDate()
        {
            dtpkDate.Value = DateTime.Now;
        }

        private void dtpkDate_ValueChanged(object sender, EventArgs e)
        {
            AddNumberIntoMatrixByDay((sender as DateTimePicker).Value);
        }

        private void btnPrevious_Click(object sender, EventArgs e)
        {
            dtpkDate.Value = dtpkDate.Value.AddMonths(-1);
        }

        private void btnNext_Click(object sender, EventArgs e)
        {
            dtpkDate.Value = dtpkDate.Value.AddMonths(1);
        }

        private void btnToday_Click(object sender, EventArgs e)
        {
            SetDefaultDate();
        }

        private void SerializeToXML(object data, string filePath)
        {
            FileStream fs = new FileStream(filePath, FileMode.OpenOrCreate, FileAccess.Write);
            XmlSerializer sr = new XmlSerializer(typeof(PlanData));
            sr.Serialize(fs, data);

            fs.Close();
        }

        private object DeserializeFromXML(string filePath)
        {
            FileStream fs = new FileStream(filePath, FileMode.OpenOrCreate, FileAccess.Read);
            try
            {
                XmlSerializer sr = new XmlSerializer(typeof(PlanData));
                object result = sr.Deserialize(fs);
                fs.Close();
                return result;
            } catch (Exception e)
            {
                fs.Close();
                throw e;
            }

            return null;
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            SerializeToXML(Job, filePath);
        }

        private void tmNotify_Tick(object sender, EventArgs e)
        {
            if (!ckbNotify.Checked)
                return;

            appTime++;

            if (appTime <= Cons.notifyTime)
                return;
            if (Job == null || Job.Job == null)
                return;
            DateTime current = DateTime.Now;
            List<PlanItem> todayJobs = Job.Job.Where(p=>p.Date.Year == current.Date.Year && p.Date.Month == current.Date.Month && p.Date.Day == current.Date.Day).ToList();
            Notify.ShowBalloonTip(Cons.notifyTimeOut, "Lịch công việc", string.Format("Bạn có {0} công việc trong ngày hôm nay", todayJobs.Count), ToolTipIcon.Info);
            
            appTime = 0;
        }

        private void nmNotify_ValueChanged(object sender, EventArgs e)
        {
            Cons.notifyTime = (int)nmNotify.Value;
        }

        private void ckbNotify_CheckedChanged(object sender, EventArgs e)
        {
            nmNotify.Enabled = ckbNotify.Checked;
        }
    }
}
