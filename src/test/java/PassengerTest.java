import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Plane plane;
    Flight flight;

    @Before
    public void setUp(){
        passenger = new Passenger("Oscar", 2);
        plane = new Plane(PlaneType.BOEING787);
        flight = new Flight(plane, "BA1476", "London",
                "Hong Kong International Airport", "23:45");
    }

    @Test
    public void canGetName(){
        assertEquals("Oscar", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags(){
        assertEquals(2, passenger.getNumberOfBags());
    }

    @Test
    public void canAddFlight(){
        passenger.addFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void canAddSeatNumber(){
        passenger.addSeatNumber(10);
        assertEquals(10, passenger.getSeatNumber());
    }
}
