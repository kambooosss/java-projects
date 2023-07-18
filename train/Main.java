package train;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to Indian railways");
        while(true)
        {
            System.out.println("enter your choice \n1.book\n2.cancel\n3.show details");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    if(TicketBooker.noOfWaitingList == 0)
                    {
                        System.out.println("sorry no ticket availabel");
                        break;
                    }
                        
                    System.out.println("enter your berth preference");
                    String berthPreference =sc.next();
                    System.out.println("Enter your age : ");
                    int age = sc.nextInt();
                    System.out.println("enter your name");
                    String name = sc.next();
                    Pasenger p = new Pasenger(berthPreference, age, name);
                    if(TicketBooker.noOfLowerberth > 0 && berthPreference.equals("L") || TicketBooker.noOfMiddleberth>0 && berthPreference.equals("M") || TicketBooker.noOfUpperberth>0 && berthPreference.equals("U"))
                    {
                        if(berthPreference.equals("L"))
                        {
                            p.seatNumber=TicketBooker.LowerberthPositions.get(0);
                            TicketBooker.LowerberthPositions.remove(0);
                            TicketBooker.noOfLowerberth--;
                        }
                        else if(berthPreference.equals("M"))
                        {
                            p.seatNumber=TicketBooker.MiddleberthPositions.get(0);
                            TicketBooker.MiddleberthPositions.remove(0);
                            TicketBooker.noOfMiddleberth--;
                        }
                        else 
                        {
                            p.seatNumber=TicketBooker.UpperberthPositions.get(0);
                            TicketBooker.UpperberthPositions.remove(0);
                            TicketBooker.noOfUpperberth--;
                        }
                        p.alloted=berthPreference;
                        TicketBooker.bookTicket(p);
                    }
                    else if(TicketBooker.noOfLowerberth > 0)
                    {
                        p.alloted="L";
                        p.seatNumber=TicketBooker.LowerberthPositions.get(0);
                        TicketBooker.LowerberthPositions.remove(0);
                        TicketBooker.bookTicket(p);
                        TicketBooker.noOfLowerberth--;

                    }
                    else if(TicketBooker.noOfMiddleberth > 0)
                    {
                        p.alloted="M";
                        p.seatNumber=TicketBooker.MiddleberthPositions.get(0);
                        TicketBooker.MiddleberthPositions.remove(0);
                        TicketBooker.bookTicket(p);
                        TicketBooker.noOfMiddleberth--;
                    }
                    else if(TicketBooker.noOfUpperberth > 0)
                    {
                        p.alloted="U";
                        p.seatNumber=TicketBooker.UpperberthPositions.get(0);
                        TicketBooker.UpperberthPositions.remove(0);
                        TicketBooker.bookTicket(p);
                        TicketBooker.noOfUpperberth--;
                    }
                    else if(TicketBooker.noOfRacberth > 0)
                    {
                        p.alloted="RAC";
                        p.seatNumber=TicketBooker.RacberthPositions.get(0);
                        TicketBooker.RacberthPositions.remove(0);
                        TicketBooker.addToRac(p);
                        TicketBooker.noOfRacberth--;
                    }
                    else 
                    {
                        p.alloted="WL";
                        p.seatNumber=TicketBooker.WaitingListPositions.get(0);
                        TicketBooker.WaitingListPositions.remove(0);
                        TicketBooker.addToWaitingList(p);
                        TicketBooker.noOfWaitingList--;
                        
                    }

                    break;
                case 2:
                    System.out.println("Enter the passenger id to cancel the ticket");
                    int id = sc.nextInt();
                    TicketBooker.cancelTicekt(id);
                    
                    break;
                case 3:
                    TicketBooker.printPassengers();
                    TicketBooker.printAvailable();
                    break;
                default :
                    break;
                    
                    
                    
                   
            }

        }      
    }
}
