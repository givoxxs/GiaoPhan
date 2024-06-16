using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _102220129_PhanVanToan.DTO
{
    public class Book
    {
        [Key]
        public string IdBook { get; set; }
        public string Title { get; set; }
        public int Quantity { get; set; }
        public DateTime PublishedDate { get; set; }
        public bool Rent { get; set; }
        public string CategoryId { get; set; }
        [ForeignKey("CategoryId")]
        public virtual Category Categories { get; set; }
    }
}
