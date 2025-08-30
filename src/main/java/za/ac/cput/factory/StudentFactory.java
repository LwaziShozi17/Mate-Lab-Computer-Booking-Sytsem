/*
StudentFactory.java
Student Factory class
Author: SE Sibiya (230975623)
Date: 08 August 2025 2025
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String firstName, String lastName,
                                        String email, String password, Long studentId,
                                        String faculty, String enrollmentYear,
                                        String currentYear) {

        //Checking empty fields
        if (Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(password)
                || Helper.isNullOrEmpty(String.valueOf(studentId))
                || Helper.isNullOrEmpty(faculty)
                || Helper.isNullOrEmpty(enrollmentYear)
                || Helper.isNullOrEmpty(currentYear)) {
            throw new IllegalArgumentException("Please fill all the required fields");
        }
        //Checking if it is the right email
        if (Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Incorrect email domain");
        }

        return new Student.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setStudentId(Long.valueOf(studentId))
                .setFaculty(faculty)
                .setEnrollmentYear(enrollmentYear)
                .setCurrentYear(currentYear)
                .build();
    }
}