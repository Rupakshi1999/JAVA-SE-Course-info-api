package courseinfo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void courseIsFilled(){
        assertThrows(IllegalArgumentException.class, () -> new Course("id", "", 5, "url"));
    }

}