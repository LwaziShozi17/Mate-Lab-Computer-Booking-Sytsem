package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
List<Course> findByFacultyName(String facultyName);
}
