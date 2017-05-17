using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface ITeacherDAO
    {
        ICollection<Teacher> findAllTeacher();
        void addTeacher(Teacher tea);
        void removeTeacher(Teacher tea);
        Teacher findTeacherByID(string id);
    }
}