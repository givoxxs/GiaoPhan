using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Exercise1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (char.IsDigit((char)e.KeyCode) && textBox1.Text.Length < 4)
            {
                textBox1.Text += (char)e.KeyCode;
            }
            else if (e.KeyCode == Keys.Back && textBox1.Text.Length > 0)
            {
                textBox1.Text = textBox1.Text.Remove(textBox1.Text.Length - 1);
            }
            else if (e.KeyCode == Keys.Enter || e.KeyCode == Keys.Return)
            {
                buttonE_Click(sender, e);
            }
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            //if (char.IsDigit(e.KeyChar) && textBox1.Text.Length < 4)
            //{
            //    textBox1.Text += e.KeyChar;
            //}
            //else if (e.KeyChar == 'c' || e.KeyChar == 'C')
            //{
            //    textBox1.Text = "";
            //}
            //else if (e.KeyChar == 'e' || e.KeyChar == 'E')
            //{
            //    buttonE_Click(sender, e);
            //}
        }

        private void button_Click(object sender, EventArgs e)
        {
            //Button temp = sender as Button;
            //if (temp !=  null && textBox1.Text.Length < 4)
            //{
            //    textBox1.Text += temp.Text;
            //}
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void buttonC_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
        }

        private void buttonE_Click(object sender, EventArgs e)
        {
            DateTime currentTime = DateTime.Now;

            if (textBox1.Text.Equals("1234"))
            {
                listBox1.Items.Add(currentTime.ToString() + "     Scientists!");
            } else
            {
                listBox1.Items.Add(currentTime.ToString() + "     Restricted Access!");
            }
        }

        private void formClosed(object sender, FormClosedEventArgs e)
        {
            StreamWriter writer = new StreamWriter(@"D:\GiaoPhan_Workspace\HK4\dotNet\Exercise1\Exercise1\pre_Data.txt", false);

            foreach (var i in listBox1.Items)
            {
                writer.WriteLine(i.ToString());
            }

            writer.Close();
        }

        private void formLoading(object sender, EventArgs e)
        {
            FileInfo source_file = new FileInfo(@"D:\GiaoPhan_Workspace\HK4\dotNet\Exercise1\Exercise1\pre_Data.txt");
            
            if (source_file.Exists) 
            {
                StreamReader stream = source_file.OpenText();
                string things = "";

                while ((things = stream.ReadLine()) != null)
                {
                    listBox1.Items.Add((string)things);
                }

                stream.Close();
            } else
            {
                MessageBox.Show("Không tìm thấy file!!!");
            }

        }


    }
}
