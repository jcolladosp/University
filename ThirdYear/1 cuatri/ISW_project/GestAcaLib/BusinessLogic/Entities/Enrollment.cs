using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestAcaLib.Entities
{
    public partial class Enrollment
    {
        public Enrollment()
        {
            Absences = new List<Absence>();
        }
        public Enrollment(int Id,DateTime enrollment,DateTime cancellation, Boolean unique,Student estu,TaughtCourse curso)
        {
            this.Id = Id;
            this.UniquePayment = unique;
            this.EnrollmentDate = enrollment;
            this.CancellationDate = cancellation;
            Absences = new List<Absence>();
            this.Student = estu;
            this.TaughtCourse = curso;
        }

    }
}
