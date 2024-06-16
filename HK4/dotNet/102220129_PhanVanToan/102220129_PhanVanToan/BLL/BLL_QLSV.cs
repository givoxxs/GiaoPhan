using _102220129_PhanVanToan.DAL;
using _102220129_PhanVanToan.DTO;
using System;
using System.Collections.Generic;
using System.Data.Entity.Migrations;
using System.Linq;
using System.Linq.Dynamic.Core;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _102220129_PhanVanToan.BLL
{
    public class BLL_QLSV
    {
        private static BLL_QLSV _Instance;
        public static BLL_QLSV Instance
        {
            get
            {
                if (_Instance == null)
                {
                    _Instance = new BLL_QLSV();
                }
                return _Instance;
            }
            private set { }
        }
        private QLSV db;
        private BLL_QLSV()
        {
            db = new QLSV();
        }
        public List<CBBItem> GetCBBItems()
        {
            List<CBBItem> data = new List<CBBItem>();
            foreach (var item in db.LSHes.Select(p => p))
            {
                data.Add(new CBBItem
                {
                    Value = item.ID_Lop,
                    Text = item.NameLop
                });
            }
            return data;
        }
        public List<object> GetAll(string txtSearch = "", string cbb = "All", string sortType = "MSSV")
        {
            List<object> items = new List<object>();
            if (cbb == "All")
            {
                var data = db.SVs
                    .Where(p => p.NameSV.Contains(txtSearch))
                    .Select(p => new
                    {
                        p.MSSV,
                        p.NameSV,
                        p.LSH.NameLop,
                        p.NS,
                        p.DTB,
                        p.Gender
                    }).OrderBy(sortType).ToList();
                foreach (var item in data)
                {
                    items.Add(item);
                }
            }
            else
            {
                var data = db.SVs
                    .Where(p => p.NameSV.Contains(txtSearch) && p.LSH.NameLop == cbb)
                    .Select(p => new
                    {
                        p.MSSV,
                        p.NameSV,
                        p.LSH.NameLop,
                        p.NS,
                        p.DTB,
                        p.Gender
                    }).OrderBy(sortType).ToList();
                foreach (var item in data)
                {
                    items.Add(item);
                }
            }
            return items;
        }
        public SV GetSVByMSSV(string mssv)
        {
            return db.SVs.FirstOrDefault(p => p.MSSV == mssv);
        }
        //public LSH GetLSHByID(string id)
        //{
        //    return db.LSHes.FirstOrDefault(p => p.ID_Lop == id);
        //}
        public void AddSV(SV sv)
        {
            db.SVs.Add(sv);
            db.SaveChanges();
        }
        public void EditSV(SV sv)
        {
            var item = db.SVs.Find(sv.MSSV);
            item = sv;
            db.SVs.AddOrUpdate(item);
            db.SaveChanges();
        }
        public void DelSV(string mssv)
        {
            var item = db.SVs.Find(mssv);
            db.SVs.Remove(item);
            db.SaveChanges();
        }
    }
}
