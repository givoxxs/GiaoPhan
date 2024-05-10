using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace Homework3
{
    public partial class MainForm : Form
    {
        // CSDL data = CSDL.Instance;
        DBHelper data = DBHelper.Instance;
        public MainForm()
        {
            InitializeComponent();
            SetDGV();
            addClassToList();
            addColumnsToComboBoxSort();
        }
        // show All data in DataGridView
        public void SetDGV()
        {
            string query = "select * from sinhvienDUT";
            dataGridView1.DataSource = data.GetRecords(query);
        }
        // add class to comboBoxClass
        public void addClassToList()
        {
            List<string> classes = data.GetAllStudents()
                .Select(student => student.Class)
                .Distinct()
                .ToList();

            classes.Insert(0, "All");
            listClass.Items.AddRange(classes.ToArray());
        }
        // show students in class by selected class
        private void listClass_SelectedIndexChanged(object sender, EventArgs e)
        {
            string selectedClass = listClass.SelectedItem.ToString();
            if (selectedClass == "All")
            {
                SetDGV();
            } else
            {
                List<Student> studentsInClass = data.GetAllStudents()
                .Where(student => student.Class == selectedClass)
                .ToList();

                dataGridView1.DataSource = studentsInClass;
            }
        }
        // search student by name
        private void buttonSearch_Click(object sender, EventArgs e)
        {
            string searchText = textBoxSearch.Text.Trim();
            
            if (searchText == "")
            {   
                MessageBox.Show("Please enter search text");
                // SetDGV();
                return;
            } 
            
            List<Student> resultSearch = data.GetAllStudents()
                .Where(student => student.Name.ToLower().Contains(searchText.ToLower()))
                .ToList();
            if (resultSearch.Count  == 0)
            {
                MessageBox.Show("No result found");
            }
            else
            {
                dataGridView1.DataSource = resultSearch;
            }
        }
        // add student
        private void button1_Click(object sender, EventArgs e)
        {
            using (DetailForm detailForm = new DetailForm())
            {
                if (detailForm.ShowDialog() == DialogResult.OK)
                {
                    Student student = detailForm.GetStudent();
                    data.Add(student);
                    SetDGV();
                }   
            }   
        }
        // edit student
        private void button2_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                DataGridViewRow selectedRow = dataGridView1.SelectedRows[0];
                string MSSV = selectedRow.Cells["MSSV"].Value.ToString();
                string Name = selectedRow.Cells["Name"].Value.ToString();
                string Class = selectedRow.Cells["Class"].Value.ToString();
                double DTB = Convert.ToDouble(selectedRow.Cells["DTB"].Value);
                bool Gender = Convert.ToBoolean(selectedRow.Cells["Gender"].Value);
                DateTime NS = Convert.ToDateTime(selectedRow.Cells["NS"].Value);

                using (DetailForm editForm = new DetailForm(MSSV, Name, Class, DTB, Gender, NS))
                {
                    if (editForm.ShowDialog() == DialogResult.OK)
                    {
                        Student editStudent = editForm.GetStudent();
                        // update data
                        data.Update(editStudent);
                        SetDGV();
                    }
                }
            } else
            {
                MessageBox.Show("Please select a student to edit.");
            } 
        }
        private DBHelper GetData()
        {
            return data;
        }
        // delete student
        private void button3_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                DataGridViewRow selectedRow = dataGridView1.SelectedRows[0];
                string MSSV = selectedRow.Cells["MSSV"].Value.ToString();
                data.Delete(MSSV);
                SetDGV();
            } else
            {
                MessageBox.Show("Please select a student to delete.");
            }
        }
        // add column name to comboBoxSort
        private void addColumnsToComboBoxSort()
        {
            foreach (DataGridViewColumn column in dataGridView1.Columns)
            {
                comboBoxSort.Items.Add(column.HeaderText);
            }
            comboBoxSort.SelectedIndex = 0;
        }
        // sort DataGridView by selected column
        private void button4_Click(object sender, EventArgs e)
        {
            if (comboBoxSort.SelectedItem != null)
            {
                string selectedColumn = comboBoxSort.SelectedItem.ToString();
                SortDataGridView(selectedColumn);
            }
            else
            {
                MessageBox.Show("Please select a column to sort.");
            }
        }
        // choose sort type
        private void comboBoxSort_SelectedIndexChanged(object sender, EventArgs e)
        {
            button4.Enabled = true;
        }
        // sort DataGridView
        private void SortDataGridView(string column)
        {
            List<Student> students = data.GetAllStudents();
            switch (column)
            {
                case "MSSV":
                    dataGridView1.DataSource = students.OrderBy(student => student.MSSV).ToList();
                    break;
                case "Name":
                    dataGridView1.DataSource = students.OrderBy(student => student.Name).ToList();
                    break;
                case "Class":
                    dataGridView1.DataSource = students.OrderBy(student => student.Class).ToList();
                    break;
                case "DTB":
                    dataGridView1.DataSource = students.OrderBy(student => student.DTB).ToList();
                    break;
                case "Gender":
                    dataGridView1.DataSource = students.OrderBy(student => student.Gender).ToList();
                    break;
                case "NS":
                    dataGridView1.DataSource = students.OrderBy(student => student.NS).ToList();
                    break;  
            }
        }
    }
}
