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
    public partial class Form3 : Form
    {
        public delegate void MyDel(string s);
        public MyDel d { get; set; }
        public Form3()
        {
            InitializeComponent();
        }

        private void txt31_TextChanged(object sender, EventArgs e)
        {
            d(txt31.Text);
        }
    }
}
