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
        : CreateDatabaseIfNotExists<DAL.QLTV>
        //: DropCreateDatabaseAlways<QLSV>
    {
        protected override void Seed(QLTV context)
        {
            context.Categories.AddRange(new List<DTO.Category>
            {
                new Category
                {
                    Category_ID = "1",
                    Category_Name = "Textbook"
                },
                new Category
                {
                    Category_ID = "2",
                    Category_Name = "Comic"
                },
                new Category
                {
                    Category_ID = "3",
                    Category_Name = "Novel"
                }
            });
            context.Books.AddRange(new List<DTO.Book>
            {
                new Book
                {
                    IdBook = "1",
                    Title = "Toán cao cấp",
                    Quantity = 10,
                    PublishedDate = new DateTime(2021, 1, 1),
                    Rent = true,
                    CategoryId = "1"
                },
                new Book
                {
                    IdBook = "2",
                    Title = "Doraemon",
                    Quantity = 5,
                    PublishedDate = new DateTime(2021, 3, 3),
                    Rent = true,
                    CategoryId = "2"
                },
                new Book
                {
                    IdBook = "3",
                    Title = "Harry Potter",
                    Quantity = 7,
                    PublishedDate = new DateTime(2021, 5, 5),
                    Rent = true,
                    CategoryId = "3"
                },
                new Book
                {
                    IdBook = "4",
                    Title = "Vật lý 2",
                    Quantity = 10,
                    PublishedDate = new DateTime(2021, 2, 2),
                    Rent = false,
                    CategoryId = "1"
                }
            });
        }
    }
}
