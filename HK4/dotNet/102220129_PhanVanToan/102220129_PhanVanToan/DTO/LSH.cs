using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _102220129_PhanVanToan.DTO
{
    public class LSH
    {
        public LSH()
        {
            SVs = new HashSet<SV>();
        }
        [Key]
        public string ID_Lop { get; set; }
        public string NameLop { get; set; }
        public virtual ICollection<SV> SVs { get; set; }
    }
}
