package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseFactoryTest {

    @Test
    void createCourse() {
        Course course = CourseFactory.createCourse(
                "ENG101",
                "Civil Engineering",
                "Engineering"
        );
        assertNotNull(course);
        System.out.println(course);
    }
}