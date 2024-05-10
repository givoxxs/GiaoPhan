using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homework3
{
    internal class CSDL
    {
        private DataTable _Dt;
        private static CSDL _Instance;
        public DataTable Dt
        {
            get { return _Dt; }
            private set { }
        }
        public static CSDL Instance
        {
            get
            {
                if (_Instance == null)
                {
                    _Instance = new CSDL();
                }
                return _Instance;
            }
            private set { }
        } 
        private CSDL()
        {
            _Dt = new DataTable();
            _Dt.Columns.AddRange(new DataColumn[]
            {
                new DataColumn {ColumnName = "MSSV", DataType = typeof(string)},
                new DataColumn {ColumnName = "Name", DataType = typeof(string)},
                new DataColumn {ColumnName = "Class", DataType = typeof(string)},
                new DataColumn {ColumnName = "DTB", DataType = typeof(double)},
                new DataColumn {ColumnName = "Gender", DataType = typeof(bool)},
                new DataColumn {ColumnName = "NS", DataType = typeof(DateTime)},
            });
            _Dt.Rows.Add("101", "NVA", "22T_DT1", 1.1, true, new DateTime(2000, 1, 1));
            _Dt.Rows.Add("102", "NVB", "22T_DT2", 2.2, true, new DateTime(2000, 2, 2));
            _Dt.Rows.Add("103", "NVC", "22T_DT3", 3.3, false, new DateTime(2000, 3, 3));
            _Dt.Rows.Add("104", "NVD", "22T_DT4", 4.4, true, new DateTime(2000, 4, 4));
            _Dt.Rows.Add("105", "NVE", "22T_DT5", 5.5, false, new DateTime(2000, 5, 5));
            _Dt.Rows.Add("106", "NVF", "22T_DT2", 6.6, true, new DateTime(2000, 6, 6));
        }
        public void Add(Student s)
        {
            _Dt.Rows.Add(s.MSSV, s.Name, s.Class, s.DTB, s.Gender, s.NS);
        }
        public void Update(Student s)
        {
            foreach (DataRow row in _Dt.Rows)
            {
                if (row["MSSV"].ToString() == s.MSSV)
                {
                    row["Name"] = s.Name;
                    row["Class"] = s.Class;
                    row["DTB"] = s.DTB;
                    row["Gender"] = s.Gender;
                    row["NS"] = s.NS;
                    break;
                }
            }
        }
        public void Delete(string MSSV)
        {
            DataRow row = _Dt.Select($"MSSV = '{MSSV}'").FirstOrDefault();
            if (row != null)
            {
                _Dt.Rows.Remove(row);
            }
        }
        public List<Student> GetAllStudent()
        {
            List<Student> data = new List<Student>();
            foreach(DataRow r in _Dt.Rows)
            {
                data.Add(new Student
                {
                    MSSV = r["MSSV"].ToString(),
                    Name = r["Name"].ToString(),
                    Class = r["Class"].ToString(),
                    DTB = Convert.ToDouble(r["DTB"]),
                    Gender = Convert.ToBoolean(r["Gender"]),
                    NS = Convert.ToDateTime(r["NS"]),
                });
            }

            return data;
        }
    }
}
