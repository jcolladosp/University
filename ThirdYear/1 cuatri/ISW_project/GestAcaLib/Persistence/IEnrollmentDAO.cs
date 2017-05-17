using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface IEnrollmentDAO
    {
        ICollection<Enrollment> findAllEnrollment();
        void addEnrollment(Enrollment en);
        void removeEnrollment(Enrollment en);
        Enrollment findEnrollmentByID(int id);
    }
}