package za.ac.cput.service;
import za.ac.cput.domain.Course;

import java.util.List;

public interface ICourse extends IService<Course, String> {
    List<Course> listAllCourses();
}
