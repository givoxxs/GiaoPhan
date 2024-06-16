using _102220129_PhanVanToan.DTO;
using System;
using System.Data.Entity;
using System.Linq;

namespace _102220129_PhanVanToan.DAL
{
    public class QLTV : DbContext
    {
        public QLTV()
            : base("name=QLTV")
        {
            Database.SetInitializer<QLTV>(new CreateDB());
        }
        public virtual DbSet<Book> Books { get; set; }
        public virtual DbSet<Category> Categories { get; set; }
    }
}