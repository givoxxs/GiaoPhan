using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
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
    }
}
