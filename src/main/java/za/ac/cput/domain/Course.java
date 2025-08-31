package za.ac.cput.domain;

import jakarta.persistence.*;


@Entity
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String facultyId;

    protected Course() {

    }

    private Course(Builder builder) {
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.facultyId = builder.facultyId;
    }

    // Getters
    public String getCourseId() { return courseId; }

    public String getCourseName() { return courseName; }

    public String getFacultyId() { return facultyId; }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", faculty='" + facultyId + '\'' +
                '}';
    }

    public static class Builder {
        private String courseId;
        private String courseName;
        private String facultyId;

        public Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }


        public Builder copy(Course course) {
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.facultyId = course.facultyId;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
