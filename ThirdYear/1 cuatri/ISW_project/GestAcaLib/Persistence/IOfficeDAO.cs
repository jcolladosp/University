using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface IOfficeDAO
    {
        ICollection<Office> findAllOffice();
        void addOffice(Office of);
        void removeOffice(Office of);
        Office findOfficeByID(string id);
    }
}