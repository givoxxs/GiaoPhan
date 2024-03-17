using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _22N11
{
    public class AnalogClock
    {
        public void ShowAC(object o, EventArgs e)
        {
            DateTime d = DateTime.Now;
            Console.WriteLine("AC: {0}, {1}, {2}, {3}", 
            d.Hour, d.Minute, d.Second, d.Millisecond);
        }
    }
}