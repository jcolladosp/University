using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface IStudentDAO
    {
        ICollection<Student> findAllStudent();
        void addStudent(Student per);
        void removeStudent(Student per);
        Student findStudentByID(string id);
    }
}