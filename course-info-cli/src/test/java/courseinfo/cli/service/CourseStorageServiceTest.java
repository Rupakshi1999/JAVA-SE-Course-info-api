package courseinfo.cli.service;

import courseinfo.domain.Course;
import courseinfo.repository.CourseRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseStorageServiceTest {

    @Test
    void storePluralsightCourses() {
        CourseRepository repository = new InMemoryCourseRepository();
        CourseStorageService courseStorageService = new CourseStorageService(repository);

        // add data
        PluralSightCourse ps1 = new PluralSightCourse("id", "Test course", "01:00:00", "/url", false);
        courseStorageService.storePluralsightCourses(List.of(ps1));

        Course expected = new Course("id", "Test course", 60, "https://app.pluralsight.com/url", Optional.empty());
        assertEquals(List.of(expected), repository.getAllCourses());

    }

    static class InMemoryCourseRepository implements CourseRepository{
        private final List<Course> courses = new ArrayList<>();
        @Override
        public void saveCourse(Course course) {
            courses.add(course);
        }

        @Override
        public List<Course> getAllCourses() {
            return courses;
        }

        @Override
        public void addNotes(String courseID, String notes) {
            throw new UnsupportedOperationException();
        }
    }
}