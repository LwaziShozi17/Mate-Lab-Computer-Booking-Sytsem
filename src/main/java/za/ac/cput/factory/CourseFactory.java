package za.ac.cput.factory;

import za.ac.cput.domain.Course;

public class CourseFactory {
    public static Course createCourse(String courseId, String courseName, String facultyId) {
        return new Course.Builder()
                .setCourseId(courseId)
                .setCourseName(courseName)
                .setFacultyId(facultyId)
                .build();
    }
}
