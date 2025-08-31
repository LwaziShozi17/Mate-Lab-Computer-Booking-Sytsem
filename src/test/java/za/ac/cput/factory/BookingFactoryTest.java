package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {
    @Test
    void createBooking() {
        Booking booking = BookingFactory.createBooking(
                //  23097L,
                230975623L,
                "ICT",
                "AppDev",
                "PC-01",
                "2025-08-20 09:00",
                "2025-08-20 11:00",
                "Eclipse IDE");
        assertNotNull(booking);
        System.out.println(booking);
    }
}
