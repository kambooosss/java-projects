package flight;
import java.util.ArrayList;
import java.util.*;

public class BookTicket {
    public static void main(String[] args) {
        List<Flight> flights= new ArrayList<>();
        int passengerId=0;
        for(int i=0;i<4;i++)
        {
            flights.add(new Flight());
        }
        int id;
        Flight currentFlight;
        int idToCancel;
        System.out.println("<--------------------Welcome to flight ticket reservation sytem--------------------------------------->");
        while(true)
        {
            for(Flight f:flights)
            {
                f.printDetails();
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("Enter your choice \n1.Book tickets\n2.cancel tickets");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter the flight id which u want to book:  ");
                    id=sc.nextInt();
                    if(flights.size() <= id)
                    {
                        System.out.println("invalid id");
                        break;
                    }
                    currentFlight = flights.get(id);
                    System.out.println("enter the no of ticket u want ");
                    int noOfTicketsPerId = sc.nextInt();
                    String passenderDetails="passenger id :  "+passengerId+"\n"+"no of tickets for this id  :"+noOfTicketsPerId+"\n"+"total cost  : "+currentFlight.price*noOfTicketsPerId;
                    if(currentFlight.addPassenger(passenderDetails, passengerId, noOfTicketsPerId))
                        System.out.println("booking successfull happy journy");
                    else
                    {
                        System.out.println("sorry only "+currentFlight.ticketsAvailable+"many seats are availabe");
                        break;
                    }
                        
                    System.out.println("your Details are:\n"+passenderDetails);
                    passengerId++;
                    break;
                case 2:
                    System.out.println("enter the flight id which u want to cancel:  ");
                    id=sc.nextInt();
                    if(flights.size() <= id)
                    {
                        System.out.println("invalid id");
                        break;
                    }
                    currentFlight = flights.get(id);
                    System.out.println("enter your passenger Id");
                    idToCancel=sc.nextInt();
                    if(currentFlight.removePassenger(idToCancel))
                    {
                        System.out.println("canceled successfully");
                    }
                    else
                        System.out.println("invalisd passenger id");
                    break;
                default:
                    return;
            }


        }
    }
    
}
