using _102220129_PhanVanToan.DAL;
using _102220129_PhanVanToan.DTO;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Data.Entity.Migrations;
using System.Linq;
using System.Linq.Dynamic.Core;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _102220129_PhanVanToan.BLL
{
    public class BLL_QLTV
    {
        private static BLL_QLTV _Instance;
        public static BLL_QLTV Instance
        {
            get
            {
                if (_Instance == null)
                {
                    _Instance = new BLL_QLTV();
                }
                return _Instance;
            }
            private set { }
        }
        private QLTV db;
        private BLL_QLTV()
        {
            db = new QLTV();
        }
        public List<CBBItem> GetCBBItems()
        {
            List<CBBItem> data = new List<CBBItem>();
            foreach (var item in db.Categories.Select(p => p))
            {
                data.Add(new CBBItem
                {
                    Value = item.Category_ID,
                    Text = item.Category_Name
                });
            }
            return data;
        }
        public List<object> GetAll(string txtSearch = "", string cbb = "All", string sortType = "IdBook")
        {
            List<object> items = new List<object>();
            if (cbb == "All")
            {
                var data = db.Books
                    .Where(p => p.Title.Contains(txtSearch))
                    .Select(p => new
                    {
                        p.IdBook,
                        p.Title,
                        p.Quantity,
                        p.PublishedDate,
                        p.Rent,
                        p.Categories.Category_Name,
                    }).OrderBy(sortType).ToList();
                foreach (var item in data)
                {
                    items.Add(item);
                }
            }
            else
            {
                var data = db.Books
                    .Where(p => p.Title.Contains(txtSearch) && p.Categories.Category_Name == cbb)
                    .Select(p => new
                    {
                        p.IdBook,
                        p.Title,
                        p.Quantity,
                        p.PublishedDate,
                        p.Rent,
                        p.Categories.Category_Name,
                    }).OrderBy(sortType).ToList();
                foreach (var item in data)
                {
                    items.Add(item);
                }
            }
            return items;
        }
        public Book GetBookById(string id)
        {
            return db.Books.FirstOrDefault(p => p.IdBook == id);
        }
        //public LSH GetLSHByID(string id)
        //{
        //    return db.LSHes.FirstOrDefault(p => p.ID_Lop == id);
        //}
        public void AddSV(Book b)
        {
            db.Books.Add(b);
            db.SaveChanges();
        }
        public void EditSV(Book b)
        {
            var item = db.Books.Find(b.IdBook);
            item = b;
            db.Books.AddOrUpdate(item);
            db.SaveChanges();
        }
        public void DelSV(string id)
        {
            var item = db.Books.Find(id);
            db.Books.Remove(item);
            db.SaveChanges();
        }
    }
}
