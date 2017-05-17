using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestAcaLib.Entities
{
    public partial class Office
    {
        public Office()
        {
            this.TaughtCourses = new List<TaughtCourse>();
        }

        public Office(int capa, string name, int id)
        {
            this.MaxCapacity = capa;
            this.Name = name;
            this.Id = id;
            this.TaughtCourses = new List<TaughtCourse>();
        }
    }
}
