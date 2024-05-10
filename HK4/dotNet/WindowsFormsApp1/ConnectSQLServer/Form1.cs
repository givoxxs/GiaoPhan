using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace ConnectSQLServer
{
    public partial class Form1 : Form
    {
        // Create 2 variables to store the connection string and the connection object
        string connectionString = "Data Source=DESKTOP-3VJGJ9O;Initial Catalog=TestDB;Integrated Security=True";
        // Create a connection object
        SqlConnection connection = null;
        public Form1()
        {
            InitializeComponent();
        }

        private void btnBeginConnect_Click(object sender, EventArgs e)
        {
            try
            {
                if (connection == null)
                {
                    connection = new SqlConnection(connectionString);
                    MessageBox.Show("Connection is created");
                }
                else
                {
                    MessageBox.Show("Connection is already created");
                }
                // Open the connection
                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                    MessageBox.Show("Connection is opened");
                }
                else
                {
                    MessageBox.Show("Connection is already opened");
                }
            } 
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnCloseConnect_Click(object sender, EventArgs e)
        {
            if (connection != null && connection.State == ConnectionState.Open)
            {
                connection.Close();
                MessageBox.Show("Connection is closed");
            } 
            else
            {
                MessageBox.Show("Connection is already closed");
            }
        }
    }
}
