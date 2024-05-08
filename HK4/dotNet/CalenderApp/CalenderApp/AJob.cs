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
    public partial class AJob : UserControl
    {
        private PlanItem job;
        public AJob(PlanItem job)
        {
            InitializeComponent();

            cbStatus.DataSource = PlanItem.statusList;

            this.Job = job;

            ShowInfo();
        }

        public PlanItem Job { get => job; set => job = value; }

        private event EventHandler edited;
        public event EventHandler Edited
        {
            add
            {
                edited += value;
            }
            remove
            {
                edited -= value;
            }
        }

        private event EventHandler deleted;
        public event EventHandler Deleted
        {
            add
            {
                deleted += value;
            }
            remove
            {
                deleted -= value;
            }
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        void ShowInfo()
        {
            txtJob.Text = Job.Job;
            nmFromHours.Value = Job.FromTime.X;
            nmFromMinutes.Value = Job.FromTime.Y;
            nmToHours.Value = Job.ToTime.X;
            nmToMinutes.Value = Job.ToTime.Y;
            cbStatus.SelectedIndex = PlanItem.statusList.IndexOf(Job.Status);
            ckbDone.Checked = (PlanItem.statusList.IndexOf(Job.Status) == (int)EPlanItem.DONE ? true : false);
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            Job.Job = txtJob.Text;
            Job.FromTime = new Point((int)nmFromHours.Value, (int)nmFromMinutes.Value);
            Job.ToTime = new Point((int)nmToHours.Value, (int)nmToMinutes.Value);
            Job.Status = cbStatus.SelectedItem.ToString();
                //PlanItem.statusList[cbStatus.SelectedIndex];

            if (edited != null)
            {
                edited(this, new EventArgs());
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (deleted != null)
            {
                deleted(this, new EventArgs());
            }
        }

        private void ckbDone_CheckedChanged(object sender, EventArgs e)
        {
            cbStatus.SelectedIndex = (ckbDone.Checked ? (int)EPlanItem.DONE : (int)EPlanItem.DOING);
        }
    }
}
