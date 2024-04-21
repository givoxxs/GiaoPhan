using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calender
{
    public partial class UserControlDays : UserControl
    {
        string connectionString = "server=localhost;uid=root;pwd=;database=calender;sslmode=none";
        // let us create another static variable to hold the current date
        public static string staticDay;
        public UserControlDays()
        {
            InitializeComponent();
            DisplayEvent();
        }

        private void UserControlDays_Load(object sender, EventArgs e)
        {

        }   
        public void Days(int numday)
        {
            lbDays.Text = numday + "";
            String constring = "server=localhost;user id =root; database = db_calendar; sslmode = none";
            MySqlConnection conn = new MySqlConnection(constring);
            conn.Open();
            string selectQuery = "SELECT Event FROM calendar WHERE Date = @Date";
            MySqlCommand selectCmd = new MySqlCommand(selectQuery, conn);
            String daynow = numday.ToString() + "/" + Form1.staticMonth + "/" + Form1.staticYear;
            selectCmd.Parameters.AddWithValue("@Date", daynow);

            MySqlDataReader reader = selectCmd.ExecuteReader();
            if (reader.Read())
            {
                lbEvent.Text = reader.GetString("Event");
            }
            reader.Close();
            conn.Close();
        }

        private void UserControlDays_Click(object sender, EventArgs e)
        {
            staticDay = lbDays.Text;
            //start timer if usercontrol is clicked
            timer1.Start();
            EventForm ef = new EventForm();
            ef.Show();
        }
        // method to display event
        private void DisplayEvent()
        {
            MySqlConnection conn = new MySqlConnection(connectionString);
            conn.Open();
            String sql = "SELECT * FROM calender where date = @date";
            MySqlCommand cmd = conn.CreateCommand();
            cmd.CommandText = sql;
            cmd.Parameters.AddWithValue("@date", Form1.staticYear + "-" + Form1.staticMonth + "-" + lbDays.Text );
            MySqlDataReader dr = cmd.ExecuteReader();
            if(dr.Read())
            {
                lbEvent.Text = dr["event"].ToString();
            }
            dr.Dispose();
            cmd.Dispose();  
            conn.Close();
        }

        //a timer for auto display of event if new event is added
        private void timer1_Tick(object sender, EventArgs e)
        {
            // call the display event method
            DisplayEvent();
        }

        private void lbEvent_Click(object sender, EventArgs e)
        {
            staticDay = lbDays.Text;
            //start timer if usercontrol is clicked
            timer1.Start();
            EventForm ef = new EventForm();
            ef.Show();
        }
        public void Event_(string ev)
        {
            lbEvent.Text = ev;
        }
    }
}
