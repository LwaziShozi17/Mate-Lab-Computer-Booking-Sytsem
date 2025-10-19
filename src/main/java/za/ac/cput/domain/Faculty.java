package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Faculty {

    @Id
    @Column(name = "facultyId", nullable = false)
    private Long facultyId;

    @Column(name = "facultyName", nullable = false)
    private String facultyName;

    @OneToMany(mappedBy = "faculty")
    private List<Course> courses;

    // Constructors
    protected Faculty() {
    }

    public Faculty(Builder builder) {
        this.facultyId = builder.facultyId;
        this.facultyName = builder.facultyName;
        this.courses = builder.courses;
    }

    // Getters
    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }
    public List<Course> getCourses() {
        return courses;
    }

    // toString
    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId='" + facultyId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", courses=" + courses +
                '}';
    }

    public static class Builder {
        private String facultyId;
        private String facultyName;
        private List<Course> courses;

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public Builder copy(Faculty faculty) {
            this.facultyId = faculty.facultyId;
            this.facultyName = faculty.facultyName;
            this.courses = faculty.courses;
            return this;
        }

        public Faculty build() {
            return new Faculty(this);
        }
    }
}
