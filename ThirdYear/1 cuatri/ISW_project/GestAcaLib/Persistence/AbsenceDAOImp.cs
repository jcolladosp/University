using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class AbsenceDAOImp : IAbsenceDAO
    {

        private GestAcaDAL gestAcaDAL;

        public AbsenceDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }
        //CRUD PERSON Operations
        public void addAbsence(Absence ab)
        {
            try
            {
                gestAcaDAL.absences.Add(ab);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Absence> findAllAbsence()
        {
            try
            {
                return gestAcaDAL.absences.ToList<Absence>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Absence findAbsenceByID(string id)
        {
            try
            {
                return gestAcaDAL.absences.Where(p => p.Id.Equals(id)).FirstOrDefault<Absence>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeAbsence(Absence ab)
        {
            try
            {
                gestAcaDAL.absences.Remove(ab);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }
    }
}