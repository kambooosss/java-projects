package flight;
import java.util.*;
public class Flight
{
    static int id=0;
    int flightId;
    int ticketsAvailable;
    int price;
    
    List<String> passengerDetails;
    List<Integer> passengerIds;
    List<Integer> noOfTicketsPerId;
    List<Integer> priecPerId;

    public Flight() {
        
        flightId=id;
        ticketsAvailable=50;
        price=5000;
        passengerDetails = new ArrayList<>();
        passengerIds= new ArrayList<>();
        noOfTicketsPerId = new ArrayList<>();
        priecPerId=new ArrayList<>();
        id++;
        
    }
    public boolean addPassenger(String passengerDetails,int passengerId,int noOfTicketsPerId)
    {
        if(noOfTicketsPerId > ticketsAvailable)
            return false;
        this.passengerDetails.add(passengerDetails);
        this.passengerIds.add(passengerId);
        this.noOfTicketsPerId.add(noOfTicketsPerId);
        this.priecPerId.add(price*noOfTicketsPerId);
        price+=200*noOfTicketsPerId;
        ticketsAvailable-=noOfTicketsPerId;
        return true;
    }
    public boolean removePassenger(int passengerId)
    {
        int indexToBeRemoved=passengerIds.indexOf(passengerId);
        if( indexToBeRemoved < 0)
            return false;
        
        this.passengerDetails.remove(indexToBeRemoved);
        this.passengerIds.remove(indexToBeRemoved);
        price-=200*noOfTicketsPerId.get(indexToBeRemoved);
        ticketsAvailable+=noOfTicketsPerId.get(indexToBeRemoved);
        this.priecPerId.remove(indexToBeRemoved);


        this.noOfTicketsPerId.remove(indexToBeRemoved);

        return true;
    }
    public void printDetails()
    {
        int filled = 50 - ticketsAvailable;
        System.out.println("flight Id :"+flightId + "       no of seats filled  :" + filled );
    }
    

    

    
}