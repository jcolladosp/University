using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class StudentDAOImp : IStudentDAO
    {
        private GestAcaDAL gestAcaDAL;

        public StudentDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }
        //CRUD PERSON Operations
        public void addStudent(Student per)
        {
            try
            {
                gestAcaDAL.students.Add(per);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Student> findAllStudent()
        {
            try
            {
                return gestAcaDAL.students.ToList<Student>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Student findStudentByID(string id)
        {
            try
            {
                return gestAcaDAL.students.Where(p => p.Id.Equals(id)).FirstOrDefault<Student>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeStudent(Student per)
        {
            try
            {
                gestAcaDAL.students.Remove(per);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }
    }
}