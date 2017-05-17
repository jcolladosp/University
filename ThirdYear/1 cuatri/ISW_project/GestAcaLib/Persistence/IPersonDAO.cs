using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface IPersonDAO
    {
        ICollection<Person> findAllPerson();
        void addPerson(Person per);
        void removePerson(Person per);
        Person findPersonByID(string id);
    }
}