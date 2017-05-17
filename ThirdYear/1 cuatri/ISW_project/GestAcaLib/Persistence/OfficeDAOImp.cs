using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;
namespace GestAcaLib.Persistence
{
    internal class OfficeDAOImp : IOfficeDAO
    {
        private GestAcaDAL gestAcaDAL;

        public OfficeDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }

        public void addOffice(Office en)
        {
            try
            {
                gestAcaDAL.offices.Add(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Office> findAllOffice()
        {
            try
            {
                return gestAcaDAL.offices.ToList<Office>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Office findOfficeByID(string id)
        {
            try
            {
                return gestAcaDAL.offices.Where(p => p.Id.Equals(id)).FirstOrDefault<Office>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removeOffice(Office en)
        {
            try
            {
                gestAcaDAL.offices.Remove(en);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }

    }
}