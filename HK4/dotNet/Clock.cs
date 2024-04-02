using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _22N11
{
    public class Clock
    {
        public delegate void SecondHandler (object o, TimeEventArgs e);

        public event SecondHandler OnSecondChange;

        public void Run() 
        {
            while (true)
            {
                Thread.Sleep(1000);
                OnSecondChange(this, new TimeEventArgs
                {t = DateTime.Now});
            }
        }
    }
}

