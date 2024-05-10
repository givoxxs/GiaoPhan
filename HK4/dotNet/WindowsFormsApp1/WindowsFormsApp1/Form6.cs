using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
            SetLV();
            SetDGV();
        }

        public void SetLV()
        {
            listView1.Columns.AddRange(new ColumnHeader[]
            {
                new ColumnHeader(Text = "MSSV"),
                new ColumnHeader(Text = "NameSV"),
                new ColumnHeader(Text = "Gender"),
                new ColumnHeader(Text = "DTB"),
            });
            ListViewItem i1 = new ListViewItem { Text = "101" };
            i1.SubItems.AddRange(new ListViewItem.ListViewSubItem[]
            {
                new ListViewItem.ListViewSubItem { Text = "NVA" },
                new ListViewItem.ListViewSubItem { Text = "true" },
                new ListViewItem.ListViewSubItem { Text = "1.1" },
            });
            ListViewItem i2 = new ListViewItem { Text = "102" };
            i2.SubItems.AddRange(new ListViewItem.ListViewSubItem[]
            {
                new ListViewItem.ListViewSubItem { Text = "NVB" },
                new ListViewItem.ListViewSubItem { Text = "true" },
                new ListViewItem.ListViewSubItem { Text = "2.2" },
            });
            ListViewItem i3 = new ListViewItem { Text = "103" };
            i3.SubItems.AddRange(new ListViewItem.ListViewSubItem[]
            {
                new ListViewItem.ListViewSubItem { Text = "NVC" },
                new ListViewItem.ListViewSubItem { Text = "false" },
                new ListViewItem.ListViewSubItem { Text = "3.3" },
            });
            listView1.Items.Add(i1);
            listView1.Items.AddRange(new ListViewItem[] { i3, i2 });
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(listView1.SelectedItems.Count > 0)
            {
                string s = "";
                foreach(ListViewItem item in listView1.SelectedItems) 
                {
                    string MSSV = item.Text;
                    string Name = item.SubItems[1].Text;
                    s += MSSV + ", " + Name + "\n";
                }
                MessageBox.Show(s);
            }
        }

        public void SetDGV()
        {
            SV[] arr = new SV[]
            {
                new SV{MSSV = "101", Name = "NVA", Gender = true, DTB = 1.1},
                new SV{MSSV = "102", Name = "NVB", Gender = true, DTB = 2.2},
                new SV{MSSV = "103", Name = "NVC", Gender = false, DTB = 3.3},
            };
            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[]
            {
                new DataColumn {ColumnName = "MSSV", DataType = typeof(string)},
                new DataColumn {ColumnName = "Name", DataType = typeof(string)},
                new DataColumn {ColumnName = "Gender", DataType = typeof(bool)},
                new DataColumn {ColumnName = "DTB", DataType = typeof(double)},
            });
            foreach(SV i in arr)
            {
                dt.Rows.Add(i.MSSV, i.Name, i.Gender, i.DTB);
            }
            //dataGridView1.DataSource = arr;
            //dataGridView1.DataSource = arr.ToList();
            dataGridView1.DataSource = dt;
        }

        private void dataGridView1_RowHeaderMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if(dataGridView1.SelectedRows.Count > 0)
            {
                string s = "";
                foreach(DataGridViewRow i in dataGridView1.SelectedRows) 
                { 
                    string MSSV = i.Cells[0].Value.ToString();
                    string Name = i.Cells["Name"].Value.ToString();
                    s += MSSV + ", " + Name + "\n";
                }
                MessageBox.Show(s);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string s = @"Data Source=GIVOXXS\SQLEXPRESS;Initial Catalog=dotNetDut;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(s);
            string query = "select count (*) from SV";
            SqlCommand cmd = new SqlCommand(query, cnn);
            cnn.Open();
            int n = (int) cmd.ExecuteScalar();
            MessageBox.Show(n.ToString());
            cmd.ExecuteNonQuery();
            cnn.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string s = @"Data Source=GIVOXXS\SQLEXPRESS;Initial Catalog=dotNetDut;Integrated Security=True;";
            SqlConnection cnn = new SqlConnection(s);
            string query = "select * from SV";
            SqlCommand cmd = new SqlCommand(query, cnn);
            cnn.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            DataTable dataTable = new DataTable();
            dataTable.Columns.AddRange(new DataColumn[]
            {
                new DataColumn("MSSV", typeof(string)),
                new DataColumn("NameSV", typeof(string)),
                new DataColumn("DTB", typeof (double)),
                new DataColumn("Gender", typeof(bool)),
            });
            while (reader.Read())
            {
                dataTable.Rows.Add(reader[1].ToString(),
                    reader["NameSV"].ToString(),
                    Convert.ToDouble(reader[3].ToString()),
                    Convert.ToBoolean(reader["Gender"].ToString())
                );
            }
            cnn.Close ();
            dataGridView1.DataSource = dataTable;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            string s = @"Data Source=GIVOXXS\SQLEXPRESS;Initial Catalog=dotNetDut;Integrated Security=True;";
            SqlConnection cnn = new SqlConnection(s);
            string query = "select * from SV";
            SqlDataAdapter da = new SqlDataAdapter();
            DataSet ds = new DataSet();
            DataTable dt = new DataTable();
            cnn.Open();
            // da.Fill(ds);
            // da.Fill(ds, "SV");
            da.Fill( dt );
            cnn.Close();
            //dataGridView1.DataSource = ds.Tables[0];
            //dataGridView1.DataSource = ds.Tables["SV"];
            dataGridView1.DataSource = dt;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            string query = "select * from SV";
            dataGridView1.DataSource = DBHelper.Instance.GetRecords(query);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            string s = @"Data Source=GIVOXXS\SQLEXPRESS;Initial Catalog=dotNetDut;Integrated Security=True;";
            SqlConnection cnn = new SqlConnection(s);
            SqlParameter p1 = new SqlParameter("@Name", textBox1.Text);
            string query = "select * from SV where NameSV = @Name";
            SqlDataAdapter da = new SqlDataAdapter(query, cnn);
            da.SelectCommand.Parameters.Add(p1);
            DataTable dt = new DataTable();
            cnn.Open();
            da.Fill(dt);
            cnn.Close();
            dataGridView1.DataSource = dt;
        }

        private void button6_Click(object sender, EventArgs e)
        {
            string s = @"Data Source=GIVOXXS\SQLEXPRESS;Initial Catalog=dotNetDut;Integrated Security=True;";
            SqlConnection cnn = new SqlConnection(s);
            SqlParameter p1 = new SqlParameter("@Name", textBox1.Text);
            string query = "select * from SV where NameSV = @Name";
            SqlCommand cmd = new SqlCommand(query, cnn);
            cmd.Parameters.Add(p1);
            cnn.Open();
            SqlDataReader r = cmd.ExecuteReader();
            string result = "";
            while (r.Read())
            {
                result += r["MSSV"].ToString() + " " + r["NameSV"].ToString() + "\n";
            }

            MessageBox.Show(result);
            cnn.Close();
        }
    }
}
