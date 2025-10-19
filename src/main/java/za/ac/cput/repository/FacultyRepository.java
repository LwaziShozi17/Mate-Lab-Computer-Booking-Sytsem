package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, String> { ;
    Faculty findByFacultyName(String facultyName);
}
