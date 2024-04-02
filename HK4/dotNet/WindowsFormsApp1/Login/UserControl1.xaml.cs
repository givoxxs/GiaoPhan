using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Login
{
    /// <summary>
    /// Interaction logic for UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        private string _User;
        private string _Password;
        public UserControl1()
        {
            InitializeComponent();
        }

        public string User
        {
            get
            {
                _User = txtUser.Text;
                return _User;
            }
            private set { }
        }

        public string Password
        {
            get
            {
                _Password = txtPw.Text;
                return _Password;
            }
            private set { }
        }
    }
}
