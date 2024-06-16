using _102220129_PhanVanToan.DAL;
using _102220129_PhanVanToan.DTO;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _102220129_PhanVanToan
{
    class CreateDB
        : CreateDatabaseIfNotExists<DAL.QLSV>
        //: DropCreateDatabaseAlways<QLSV>
    {
        protected override void Seed(QLSV context)
        {
            context.LSHes.AddRange(new List<DTO.LSH>
            {
                new LSH { ID_Lop = "1", NameLop = "22T_DT1" },
                new LSH { ID_Lop = "2", NameLop = "22T_DT2" },
                new LSH { ID_Lop = "3", NameLop = "22T_DT3" },
                new LSH { ID_Lop = "4", NameLop = "22T_DT4" },
                new LSH { ID_Lop = "5", NameLop = "22T_DT5" }
            });
            context.SVs.AddRange(new List<DTO.SV>
            {
                new SV
                {
                    MSSV = "102220129",
                    NameSV = "Phan Van Toan",
                    Gender = true,
                    NS = new DateTime(2004, 12, 28),
                    DTB = 8.0,
                    ID_Lop = "2"
                },
                new SV
                {
                    MSSV = "102220131",
                    NameSV = "Nguyen Van A",
                    Gender = true,
                    NS = new DateTime(2004, 2, 2),
                    DTB = 9.0,
                    ID_Lop = "1"
                },
                new SV
                {
                    MSSV = "102220122",
                    NameSV = "Le Thi C",
                    Gender = false,
                    NS = new DateTime(2004, 7, 7),
                    DTB = 8.5,
                    ID_Lop = "1"
                }
            });
        }
    }
}
