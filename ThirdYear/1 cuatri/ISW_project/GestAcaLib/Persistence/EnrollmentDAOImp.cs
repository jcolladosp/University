using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class EnrollmentDAOImp : IEnrollmentDAO
    {
        private GestAcaDAL gestAcaDAL;

        public EnrollmentDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }
        //CRUD PERSON Operations
        public void addEnrollment(Enrollment en)
        {
            try
            {
                gestAcaDAL.enrollments.Add(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Enrollment> findAllEnrollment()
        {
            try
            {
                return gestAcaDAL.enrollments.ToList<Enrollment>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Enrollment findEnrollmentByID(int id)
        {
            try
            {
                return gestAcaDAL.enrollments.Where(p => p.Id.Equals(id)).FirstOrDefault<Enrollment>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeEnrollment(Enrollment en)
        {
            try
            {
                gestAcaDAL.enrollments.Remove(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }
    }
}