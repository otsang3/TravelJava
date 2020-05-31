import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private LocalTime departureTime;
    private int[] seatArray;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, String departureTime){

        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = LocalTime.parse(departureTime);
        this.seatArray = IntStream.iterate(1, n -> n + 1).limit(this.plane.getCapacity()).toArray();
    }

    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }

    public Plane getPlane(){
        return this.plane;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public String getDestination(){
        return this.destination;
    }

    public String getDepartureAirport(){
        return this.departureAirport;
    }

    public LocalTime getDepartureTime(){
        return this.departureTime;
    }

    public int[] getSeatArray(){
        return this.seatArray;
    }

    public int getRandomSeatNumber(){
        int[] seatNumbers = this.getSeatArray();
        List<Integer> seatList = Arrays.stream(seatNumbers).boxed()
                .collect(Collectors.toList());
        if (seatList.size() > 1) {
            Collections.shuffle(seatList);
        }

        return seatList.get(0);
    }

    public void removeSeatNumberFromArray(int seatNumber){
        this.seatArray = IntStream.range(0, this.getSeatArray().length).filter(i -> i != seatNumber)
                .map(i -> this.seatArray[i]).toArray();
    }

    public void addPassenger(Passenger passenger){
        if (getRemainingSeats() > 0) {
            this.passengers.add(passenger);
            int randomSeatNumber = this.getRandomSeatNumber();
            passenger.addSeatNumber(randomSeatNumber);
            this.removeSeatNumberFromArray(randomSeatNumber - 1);
        }
    }

    public int getRemainingSeats(){
        return plane.getCapacity() - passengers.size();
    }


}
