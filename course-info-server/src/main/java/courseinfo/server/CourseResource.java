package courseinfo.server;

import courseinfo.domain.Course;
import courseinfo.repository.CourseRepository;
import courseinfo.repository.RepositoryException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/courses")
public class CourseResource {
    private static final Logger LOG = LoggerFactory.getLogger(CourseResource.class);
    private final CourseRepository courseRepository;

    public CourseResource(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Stream<Course> getCourses() {
        try
        {
            return courseRepository
                    .getAllCourses()
                    .stream()
                    .sorted(Comparator.comparing(Course::id));
        } catch (RepositoryException e){
            LOG.error("Could not retrieve courses from the database ", e);
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Stream<Course> getCourse(@PathParam("id") String courseID) {
        try
        {
            return courseRepository
                    .getAllCourses()
                    .stream()
                    .filter(course -> course.id().equals(courseID));
        } catch (RepositoryException e){
            LOG.error("Could not retrieve course from the database ", e);
            throw new NotFoundException();
        }
    }

    @POST
    @Path("/{id}/notes")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addNotes(@PathParam("id") String courseID, String notes){
        courseRepository.addNotes(courseID, notes);
    }

}
