using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using _22N11;

namespace dotNet
{
    public class SVCNTT : SV
    {
        public bool LT {get; set;}

        public override string ToString()
        {
            return base.ToString() + ", LT = " + LT;
        }
    }
}