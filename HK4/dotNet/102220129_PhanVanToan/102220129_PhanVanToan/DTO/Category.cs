using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _102220129_PhanVanToan.DTO
{
    public class Category
    {
        public Category()
        {
            Books = new HashSet<Book>();
        }
        [Key]
        public string Category_ID { get; set; }
        public string Category_Name { get; set; }
        public virtual ICollection<Book> Books { get; set; }
    }
}
