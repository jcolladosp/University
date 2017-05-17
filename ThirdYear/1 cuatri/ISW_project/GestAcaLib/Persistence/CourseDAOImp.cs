using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class CourseDAOImp : ICourseDAO
    {
        private GestAcaDAL gestAcaDAL;

        public CourseDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }
        //CRUD PERSON Operations
        public void addCourse(Course co)
        {
            try
            {
                gestAcaDAL.courses.Add(co);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Course> findAllCourse()
        {
            try
            {
                return gestAcaDAL.courses.ToList<Course>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Course findCourseByID(int id)
        {
            try
            {
                return gestAcaDAL.courses.Where(p => p.Id.Equals(id)).FirstOrDefault<Course>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeCourse(Course co)
        {
            try
            {
                gestAcaDAL.courses.Remove(co);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }
    }
}