package za.ac.cput.factory;

import za.ac.cput.domain.Faculty;

public class FacultyFactory {
    public static Faculty createFaculty( String facultyId,String facultyName) {

        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(facultyName)
                .build();
    }
}
