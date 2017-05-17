using GestAcaLib.Entities;
using System.Collections.Generic;

namespace GestAcaLib.Persistence
{
    public interface IAbsenceDAO
    {
        ICollection<Absence> findAllAbsence();
        void addAbsence(Absence ab);
        void removeAbsence(Absence ab);
        Absence findAbsenceByID(string id);


    }
}