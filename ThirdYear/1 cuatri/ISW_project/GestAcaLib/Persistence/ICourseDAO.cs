using GestAcaLib.Entities;
using System.Collections.Generic;
namespace GestAcaLib.Persistence
{
    public interface ICourseDAO
    {
        ICollection<Course> findAllCourse();
        void addCourse(Course co);
        void removeCourse(Course co);
        Course findCourseByID(int id);

    }
}