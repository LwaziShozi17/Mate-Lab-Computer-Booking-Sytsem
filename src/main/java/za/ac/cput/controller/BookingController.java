package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create booking
    @PostMapping("/Book")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking createdBooking = bookingService.create(booking);
            return ResponseEntity.ok(createdBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Get booking by studentId
    @GetMapping("/LoadBookingByStudentId/{studentId}")
    public ResponseEntity<?> findBookingByStudentId(@PathVariable Long studentId) {
        try {
            Booking booking = bookingService.read(studentId);
            return ResponseEntity.ok(Map.of(
                    "bookingId", booking.getBookingId(),
                    "studentId", booking.getStudentId(),
                    "computerId", booking.getComputerId(),
                    "faculty", booking.getFaculty(),
                    "course", booking.getCourse(),
                    "startTime", booking.getStartTime(),
                    "endTime", booking.getEndTime(),
                    "software", booking.getSoftware()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Get booking by bookingId
    @GetMapping("/LoadBookingByBookingId/{bookingId}")
    public ResponseEntity<?> findBookingByBookingId(@PathVariable Long bookingId) {
        try {
            Booking booking = bookingService.searchByBookingId(bookingId);
            return ResponseEntity.ok(Map.of(
                    "bookingId", booking.getBookingId(),
                    "studentId", booking.getStudentId(),
                    "computerId", booking.getComputerId(),
                    "faculty", booking.getFaculty(),
                    "course", booking.getCourse(),
                    "startTime", booking.getStartTime(),
                    "endTime", booking.getEndTime(),
                    "software", booking.getSoftware()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Delete booking by bookingId
    @DeleteMapping("/CancelBookingByBookingId/{bookingId}")
    public ResponseEntity<?> deleteBookingByBookingId(@PathVariable Long bookingId) {
        try {
            bookingService.deleteByBookingId(bookingId);
            return ResponseEntity.ok(Map.of(
                    "message", "Booking deleted successfully",
                    "bookingId", bookingId
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Delete booking by studentId
    @DeleteMapping("/CancelBookingByStudentId/{studentId}")
    public ResponseEntity<?> deleteBookingByStudentId(@PathVariable Long studentId) {
        try {
            bookingService.deleteByStudentId(studentId);
            return ResponseEntity.ok(Map.of(
                    "message", "Booking(s) deleted successfully",
                    "studentId", studentId
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
