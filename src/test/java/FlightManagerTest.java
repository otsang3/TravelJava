import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Flight flight;
    Flight flightMaxCapacityOfThree;
    FlightManager flightManager;
    Plane plane;
    Plane planeMaxCapacityOfThree;

    @Before
    public void setUp(){
        flightManager = new FlightManager();
        passenger = new Passenger("Oscar", 2);
        passenger2 = new Passenger("Olivia", 1);
        passenger3 = new Passenger("Erika", 3);
        plane = new Plane(PlaneType.BOEING787);
        planeMaxCapacityOfThree = new Plane(PlaneType.MAXCAPACITYOFTHREE);
        flight = new Flight(plane, "BA1476", "London",
                "Hong Kong International Airport", "23:45");
        flightMaxCapacityOfThree = new Flight(planeMaxCapacityOfThree, "BA1476", "London",
                "Hong Kong International Airport", "23:45");
    }

    @Test
    public void canGetTotalBaggageCapacity(){
        assertEquals(80500, flightManager.baggageCapacity(plane));
    }

    @Test
    public void canGetPassengersBaggageWeight(){
        flight.addPassenger(passenger);
        assertEquals(40, flightManager.passengersBaggageWeight(flight));
    }

    @Test
    public void canGetAvailableBaggageWeight(){
        flight.addPassenger(passenger);
        assertEquals(80460, flightManager.availableBaggageWeight(plane, flight));
    }

    @Test
    public void canSortPassengers(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        Passenger[] passengers = new Passenger[]{passenger, passenger2, passenger3};
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
        flightManager.sortPassengersBySeatNumber(flight);
        System.out.println(flight.getPassengers());
        int passengerSeatNumber = flight.getPassengers().get(0).getSeatNumber();
        int passenger2SeatNumber = flight.getPassengers().get(1).getSeatNumber();
        int passenger3SeatNumber = flight.getPassengers().get(2).getSeatNumber();

        assertEquals(true, passengerSeatNumber < passenger2SeatNumber);
        assertEquals(true, passenger2SeatNumber < passenger3SeatNumber);

    }

    @Test
    public void canFindPassengerBySeatNumber(){
        flightMaxCapacityOfThree.addPassenger(passenger);
        flightMaxCapacityOfThree.addPassenger(passenger2);
        flightMaxCapacityOfThree.addPassenger(passenger3);
        Passenger[] passengers = new Passenger[]{passenger, passenger2, passenger3};
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
        Passenger foundPassenger =  flightManager.findPassengerBySeatNumber(flightMaxCapacityOfThree, 2);
        assertEquals(passenger2, foundPassenger);

    }
}
