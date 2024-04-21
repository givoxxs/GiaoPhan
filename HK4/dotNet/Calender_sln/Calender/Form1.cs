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
    public partial class Form1 : Form
    {
        int month, year;
        //lets create a static variable to hold the current date
        public static string staticMonth, staticYear;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            displayDays();
        }
        private void displayDays()
        {
            DateTime now = DateTime.Now;
            month = now.Month;
            year = now.Year;
            //get the first day of the month
            lbDayNow.Text = now.ToString("MMMM") + " " + now.Year;

            staticMonth = month + "";
            staticYear = year + "";
            DateTime firstDayOfMonth = new DateTime(year, month, 1);
            //get the count of days in the month
            int daysInMonth = DateTime.DaysInMonth(year, month);
            //convert the first day of the month to a number
            int firstDay = Convert.ToInt32(firstDayOfMonth.DayOfWeek.ToString("d")) + 1;
            //first lets create a blank control
            for (int i = 1; i < firstDay; i++)
            {
                UserControlBlank ucblank = new UserControlBlank();
                dayContainer.Controls.Add(ucblank);
            }
            //create user control for each day in the month
            for (int i = 1; i <= daysInMonth; i++)
            {
                UserControlDays ucDays = new UserControlDays();
                ucDays.Days(i);
                dayContainer.Controls.Add(ucDays);
            }
        }

        private void btnPrev_Click(object sender, EventArgs e)
        {
            //clear the controls
            dayContainer.Controls.Clear();
            //decrement the month to the next month
            month--;
            staticMonth = month + "";
            staticYear = year + "";
            lbDayNow.Text = new DateTime(year, month, 1).ToString("MMMM") + " " + year;
            //get the first day of the month
            DateTime firstDayOfMonth = new DateTime(year, month, 1);
            //get the count of days in the month
            int daysInMonth = DateTime.DaysInMonth(year, month);
            //convert the first day of the month to a number

            int firstDay = Convert.ToInt32(firstDayOfMonth.DayOfWeek.ToString("d")) + 1;

            //first lets create a blank control
            for (int i = 1; i < firstDay; i++)
            {
                UserControlBlank ucblank = new UserControlBlank();
                dayContainer.Controls.Add(ucblank);
            }
            //create user control for each day in the month
            for (int i = 1; i <= daysInMonth; i++)
            {
                UserControlDays ucDays = new UserControlDays();
                ucDays.Days(i);
                dayContainer.Controls.Add(ucDays);
            }
        }

        private void btnNext_Click(object sender, EventArgs e)
        {
            //clear the controls
            dayContainer.Controls.Clear();
            //increment the month to the next month
            month++;
            staticMonth = month + "";
            staticYear = year + "";
            lbDayNow.Text = new DateTime(year, month, 1).ToString("MMMM") + " " + year;
            //get the first day of the month
            DateTime firstDayOfMonth = new DateTime(year, month, 1);
            //get the count of days in the month
            int daysInMonth = DateTime.DaysInMonth(year, month);
            //convert the first day of the month to a number

            int firstDay = Convert.ToInt32(firstDayOfMonth.DayOfWeek.ToString("d")) + 1;

            //first lets create a blank control
            for (int i = 1; i < firstDay; i++)
            {
                UserControlBlank ucblank = new UserControlBlank();
                dayContainer.Controls.Add(ucblank);
            }
            //create user control for each day in the month
            for (int i = 1; i <= daysInMonth; i++)
            {
                UserControlDays ucDays = new UserControlDays();
                ucDays.Days(i);
                dayContainer.Controls.Add(ucDays);
            }
        }
    }
}
