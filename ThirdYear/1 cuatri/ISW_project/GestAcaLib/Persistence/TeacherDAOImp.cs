using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class TeacherDAOImp : ITeacherDAO
    {
        private GestAcaDAL gestAcaDAL;

        public TeacherDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }

        //CRUD PERSON Operations
        public void addTeacher(Teacher en)
        {
            try
            {
                gestAcaDAL.teachers.Add(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Teacher> findAllTeacher()
        {
            try
            {
                return gestAcaDAL.teachers.ToList<Teacher>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Teacher findTeacherByID(string id)
        {
            try
            {
                return gestAcaDAL.teachers.Where(p => p.Id.Equals(id)).FirstOrDefault<Teacher>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeTeacher(Teacher en)
        {
            try
            {
                gestAcaDAL.teachers.Remove(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }
    }
}