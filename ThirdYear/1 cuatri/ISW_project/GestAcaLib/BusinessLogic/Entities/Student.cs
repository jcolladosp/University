using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestAcaLib.Entities
{
    public partial class Student : Person
    {
        
        public Student():base() { this.Enrollments = new List<Enrollment>(); }

        public Student( String id, String name, String address, int zipcode,String iban) 
            :base (id,name, address, zipcode) {
            this.IBAN = iban;
            this.Enrollments = new List<Enrollment>();
            
        }

    }
}
