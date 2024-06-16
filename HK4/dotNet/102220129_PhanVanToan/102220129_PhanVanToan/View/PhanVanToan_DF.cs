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
        string IdBOOK; 
        public PhanVanToan_DF(string mssv = null)
        {
            InitializeComponent();
            this.IdBOOK = mssv;
            SetCBBLSH2();
            LoadDetail();   
        }
        public void SetCBBLSH2()
        {
            this.cbbCategory.Items.Clear();
            this.cbbCategory.Items.AddRange(BLL_QLTV.Instance.GetCBBItems().ToArray());
            this.cbbCategory.SelectedIndex = 0;
            this.cbbCategory.DropDownStyle = ComboBoxStyle.DropDownList;
        }
        public void LoadDetail()
        {
            rdbtnCan.Checked = true;
            if (IdBOOK == null)
            {
                this.Text = "Add Student";
                txtQuantity.Text = "0";
                cbbCategory.SelectedIndex = 1;
            }
            else
            {
                this.Text = "Edit Student";
                txtId.Text = IdBOOK;
                txtId.Enabled = false;
                var data = BLL_QLTV.Instance.GetBookById(IdBOOK);
                txtName.Text = data.Title;
                dtpkDate.Value = data.PublishedDate;
                txtQuantity.Text = data.Quantity.ToString();
                cbbCategory.SelectedIndex = cbbCategory.FindStringExact(data.Categories.Category_Name);
                if(!data.Rent)
                {
                    rdbtnCant.Checked = true;
                }
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            if (txtId.Text == "" || txtName.Text == "" || txtQuantity.Text == "" || !isNumeric(txtQuantity.Text))
            {
                MessageBox.Show("Vui lòng nhập chính xác thông tin");
                return;
            }
            var data = new Book
            {
                IdBook = txtId.Text,
                Title = txtName.Text,
                Rent = (rdbtnCan.Checked == true) ? true : false,
                PublishedDate = dtpkDate.Value,
                Quantity = Convert.ToInt32(txtQuantity.Text),
                CategoryId = ((CBBItem)cbbCategory.SelectedItem).Value.ToString()
            };

            if (IdBOOK == null)
            {
                if (!CheckExist(txtId.Text))
                {
                    MessageBox.Show("Mã Sách đã tồn tại");
                    return;
                }
                BLL_QLTV.Instance.AddSV(data);
            } else
            {
                BLL_QLTV.Instance.EditSV(data);
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
            var data = BLL_QLTV.Instance.GetBookById(s);    

            return (data == null) ? true : false;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
