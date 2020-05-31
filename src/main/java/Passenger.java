import java.util.ArrayList;

public class Passenger {

    private String name;
    private int numberOfBags;
    private Flight flight;
    private int seatNumber;

    @Override
    public String toString(){
        return ("Passenger name: " + this.getName() + ", " +
        "Seat Number: " + this.getSeatNumber());
    }

    public Passenger(String name, int numberOfBags){
        this.name = name;
        this.numberOfBags = numberOfBags;;
    }

    public String getName(){
        return this.name;
    }

    public int getNumberOfBags(){
        return this.numberOfBags;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public void addFlight(Flight flight){
        this.flight = flight;
    }

    public void addSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber(){
        return this.seatNumber;
    }
}
