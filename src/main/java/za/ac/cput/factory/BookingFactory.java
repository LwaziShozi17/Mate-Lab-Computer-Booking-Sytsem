package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.util.Helper;

public class BookingFactory {
    public static Booking createBooking(Long studentId, String faculty, String course,
                                        String computerId, String startTime, String endTime,
                                        String software) {

        if (
                Helper.isNullOrEmpty(String.valueOf(studentId))
                        || Helper.isNullOrEmpty(faculty)
                        || Helper.isNullOrEmpty(course)
                        || Helper.isNullOrEmpty(computerId)
                        || Helper.isNullOrEmpty(startTime)
                        || Helper.isNullOrEmpty(endTime)
                        || Helper.isNullOrEmpty(software)) {
            throw new IllegalArgumentException("All booking fields are required!");
        }


        return new Booking.Builder()
                .setStudentId(studentId)
                .setFaculty(faculty)
                .setCourse(course)
                .setComputerId(computerId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setSoftware(software)
                .build();
    }
}
