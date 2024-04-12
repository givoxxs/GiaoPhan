using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Homework3
{
    public partial class DetailForm : Form
    {
        private string selectedMSSV { get; set; }
        private string selectedName;
        private string selectedClass;
        private double selectedDTB;
        private bool selectedGender;
        private DateTime selectedNS;
        private bool isEditing = false;
        public DetailForm()
        {
            InitializeComponent();
            DetailComboBox();
        }
        // DetailForm for edit student
        public DetailForm(string mssv, string name, string studentClass, double dtb, bool gender, DateTime ns)
        {
            InitializeComponent();
            DetailComboBox();
            isEditing = true;

            selectedMSSV = mssv;
            selectedName = name;
            selectedClass = studentClass;
            selectedDTB = dtb;
            selectedGender = gender;
            selectedNS = ns;

            textBoxMSSV.Text = mssv;
            textBoxName.Text = name;
            comboBoxClass.SelectedItem = studentClass;
            textBoxDTB.Text = dtb.ToString();
            if (gender)
            {
                radioButtonMale.Checked = true;
            }
            else
            {
                radioButtonFemale.Checked = true;
            }
            dateTimePicker1.Value = ns;

        }
        // not important to me
        private void label3_Click(object sender, EventArgs e)
        {

        }
        // not important to me
        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }
        // load class to comboBox
        private void DetailComboBox ()
        {
            comboBoxClass.Items.AddRange(new string[] { "22T_DT1", "22T_DT2", "22T_DT3", "22T_DT4", "22T_DT5" });
        }
        // radio button
        private void radioGender(object sender, EventArgs e)
        {
            radioButtonMale.CheckedChanged += new EventHandler(GenderChecked);
            radioButtonFemale.CheckedChanged += new EventHandler(GenderChecked);
        }
        // only one radio button can be checked
        private void GenderChecked(object sender, EventArgs e)
        {
            RadioButton selectedRadio = (RadioButton)sender;
            if (selectedRadio.Checked)
            {
                foreach (Control control in groupBoxGender.Controls)
                {
                    if (control is RadioButton && control != selectedRadio)
                    {
                        ((RadioButton)control).Checked = false;
                    }
                }
            }
        }
        // get student from form
        public Student GetStudent()
        {
            Student student = new Student();
            student.MSSV = textBoxMSSV.Text;
            student.Name = textBoxName.Text;
            student.Class = comboBoxClass.SelectedItem?.ToString();
            student.DTB = double.Parse(textBoxDTB.Text);
            student.NS = dateTimePicker1.Value.Date;
            student.Gender = radioButtonMale.Checked ? true : false;

            return student;
        }
        // check if MSSV already exists
        private bool IsMSSV(string mssv)
        {
        
            List<Student> students = CSDL.Instance.GetAllStudent();


            foreach (Student student in students)
            {
                if (isEditing)
                {
                    if (student.MSSV == mssv && student.MSSV != selectedMSSV)
                    {
                        return true;
                    }
                } else
                {
                    if (student.MSSV == mssv)
                    {
                        return true;
                    }
                }
                
            }
            return false;
        }
        // check if all information is filled and MSSV is unique > OK
        private void buttonOk_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(textBoxMSSV.Text) || string.IsNullOrWhiteSpace(textBoxName.Text) ||
                    comboBoxClass.SelectedItem == null || string.IsNullOrWhiteSpace(textBoxDTB.Text))
            {
                MessageBox.Show("Please complete all information.");
                return;
            }

            if (IsMSSV(textBoxMSSV.Text))
            {
                MessageBox.Show("MSSV already exists in the data.");
                return;
            }
            this.DialogResult = DialogResult.OK;
        }
        // cancel
        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }
        
    }
}
