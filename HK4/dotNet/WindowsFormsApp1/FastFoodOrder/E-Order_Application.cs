using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FastFoodOrder
{
    public partial class Form1 : Form
    {
        DataTable[] dataTableOrder = new DataTable[3];
        int index = 0;
        public Form1()
        {
            InitializeComponent();
            LoadingComboBox();
            //dataTableOrder = new DataTable[comboBoxBill.Items.Count];
            Initialize();
        }
        public void LoadingComboBox()
        {
            comboBoxBill.Items.Add("Table 1");
            comboBoxBill.Items.Add("Table 2");
            comboBoxBill.Items.Add("Table 3");

            comboBoxBill.SelectedIndex = 0;
        }

        private void button16_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
        public void Initialize()
        {
            
            for (int i = 0; i < comboBoxBill.Items.Count; i++)
            {
                dataTableOrder[i] = new DataTable();
                dataTableOrder[i].Columns.AddRange(new DataColumn[]
                {
                    new DataColumn {DataType = typeof(string), ColumnName = "Food"},
                    new DataColumn {DataType = typeof(int), ColumnName = "Quantity"},
                });
            }
            
        }
        private void buttonFoodClick(object sender, EventArgs e)
        {
            Button button = sender as Button;
            string foodName = button.Text;

            DataRow[] rows = dataTableOrder[index].Select($"Food = '{foodName}'");
            if (rows.Length > 0)
            {
                rows[0]["Quantity"] = Convert.ToInt32(rows[0]["Quantity"]) + 1;
            }
            else
            {
                dataTableOrder[index].Rows.Add(foodName, 1);
            }

            RefreshDataGridView();
        }
        public void RefreshDataGridView()
        {
            int selectedIndex = comboBoxBill.SelectedIndex;
            dataGridView1.DataSource = dataTableOrder[selectedIndex];
            index = selectedIndex;
            
        }
        private void comboBoxBill_SelectedIndexChanged()
        {
            RefreshDataGridView();
        }

        private void buttonDel_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                DataRow row = dataTableOrder[index].Rows[dataGridView1.SelectedRows[0].Index];
                row.Delete();
                RefreshDataGridView(sender, e);
            } else
            {
                MessageBox.Show("Please select item to delete.");
            }
        }

        private void buttonOrder_Click(object sender, EventArgs e)
        {
            if (dataGridView1.Rows.Count > 0)
            {
                StringBuilder sb = new StringBuilder();
                sb.AppendLine($"{comboBoxBill.SelectedItem}");
                foreach (DataRow row in dataTableOrder[index].Rows)
                {
                    sb.AppendLine($"{row["Food"]} x {row["Quantity"]}");
                }
                MessageBox.Show(sb.ToString(), "Order");
            } else
            {
                MessageBox.Show("Please order something.", "Order");
            }   
        }
    }
}
