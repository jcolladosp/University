using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestAcaLib.Entities
{
    public partial class Teacher
    {
        public Teacher():base()
        {
            this.TaughtCourses = new List<TaughtCourse>();
        }
        public Teacher(String id,  String name, String address, int zipcode, String ssn)
        : base( id, name, address, zipcode)
        {
            this.Ssn = ssn;
            this.TaughtCourses = new List<TaughtCourse>();
           
        }
    }
}
