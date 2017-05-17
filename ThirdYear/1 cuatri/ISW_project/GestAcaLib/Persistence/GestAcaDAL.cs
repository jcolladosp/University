using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using GestAcaLib.Entities;

namespace GestAcaLib.Persistence
{
    public class GestAcaDAL : DbContext
    {

        public DbSet<Absence> absences { get; set; }
        public DbSet<Person> persons { get; set; }
        public DbSet<Course> courses { get; set; }
        public DbSet<Office> offices { get; set; }
        public DbSet<Enrollment> enrollments { get; set; }
        public DbSet<Student> students { get; set; }
        public DbSet<TaughtCourse> tcourses { get; set; }
        public DbSet<Teacher> teachers { get; set; }



        public IAbsenceDAO absenceDAO
        {
            get;
        }
        public ICourseDAO courseDAO
        {
            get;
        }
        public IEnrollmentDAO enrollmentDAO
        {
            get;
        }
        public IPersonDAO personDAO
        {
            get;
        }
        public IOfficeDAO officeDAO
        {
            get;
        }
        public IStudentDAO studentDAO
        {
            get;
        }
        public ITaughtCourseDAO tcourseDAO
        {
            get;
        }
        public ITeacherDAO teacherDAO
        {
            get;
        }

        private GestAcaDAL() : base("DBConnectionString")
        {
            absenceDAO = new AbsenceDAOImp(this);
            courseDAO = new CourseDAOImp(this);
            enrollmentDAO = new EnrollmentDAOImp(this);
            personDAO = new PersonDAOImp(this);
            officeDAO = new OfficeDAOImp(this);
            studentDAO = new StudentDAOImp(this);
            tcourseDAO = new TaughtCourseDAOImp(this);
            teacherDAO = new TeacherDAOImp(this);

            Database.Initialize(true);
            

        }

        // DAL Implements Singleton Pattern
        private static GestAcaDAL instance = null;
        public static GestAcaDAL getGestAcalDAL()
        {
            if (instance == null)
                instance = new GestAcaDAL();
            return instance;
        }
       

        public void RemoveAllData()
        {
            try
            {
                persons.RemoveRange(persons);
                absences.RemoveRange(absences);
                offices.RemoveRange(offices);
                courses.RemoveRange(courses);
                enrollments.RemoveRange(enrollments);
                students.RemoveRange(students);
                tcourses.RemoveRange(tcourses);
                teachers.RemoveRange(teachers);
                SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }

        public void Save()
        {
            try
            {
                this.SaveChanges();

            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }


        }

    

    }
}