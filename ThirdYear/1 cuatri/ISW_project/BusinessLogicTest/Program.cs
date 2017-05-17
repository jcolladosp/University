using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

    
using GestAcaLib.Entities;
using GestAcaLib.BusinessLogic;
namespace BusinessLogicTestApp
{

    class Program
    {
        BusinessController controller;
        public Program()
        {
            controller = BusinessController.getBusinessController();

            controller.removeAllData();
        }

        void printError(string message)
        {
            Console.WriteLine("ERROR: "+message);           
        }
        void addCourses()
        {
            Console.WriteLine();
            Console.WriteLine("ADDING COURSES ...");

            for (int courseId = 1; courseId <= 10; courseId++)
            {
                Console.Write("Adding Course " + courseId+" - ");
                try
                {
                    controller.addCourse(new Course(courseId, "Course-Name-" + courseId, "Course-Description-" + courseId));
                    Console.WriteLine("OK");
                }
                catch (BusinessLogicException e)
                {
                    printError(e.Message);
                }
            }
        }

        void addTeachers()
        {
            Console.WriteLine();
            Console.WriteLine("ADDING TEACHERS ...");
            string teacherId;
            for (char c = 'A'; c <= 'G'; c++)
            {
                teacherId = "11111111" + c;
                Console.Write("Adding Teacher " + teacherId + " - ");
                try
                {
                    controller.addTeacher(new Teacher(teacherId, "Teacher-Name-" + teacherId, "Camino de Vera s/n", 46022, "SSN" + teacherId));
                    Console.WriteLine("OK");
                }
                catch (BusinessLogicException e)
                {
                        printError(e.Message);
                }               
            }
        }

        void addStudents() {
            Console.WriteLine();
            Console.WriteLine("ADDING STUDENTS ...");
            string studentId;
            for (char c = 'A'; c <= 'G'; c++)
            {
                studentId = "22222222" + c;
                Console.Write("Adding Student " + studentId + " - ");
                try
                {
                    controller.addStudent(new Student(studentId, "Student-Name-" + studentId, "Camino de Vera s/n", 46022, "IBAN22334455667788" ));
                    Console.WriteLine("OK");
                }
                catch (BusinessLogicException e)
                {
                    printError(e.Message);
                }
            }

        }

        void addTaughtCourses(int courseId)
        {
            Course c;
            Console.WriteLine();
            Console.WriteLine("ADDING TAUGHT COURSES FOR COURSE <"+courseId+ "> ...");

            for (int taughtCourseId = 1; taughtCourseId <= 10; taughtCourseId++)
            {
                Console.Write("Adding Taught Course " + taughtCourseId + " - ");
                try {
                    c=controller.findCourseByID(courseId);
                    controller.addTaughtCourse(new TaughtCourse(taughtCourseId, DateTime.Now, DateTime.Now, "Tuesday", 120, 1200, 30, c));
                    Console.WriteLine("OK");
                }
                catch (BusinessLogicException e)
                {
                    printError(e.Message);
                }

            }
        }

        void assignTeacherToTaughtCourses(string teacherId, int courseId)
        {
            Course c;
            Teacher t;
            ICollection<TaughtCourse> taughtCourses;

            Console.WriteLine();
            Console.WriteLine("ASSIGNING TEACHER <"+teacherId+"> FOR TAUGHT COURSES OF COURSE <" + courseId + "> ...");
            taughtCourses = controller.findTaughtCoursesByCourseID(courseId);
            foreach (TaughtCourse tc in taughtCourses)
            {
                try {
                    controller.assignTeacherToTaughtCourse(teacherId, tc.Id);
                    t = controller.findTeacherByID(teacherId);
                    c = controller.findCourseByID(courseId);
                    Console.WriteLine("Assigned teacher <" + t.Name + "> to taught course <" + tc.Id + "> in Course <" + c.Name + ">");
                }catch (BusinessLogicException e)
                {
                    printError(e.Message);
                }
            }    
        }

        void addEnrollments()
        {
            Console.WriteLine();
            Console.WriteLine("ADDING ENROLLMENTS...");

            Student s = new Student("33333333Z", "Javier Jaen", "Camino de vera", 46022, "2233445566778899");
            try
            {
                controller.addStudent(s);

                //Enrolling a student twice
                controller.addEnrollment(new Enrollment(1, DateTime.Now, DateTime.Now, true, s, controller.findTaughtCourseById(1)));
                Console.WriteLine("Student <" + s.Name + "> enrolled in TaughtCourse <1>");

                // Second must fail
                controller.addEnrollment(new Enrollment(1, DateTime.Now, DateTime.Now, true, s, controller.findTaughtCourseById(1)));
            }
            catch(BusinessLogicException e)
            {
                printError(e.Message);
            }

        }
        void listAllCourses()
        {
            Console.WriteLine();
            Console.WriteLine("LISTING ALL COURSES "); 
            ICollection <Course> courses = controller.findAllCourses();
            foreach (Course c in courses)
                Console.WriteLine(c.Id + ", " + c.Name + ", " + c.Description);
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Creating/Opening Database...");

            Program p = new Program();
            int courseId;

            //Adding courses
            p.addCourses();
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Adding Teachers
            p.addTeachers();
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Adding Students
            p.addStudents();
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Adding taught courses for an existing course
            courseId = 1;
            p.addTaughtCourses(courseId);
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Adding taught courses for a NON existing course
            courseId = 100;
            p.addTaughtCourses(courseId);
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Assigning teachers to taught courses
            courseId = 1;
            p.assignTeacherToTaughtCourses("11111111B",courseId);
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Adding two equal enrollments 
            p.addEnrollments();
            Console.WriteLine("Press Key to continue...");
            Console.ReadKey();

            //Listing all courses
            p.listAllCourses();
            
            Console.WriteLine("Press Key to exit...");
            Console.ReadKey();
        }
    }
}
