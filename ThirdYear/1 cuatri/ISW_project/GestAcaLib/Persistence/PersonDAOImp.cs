using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using GestAcaLib.Entities;

namespace GestAcaLib.Persistence
{
    internal class PersonDAOImp : IPersonDAO
    {
        private GestAcaDAL gestAcaDAL;

        public PersonDAOImp(GestAcaDAL gestAcaDAL)
        {
            this.gestAcaDAL = gestAcaDAL;
        }

        //CRUD PERSON Operations
        public void addPerson(Person per)
        {
            try
            {
                gestAcaDAL.persons.Add(per);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }


        public ICollection<Person> findAllPerson()
        {
            try
            {
                return gestAcaDAL.persons.ToList<Person>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }
        public Person findPersonByID(string id)
        {
            try
            {
                return gestAcaDAL.persons.Where(p => p.Id.Equals(id)).FirstOrDefault<Person>();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
                return null;
            }
        }

        public void removePerson(Person per)
        {
            try
            {
                gestAcaDAL.persons.Remove(per);
                gestAcaDAL.SaveChanges();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.ToString());
            }
        }
    }
}