// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using _22N11;


namespace dotNet
{
    public class Program
    {
        public static void Main() 
        {
            Clock c = new Clock();
            DigitalClock dc = new DigitalClock();
            AnalogClock ac = new AnalogClock(); 
            c.OnSecondChange += new Clock.SecondHandler(dc.ShowDC);
            c.OnSecondChange += new Clock.SecondHandler(ac.ShowAC);

            c.Run();
        }
    }
}