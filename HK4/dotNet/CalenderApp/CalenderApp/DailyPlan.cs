using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalenderApp
{
    public partial class DailyPlan : Form
    {
        private DateTime date;
        private PlanData job;
        FlowLayoutPanel fPanel = new FlowLayoutPanel();
        public DailyPlan(DateTime date, PlanData job)
        {
            InitializeComponent();

            this.Date = date;
            this.Job = job;
            
            fPanel.Width = pnJob.Width;
            fPanel.Height = pnJob.Height;
            pnJob.Controls.Add(fPanel);

            dtpkDate.Value = Date;
        }

        public DateTime Date { get => date; set => date = value; }
        public PlanData Job { get => job; set => job = value; }

        void ShowJobByDate(DateTime date) 
        {
            fPanel.Controls.Clear();

            if (Job != null )
            {
                List<PlanItem> todayJobs = GetJobsByDay(date);
                for (int i = 0; i < todayJobs.Count; i++)
                {
                    AddJob(todayJobs[i]);
                }
            }
        }

        void AddJob(PlanItem job)
        {
            AJob aJob = new AJob(job);

            aJob.Edited += aJob_Edited;
            aJob.Deleted += aJob_Deleted;

            fPanel.Controls.Add(aJob);
        }

        void aJob_Edited(object sender, EventArgs e)
        {
            
        }

        void aJob_Deleted(object sender, EventArgs e)
        {
            AJob uc = sender as AJob;
            PlanItem job = uc.Job;

            fPanel.Controls.Remove(uc);
            Job.Job.Remove(job);
        }

        List<PlanItem> GetJobsByDay(DateTime date)
        {
            return Job.Job.Where(p => p.Date.Year == date.Year && p.Date.Month == date.Month && p.Date.Day == date.Day).ToList();
        }
        private void dtpkDate_ValueChanged(object sender, EventArgs e)
        {
            ShowJobByDate((sender as DateTimePicker).Value);
        }

        private void btnPreviousDay_Click(object sender, EventArgs e)
        {
            dtpkDate.Value = dtpkDate.Value.AddDays(-1);
        }

        private void btnNextDay_Click(object sender, EventArgs e)
        {
            dtpkDate.Value = dtpkDate.Value.AddDays(1);
        }

        private void mnsiAddJob_Click(object sender, EventArgs e)
        {
            PlanItem item = new PlanItem() {Date = dtpkDate.Value};
            Job.Job.Add(item);
            AddJob(item);

        }

        private void mnsiToday_Click(object sender, EventArgs e)
        {
            dtpkDate.Value = DateTime.Now;
        }
    }
}
