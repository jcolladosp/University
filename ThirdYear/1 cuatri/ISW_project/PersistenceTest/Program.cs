using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Persistence;
using GestAcaLib.Entities;


namespace PersistenceTest
{
    class Program
    {
        static void Main(string[] args)
        {
            //Example of console application to test some services of the Persistence layer
            //Important: App.config must contain the database connection string

            GestAcaDAL myDAL = GestAcaDAL.getGestAcalDAL();

            IOfficeDAO boDAO = myDAL.officeDAO;
            boDAO.addOffice(new Office(288, "El conser", 13));
            ICollection<Office> boffices = boDAO.findAllOffice();
           

            foreach (Office bo in boffices)
            {
                Console.WriteLine("ID: " + bo.Id + " Name: " + bo.Name + " Capacidad: " + bo.MaxCapacity);
            }

            ICourseDAO coDAO = myDAL.courseDAO;
            coDAO.addCourse(new Course(12, "ISW", "Hola"));
           
            ICollection<Course> courses = coDAO.findAllCourse();
            
            foreach (Course bo in courses)
            {
                Console.WriteLine("ID: " + bo.Id + " Name: " + bo.Name + " Description: " + bo.Description);
            }

            Console.WriteLine("Pres Key to exit...");
            Console.ReadKey();
        }
    }
}
