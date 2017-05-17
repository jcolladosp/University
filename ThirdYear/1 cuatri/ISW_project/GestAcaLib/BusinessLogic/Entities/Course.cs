using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestAcaLib.Entities
{
    public partial class Course
    {
        public Course()
        {
            TaughtCourses = new List<TaughtCourse>();
        }
        public Course(int Id, string name, string descr)
        {
            this.Id = Id;
            this.Name = name;
            this.Description = descr;
            TaughtCourses = new List<TaughtCourse>();
        }

    }
}
