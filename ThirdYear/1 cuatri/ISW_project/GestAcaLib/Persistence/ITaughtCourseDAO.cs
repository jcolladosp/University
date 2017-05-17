using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface ITaughtCourseDAO
    {
        ICollection<TaughtCourse> findAllTaughtCourses();
        void addTaughtCourse(TaughtCourse tau);
        void removeTaughtCourse(TaughtCourse tau);
        TaughtCourse findTaughtCourseByID(int id);
        ICollection<TaughtCourse> findTaughtCoursesByCourseID(int id);

    }
}