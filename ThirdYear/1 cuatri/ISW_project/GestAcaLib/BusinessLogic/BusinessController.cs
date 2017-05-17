using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using GestAcaLib.Persistence;
using GestAcaLib.Entities;
namespace GestAcaLib.BusinessLogic
{
    public class BusinessController
    {

        private GestAcaDAL dal;
        private BusinessController()
        {
            dal = GestAcaDAL.getGestAcalDAL();

        }

        // Singleton pattern
        private static BusinessController instance = null;
        public static BusinessController getBusinessController()
        {
            if (instance == null)
                instance = new BusinessController();
            return instance;
        }

        public void removeAllData()
        {
            dal.RemoveAllData();
        }
        
        public void addEnrollment(Enrollment e)
        {
            bool alreadyAssigned = false;
            Student s = dal.studentDAO.findStudentByID(e.Student.Id);
            TaughtCourse tc = dal.tcourseDAO.findTaughtCourseByID(e.TaughtCourse.Id); 
            
            if (s == null)
            {
                throw new BusinessLogicException("Student not found.");
                /* s = new Student(e.Student.Address, e.Student.Id, e.Student.Name, e.Student.ZipCode, e.Student.IBAN);
                 addStudent(s); */
            }
            if(tc == null)
            {
                throw new BusinessLogicException("TaughtCourse not found."); 
             /*   tc = new TaughtCourse(e.TaughtCourse.Id, e.TaughtCourse.EndTime, e.TaughtCourse.StartDateTime, e.TaughtCourse.TeachingDay, e.TaughtCourse.SessionDuration, e.TaughtCourse.TotalPrice, e.TaughtCourse.Quota,e.TaughtCourse.Course);
                addTaughtCourse(tc); */
            }
            else if (dal.enrollmentDAO.findEnrollmentByID(e.Id) != null)
            {
                throw new BusinessLogicException("enrollment already in the DB");
            }
        
            else
            {
                foreach (var en in s.Enrollments)
                {
                    if (en.TaughtCourse.Equals(tc)) alreadyAssigned = true;
                }
                
                

                if (alreadyAssigned) { throw new BusinessLogicException("Student already assigned to taught course."); }
                else { dal.enrollmentDAO.addEnrollment(e); }
            }
         
        }


        public void addTaughtCourse(TaughtCourse t) {
             
            Course c = t.Course;
            if(c == null) throw new BusinessLogicException("Impossible to add a TaughtCourse to a non Existing course.");

            else { dal.tcourseDAO.addTaughtCourse(t); }

        }
        public void assignTeacherToTaughtCourse(String teacherId,int tcID) {
            Teacher teacher = findTeacherByID(teacherId);
            TaughtCourse tc = findTaughtCourseById(tcID);

            if(teacher == null) throw new BusinessLogicException("Teacher doesn't exist.");
            if (tc == null) throw new BusinessLogicException("Taught Course doesn't exist.");
            if(tc.Teacher != null) throw new BusinessLogicException("Taught course already has a teacher.");

            bool add = true;

            TimeSpan start = new TimeSpan(tc.StartDateTime.Hour, tc.StartDateTime.Minute, tc.StartDateTime.Second);
            TimeSpan end = new TimeSpan(tc.EndTime.Hour, tc.EndTime.Minute, tc.EndTime.Second);


            foreach (TaughtCourse t in teacher.TaughtCourses)
            {
                TimeSpan startC = new TimeSpan(t.StartDateTime.Hour, t.StartDateTime.Minute, t.StartDateTime.Second);
                TimeSpan endC = new TimeSpan(t.EndTime.Hour, t.EndTime.Minute, t.EndTime.Second);
                if (t.TeachingDay.Equals(tc.TeachingDay))
                {

                    //if (startC.Ticks > start.Ticks && startC.Ticks < end.Ticks || endC.Ticks > start.Ticks && endC.Ticks < end.Ticks)
                    if (startC.Ticks <= end.Ticks  || start.Ticks <= endC.Ticks)
                        add = false;
                    
                }

                //TODO que pasa si son diferentes dias pero solapa

            }

            if (add) { teacher.TaughtCourses.Add(tc);
                tc.Teacher = teacher;
            }
            else throw new BusinessLogicException("Overlap.");
        }
       

        public ICollection<TaughtCourse> findTaughtCoursesByCourseID(int courseID) {

            return dal.tcourseDAO.findTaughtCoursesByCourseID(courseID);
        }

        public ICollection<Course> findAllCourses() 
        {
            return dal.courseDAO.findAllCourse();
        }
        public ICollection<Student> findAllStudents()
        {
            return dal.studentDAO.findAllStudent();
        }
        public ICollection<TaughtCourse> findAllTaughtCourses()
        {
            return dal.tcourseDAO.findAllTaughtCourses();
        }

        public Teacher findTeacherByID(String teacherId)
        {
            return dal.teacherDAO.findTeacherByID(teacherId);
        }

        public TaughtCourse findTaughtCourseById(int tcID)
        {
            return dal.tcourseDAO.findTaughtCourseByID(tcID);
        }

        public Course findCourseByID(int courseId)
        {
            return dal.courseDAO.findCourseByID(courseId);
               
        }

        public void addStudent(Student student)
        {
            if (findStudentByID(student.Id) == null)
                dal.studentDAO.addStudent(student);
            else throw new BusinessLogicException("Student already exists.");
        }
        public Student findStudentByID(String studentId)
        {
            return dal.studentDAO.findStudentByID(studentId);
        }

        public Enrollment findEnrollmentByID(int EId)
        {
            return dal.enrollmentDAO.findEnrollmentByID(EId);
        }

        public void addTeacher(Teacher teacher)
        {
            if (dal.teacherDAO.findTeacherByID(teacher.Id) == null)
                dal.teacherDAO.addTeacher(teacher);
            else throw new BusinessLogicException("Teacher already exists.");
        }
        public void addCourse(Course course)
        {
            if (dal.courseDAO.findCourseByID(course.Id) == null)
                dal.courseDAO.addCourse(course);
            else throw new BusinessLogicException("Course already exists.");
        }
        public void removeTaughtCourse(int tcID)
        {
            dal.tcourseDAO.removeTaughtCourse(dal.tcourseDAO.findTaughtCourseByID(tcID));
        }
    }
}
