package courseinfo.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void rejectNullComponents(){
        assertThrows(IllegalArgumentException.class, () -> new Course(null, null, 5, "url", Optional.empty()));
    }

    @Test
    void courseIsFilled(){
        assertThrows(IllegalArgumentException.class, () -> new Course("id", "title", 5, "url", Optional.of("")));
    }

}