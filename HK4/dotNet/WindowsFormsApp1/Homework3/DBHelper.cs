using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Homework3
{
    public class DBHelper
    {
        private static DBHelper _Instance;
        private SqlConnection _cnn;

        public static DBHelper Instance
        {
            get
            {
                if (_Instance == null)
                {
                    string s = @"Data Source = GIVOXXS\SQLEXPRESS; Initial Catalog = Student_Management; Integrated Security = True;";
                    _Instance = new DBHelper(s);
                }
                return _Instance;
            }
            private set { }
        }

        private DBHelper(string s)
        {
            _cnn = new SqlConnection(s);
        }

        public void ExecuteDB(string query)
        {
            SqlCommand cmd = new SqlCommand(query, _cnn);
            _cnn.Open();
            cmd.ExecuteNonQuery();
            _cnn.Close();
        }
        public DataTable GetRecords(string query)
        {
            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(query, _cnn);
            _cnn.Open();
            da.Fill(dt);
            _cnn.Close();
            return dt;
        }

        public void Add(Student s)
        {
            string query = $"INSERT INTO sinhvienDUT VALUES('{s.MSSV}', '{s.Name}', '{s.Class}', {s.DTB}, " +
                $"{(s.Gender ? 1 : 0)} , '{s.NS.ToString("yyyy-MM-dd")}' )";
            ExecuteDB(query);
        }

        public void Update(Student s)
        {
            string query = $"UPDATE sinhvienDUT SET Name = '{s.Name}' , Class = '{s.Class}', DTB = '{s.DTB}' " +
                    $", Gender = {(s.Gender ? 1 : 0)}, NS = '{s.NS.ToString("yyyy-MM-dd")}' WHERE MSSV = '{s.MSSV}'";
            ExecuteDB(query);
        }

        public void Delete(string MSSV)
        {
            string query = $"DELETE FROM sinhvienDUT WHERE MSSV = '{MSSV}'";
            ExecuteDB(query);
        }

        public List<Student> GetAllStudents()
        {
            List<Student> students = new List<Student>();
            string query = "SELECT * FROM sinhvienDUT";
            DataTable dt = GetRecords(query);
            foreach (DataRow row in dt.Rows)
            {
                Student s = new Student
                {
                    MSSV = row["MSSV"].ToString(),
                    Name = row["Name"].ToString(),
                    Class = row["Class"].ToString(),
                    DTB = Convert.ToDouble(row["DTB"]),
                    Gender = Convert.ToBoolean(row["Gender"]),
                    NS = Convert.ToDateTime(row["NS"])
                };
                students.Add(s);
            }
            return students;
        }
    }
}
