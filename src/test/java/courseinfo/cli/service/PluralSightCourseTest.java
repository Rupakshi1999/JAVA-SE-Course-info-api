package courseinfo.cli.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PluralSightCourseTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            00:05:37, 5
            01:05:37.6367, 65
            00:00:00.77, 0
            """)
    void durationInMinutes(String input, long expected) {
        PluralSightCourse course = new PluralSightCourse("id", "Test course", input, "url", false);
        assertEquals(expected, course.durationInMinutes());
    }
}