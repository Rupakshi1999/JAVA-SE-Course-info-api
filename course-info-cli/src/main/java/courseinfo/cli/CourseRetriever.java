package courseinfo.cli;

import courseinfo.cli.service.CourseRetrieverService;
import courseinfo.cli.service.CourseStorageService;
import courseinfo.cli.service.PluralSightCourse;
import courseinfo.repository.CourseRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main (String... args){
        LOG.info("CourseRetriever starting!");
        if(args.length == 0){
            LOG.warn("Please provide an author name as first argument");
            return;
        }
        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            LOG.error("Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorID) {
        LOG.info("Retrieving courses for author '{}' ",  authorID);
        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();
        CourseRepository courseRepository = CourseRepository.openCourseRepository("./courses.db");
        CourseStorageService courseStorageService = new CourseStorageService(courseRepository);

        List<PluralSightCourse> coursesToStore = courseRetrieverService.getCourses(authorID)
                .stream()
                .filter(course -> !course.isRetired())
                .toList();
        LOG.info("Retrieved {} courses {} for author '{}' ",coursesToStore.size(),  coursesToStore, authorID);
        courseStorageService.storePluralsightCourses(coursesToStore);
        LOG.info("courses stored in db");
    }

}
