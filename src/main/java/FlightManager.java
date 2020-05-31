import java.util.ArrayList;

public class FlightManager {

    public FlightManager(){

    }

    public int baggageCapacity(Plane plane){
        return (plane.getTotalWeight() / 2);
    }

    public int passengersBaggageWeight(Flight flight){
        int totalWeight = 0;
        for (Passenger passenger : flight.getPassengers()){
            totalWeight += (passenger.getNumberOfBags()*20);
        }
        return totalWeight;
    }

    public int availableBaggageWeight(Plane plane, Flight flight){
        return (this.baggageCapacity(plane) - this.passengersBaggageWeight(flight));
    }

    public void sortPassengersBySeatNumber(Flight flight){
        ArrayList<Passenger> passengers = flight.getPassengers();
        passengers.sort((Passenger passenger1, Passenger passenger2) -> {
            if (passenger1.getSeatNumber() > passenger2.getSeatNumber())
                return 1;
            if (passenger1.getSeatNumber() < passenger2.getSeatNumber())
                return -1;
            return 0;
        });
    }

    public int binarySearchPassengerBySeatNumber(Flight flight, int seatNumber){

        ArrayList<Passenger> passengersList = flight.getPassengers();
        int left = 0;
        int right = passengersList.size() - 1;

        while(left <= right){
            int middle = (left + right) / 2;
            if(seatNumber < passengersList.get(middle).getSeatNumber()){
                right = middle - 1;
            }
            else if (seatNumber > passengersList.get(middle).getSeatNumber()){
                left = middle + 1;
            }
            else {
                return middle;
            }
        }
        return -1;
    }

    public Passenger findPassengerBySeatNumber(Flight flight, int seatNumber){
        int seatReturn = this.binarySearchPassengerBySeatNumber(flight, seatNumber);
        if (seatReturn != -1){
            return flight.getPassengers().get(seatNumber);
        }
        return null;
    }
}
