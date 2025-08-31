package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Faculty;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {
    @Test
    void createFaculty() {
        Faculty faculty = FacultyFactory.createFaculty(
                "FAC001",
                "Engineering"
        );
        assertNotNull(faculty);
        System.out.println(faculty);
    }
}