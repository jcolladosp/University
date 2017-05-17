using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class TaughtCourseDAOImp : ITaughtCourseDAO
    {
        private GestAcaDAL gestAcaDAL;

        public TaughtCourseDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }

        //CRUD PERSON Operations
        public void addTaughtCourse(TaughtCourse en)
        {
            try
            {
                gestAcaDAL.tcourses.Add(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<TaughtCourse> findAllTaughtCourses()
        {
            try
            {
                return gestAcaDAL.tcourses.ToList<TaughtCourse>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public ICollection<TaughtCourse> findTaughtCoursesByCourseID(int id)
        {
            try
            {
                return gestAcaDAL.tcourses.Where(p => p.Course.Id.Equals(id)).ToList<TaughtCourse>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public TaughtCourse findTaughtCourseByID(int id)
        {
            try
            {
                return gestAcaDAL.tcourses.Where(p => p.Id==id).FirstOrDefault<TaughtCourse>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeTaughtCourse(TaughtCourse en)
        {
            try
            {
                gestAcaDAL.tcourses.Remove(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }

    }
}