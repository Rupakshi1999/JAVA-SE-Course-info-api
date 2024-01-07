package courseinfo.cli.service;

import courseinfo.domain.Course;
import courseinfo.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseStorageService {
    private static final String PS_BASE_URL = "https://app.pluralsight.com";
    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralSightCourse> psCourses){
        for(var psCourse: psCourses){
            Course course = new Course(psCourse.id(),
                    psCourse.title(),
                    psCourse.durationInMinutes(),
                    PS_BASE_URL + psCourse.contentURL(),
                    Optional.empty()
                    );
            courseRepository.saveCourse(course);
        }
    }
}
