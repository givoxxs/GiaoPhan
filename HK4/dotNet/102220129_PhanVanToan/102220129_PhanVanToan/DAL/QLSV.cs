using _102220129_PhanVanToan.DTO;
using System;
using System.Data.Entity;
using System.Linq;

namespace _102220129_PhanVanToan.DAL
{
    public class QLSV : DbContext
    {
        public QLSV()
            : base("name=QLSV")
        {
            Database.SetInitializer<QLSV>(new CreateDB());
        }
        public virtual DbSet<SV> SVs { get; set; }
        public virtual DbSet<LSH> LSHes { get; set; }
    }
}