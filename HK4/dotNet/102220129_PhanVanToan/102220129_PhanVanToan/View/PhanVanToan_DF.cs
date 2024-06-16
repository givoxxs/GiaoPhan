using _102220129_PhanVanToan.BLL;
using _102220129_PhanVanToan.DTO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace _102220129_PhanVanToan.View
{
    public partial class PhanVanToan_DF : Form
    {
        public delegate void MyDel();
        public MyDel ShowData;
        string MsSV;
        public PhanVanToan_DF(string mssv = null)
        {
            InitializeComponent();
            this.MsSV = mssv;
            SetCBBLSH2();
            LoadDetail();   
        }
        public void SetCBBLSH2()
        {
            this.cbbLSH2.Items.Clear();
            this.cbbLSH2.Items.AddRange(BLL_QLSV.Instance.GetCBBItems().ToArray());
            this.cbbLSH2.SelectedIndex = 0;
            this.cbbLSH2.DropDownStyle = ComboBoxStyle.DropDownList;
        }
        public void LoadDetail()
        {
            rdbtnMale.Checked = true;
            if (MsSV == null)
            {
                this.Text = "Add Student";
                txtDTB.Text = "0";
                cbbLSH2.SelectedIndex = 1;
            }
            else
            {
                this.Text = "Edit Student";
                txtMSSV.Text = MsSV;
                txtMSSV.Enabled = false;
                var data = BLL_QLSV.Instance.GetSVByMSSV(MsSV);
                txtName.Text = data.NameSV;
                dtpkNS.Value = data.NS;
                txtDTB.Text = data.DTB.ToString();
                cbbLSH2.SelectedIndex = cbbLSH2.FindStringExact(data.LSH.NameLop);
                if(!data.Gender)
                {
                    rdbtnFemale.Checked = true;
                }
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            if (txtMSSV.Text == "" || txtName.Text == "" || txtDTB.Text == "" || !isNumeric(txtDTB.Text))
            {
                MessageBox.Show("Vui lòng nhập chính xác thông tin");
                return;
            }
            var data = new SV
            {
                MSSV = txtMSSV.Text,
                NameSV = txtName.Text,
                Gender = (rdbtnMale.Checked == true) ? true : false,
                NS = dtpkNS.Value,
                DTB = Convert.ToDouble(txtDTB.Text),
                ID_Lop = ((CBBItem)cbbLSH2.SelectedItem).Value.ToString()
            };

            if (MsSV == null)
            {
                if (!CheckExist(MsSV))
                {
                    MessageBox.Show("Mã nhân viên đã tồn tại");
                    return;
                }
                BLL_QLSV.Instance.AddSV(data);
            } else
            {
                BLL_QLSV.Instance.EditSV(data);
            }
            ShowData();
            this.Dispose();
        }
        public bool isNumeric(string s)
        {
            return double.TryParse(s, out _);
        }
        public bool CheckExist(string s)
        {
            var data = BLL_QLSV.Instance.GetSVByMSSV(s);    

            return (data == null) ? true : false;
        }
    }
}
