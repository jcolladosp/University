using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestAcaLib.Entities
{
    public partial class TaughtCourse
    {
     

        public TaughtCourse() {
            this.Enrollments = new List<Enrollment>();
        }

        public TaughtCourse(int id, DateTime endTime, DateTime startDateTime, string teachingDay, int sessionDuration, int totalPrice, int quota,Course co)
        {
            this.Id = id;
            this.Quota = quota;
            this.SessionDuration = sessionDuration;
            this.TotalPrice = totalPrice;
            this.EndTime = endTime;
            this.StartDateTime = startDateTime;
            this.TeachingDay = teachingDay;
            this.Enrollments = new List<Enrollment>();
            this.Course = co;
            
        }
    }
}
