using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _102220129_PhanVanToan.DTO
{
    public class SV
    {
        [Key]
        public string MSSV { get; set; }
        public string NameSV { get; set; }
        public bool Gender { get; set; }
        public DateTime NS { get; set; }
        public double DTB { get; set; }
        public string ID_Lop { get; set; }
        [ForeignKey("ID_Lop")]
        public virtual LSH LSH { get; set; }
    }
}
