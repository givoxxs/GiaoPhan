using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Management.Instrumentation;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace Calender
{
    public partial class EventForm : Form
    {
        //create a connection string
        string connectionString = "server=localhost;uid=root;pwd=;database=calender;sslmode=none";
        //already created a database using xampp

        public EventForm()
        {
            InitializeComponent();
        }

        private void EventForm_Load(object sender, EventArgs e)
        {
            // lets call the static variable from the user control
            txtDate.Text = Form1.staticYear + "-" + Form1.staticMonth + "-" + UserControlDays.staticDay;

            MySqlConnection conn = new MySqlConnection(connectionString);
            conn.Open();
            String sql = "SELECT * FROM calender where date = @date";
            MySqlCommand cmd = conn.CreateCommand();
            cmd.CommandText = sql;
            cmd.Parameters.AddWithValue("@date", Form1.staticYear + "-" + Form1.staticMonth + "-" + lbDays.Text);
            MySqlDataReader dr = cmd.ExecuteReader();
            if (dr.Read())
            {
                txtEvent.Text = dr["event"].ToString();
            }
            dr.Dispose();
            cmd.Dispose();
            conn.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            MySqlConnection conn = new MySqlConnection(connectionString);
            conn.Open();
            String sql = "INSERT INTO calender(date,event)values(?,?)";
            MySqlCommand cmd = conn.CreateCommand();
            cmd.CommandText = sql;
            cmd.Parameters.AddWithValue("date", txtDate.Text);
            cmd.Parameters.AddWithValue("event", txtEvent.Text);
            cmd.ExecuteNonQuery();
            MessageBox.Show("Event Saved");
            
            cmd.Dispose();
            conn.Close();
        }
    }
}
