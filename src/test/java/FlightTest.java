import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Plane plane;
    Plane planeNoCapacity;
    Plane planeMaxCapacityOfThree;
    Flight flight;
    Flight flightNoCapacity;
    Flight flightMaxCapacityOfThree;


    @Before
    public void setUp(){
        passenger = new Passenger("Oscar", 2);
        passenger2 = new Passenger("Olivia", 1);
        passenger3 = new Passenger("Erika", 3);
        plane = new Plane(PlaneType.BOEING787);
        planeNoCapacity = new Plane(PlaneType.NOCAPACITY);
        planeMaxCapacityOfThree = new Plane(PlaneType.MAXCAPACITYOFTHREE);
        flight = new Flight(plane, "BA1476", "London",
                "Hong Kong International Airport", "23:45");
        flightNoCapacity = new Flight(planeNoCapacity, "BA1476", "London",
                "Hong Kong International Airport", "23:45");
        flightMaxCapacityOfThree = new Flight(planeMaxCapacityOfThree, "BA1476", "London",
                "Hong Kong International Airport", "23:45");

    }

    @Test
    public void canGetPassengers(){
        ArrayList<Passenger> passengerList = flight.getPassengers();
        assertEquals(0, passengerList.size());
    }

    @Test
    public void canGetPlane(){
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void canGetFlightNumber(){
        assertEquals("BA1476", flight.getFlightNumber());
    }

    @Test
    public void canGetDestination(){
        assertEquals("London", flight.getDestination());
    }

    @Test
    public void canGetDepartureAirport(){
        assertEquals("Hong Kong International Airport", flight.getDepartureAirport());
    }

    @Test
    public void canGetDepartureTime(){
        assertEquals(LocalTime.parse("23:45"), flight.getDepartureTime());
    }

    @Test
    public void canGetRemainingSeats(){
        assertEquals(330, flight.getRemainingSeats());
    }

    @Test
    public void canGetSeatArray(){
        assertEquals(330, flight.getSeatArray().length);
        assertEquals(10, flight.getSeatArray()[9]);
    }

    @Test
    public void canGetRandomSeatNumber(){
        System.out.println(flight.getRandomSeatNumber());
    }

    @Test
    public void canRemoveRandomSeatNumberFromArray(){
        flight.removeSeatNumberFromArray(10);
        assertEquals(329, flight.getSeatArray().length);
    }

    @Test
    public void canBookPassengerTrue(){
        flight.addPassenger(passenger);
        System.out.println(passenger.toString());
        flight.getSeatArray();
        for (int i = 0; i < flight.getSeatArray().length; i++) {
            System.out.println( flight.getSeatArray()[i] + " ");
        };
        assertEquals(329, flight.getSeatArray().length);
    }

    @Test
    public void canBookPassengerFalse(){
        flightNoCapacity.addPassenger(passenger);
        assertEquals(0, flight.getPassengers().size());
    }

    @Test
    public void canBookMultiplePassengers(){
        flightMaxCapacityOfThree.addPassenger(passenger);
        System.out.println(flightMaxCapacityOfThree.getSeatArray().length);
        System.out.println(flightMaxCapacityOfThree.getSeatArray()[0]);
        System.out.println(flightMaxCapacityOfThree.getSeatArray()[1]);
        flightMaxCapacityOfThree.addPassenger(passenger2);
        System.out.println(flightMaxCapacityOfThree.getSeatArray().length);
        System.out.println(flightMaxCapacityOfThree.getSeatArray()[0]);
        flightMaxCapacityOfThree.addPassenger(passenger3);
        Passenger[] passengers = new Passenger[]{passenger, passenger2, passenger3};
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
        assertEquals(0, flightMaxCapacityOfThree.getRemainingSeats());
        assertEquals(3, flightMaxCapacityOfThree.getPassengers().size());
    }


}
