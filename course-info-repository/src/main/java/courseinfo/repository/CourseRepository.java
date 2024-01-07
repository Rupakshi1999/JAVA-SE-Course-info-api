package courseinfo.repository;

import courseinfo.domain.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);
    List<Course> getAllCourses();

    void addNotes(String courseID, String notes);
    static CourseRepository openCourseRepository(String databaseFile){
        return new CourseJdbcRepository(databaseFile);
    }
}
