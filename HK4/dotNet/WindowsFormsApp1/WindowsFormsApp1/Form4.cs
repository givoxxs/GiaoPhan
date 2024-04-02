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
    public partial class Form4 : Form
    {
        public Point ps { get; set; }
        public Form4()
        {
            InitializeComponent();
        }

        private void Form4_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                ps = e.Location;
            }
        }

        private void Form4_MouseMove(object sender, MouseEventArgs e)
        {
//           if (e.Button == MouseButtons.Left)
//           {
//                Graphics g = this.CreateGraphics();
//                Pen p = new Pen(Color.Red, 1);
//                g.DrawLine(p, ps, e.Location);
//            } 
        }

        private void Form4_MouseUp(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                Graphics g = this.CreateGraphics();
                Pen p = new Pen(Color.Blue, 1);
                g.DrawLine(p, ps, e.Location);
            }
        }

        private void Form4_KeyPress(object sender, KeyPressEventArgs e)
        {
            label1.Text = "keyChar = " + e.KeyChar;
        }

        private void label1_PreviewKeyDown(object sender, PreviewKeyDownEventArgs e)
        {

        }

        private void Form4_KeyDown(object sender, KeyEventArgs e)
        {
            label2.Text = "KeyCode = " + e.KeyCode + "\n"
                        + "KeyData = " + e.KeyData + "\n"
                        + "KeyValue = " + e.KeyValue + "\n"
                        + "Modifier = " + e.Modifiers;
        }

        private void Form4_Load(object sender, EventArgs e)
        {

        }
    }
}
