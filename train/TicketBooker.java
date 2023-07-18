package train;

import java.util.*;

public class TicketBooker {
    
    
    static int noOfLowerberth=2;
    static int noOfUpperberth=2;
    static int noOfMiddleberth=2;
    static int noOfRacberth=2;
    static int noOfWaitingList=2;

    static List<Integer> LowerberthPositions = new ArrayList<>(Arrays.asList(1,2,3));
    static List<Integer> UpperberthPositions = new ArrayList<>(Arrays.asList(1,2,3));
    static List<Integer> MiddleberthPositions = new ArrayList<>(Arrays.asList(1,2,3));
    static List<Integer> RacberthPositions = new ArrayList<>(Arrays.asList(1,2,3));
    static List<Integer> WaitingListPositions = new ArrayList<>(Arrays.asList(1,2,3));

    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();
    static List<Integer> bookedList = new LinkedList<>();

    static Map<Integer,Pasenger> map = new HashMap<>();

    public static void bookTicket(Pasenger p)
    {
        bookedList.add(p.passengerId);
        map.put(p.passengerId, p);
        System.out.println("<==============================Booked succesfully=================================================>\n");
    }
    public static void cancelTicekt(int id)
    {
        if(!(map.containsKey(id)))
        {
            System.out.println("Passenger detail invalid");
        }
        else
        {
            Pasenger p = map.get(id);
            map.remove(id);
            bookedList.remove(id);

            
                if(p.alloted.equals("L"))
                {
                    noOfLowerberth++;
                    LowerberthPositions.add(p.seatNumber);
                    
                }
                else if(p.alloted.equals("U"))
                {
                    noOfUpperberth++;
                    UpperberthPositions.add(p.seatNumber);
                    
                }
                else if(p.alloted.equals("M"))
                {
                    noOfMiddleberth++;
                    MiddleberthPositions.add(p.seatNumber);
                    
                }

            if(racList.size() > 0)
            {
                Pasenger racPasenger =   map.get(racList.poll());
                RacberthPositions.add(racPasenger.seatNumber);
                noOfRacberth++;
                racList.remove(racPasenger.passengerId);
                if(waitingList.size() > 0)
                {
                    Pasenger waitingPasenger = map.get(waitingList.poll());
                    WaitingListPositions.add(waitingPasenger.seatNumber);
                    noOfWaitingList++;
                    noOfRacberth--;
                    waitingList.remove(racPasenger.passengerId);
                    waitingPasenger.seatNumber=RacberthPositions.get(0);
                    RacberthPositions.remove(0);
                    racList.add(waitingPasenger.passengerId);

                }



                if(p.alloted.equals("L"))
                {
                    
                    LowerberthPositions.add(p.seatNumber);
                    racPasenger.alloted="L";
                    racPasenger.seatNumber=LowerberthPositions.get(0);
                    LowerberthPositions.remove(0);
                    bookTicket(racPasenger);
                }
                else if(p.alloted.equals("U"))
                {
                    
                    UpperberthPositions.add(p.seatNumber);
                    racPasenger.alloted="U";
                    racPasenger.seatNumber=UpperberthPositions.get(0);
                    UpperberthPositions.remove(0);
                    bookTicket(racPasenger);
                }
                else if(p.alloted.equals("M"))
                {
                    
                    MiddleberthPositions.add(p.seatNumber);
                    racPasenger.alloted="M";
                    racPasenger.seatNumber=MiddleberthPositions.get(0);
                    MiddleberthPositions.remove(0);
                    bookTicket(racPasenger);
                }
                    

            }
            System.out.println("===================================cancelled succefully========================================");

        }
    }
    public static void addToRac(Pasenger p) {
        racList.add(p.passengerId);
        map.put(p.passengerId, p);

    }
    public static void addToWaitingList(Pasenger p)
    {
        waitingList.add(p.passengerId);
        map.put(p.passengerId, p);
    }
    public static void printAvailable()
    {
        System.out.println("Available Lower Berths "  + noOfLowerberth);
        System.out.println("Available Middle Berths "  + noOfMiddleberth);
        System.out.println("Available Upper Berths "  + noOfUpperberth);
        System.out.println("Availabel RACs " + noOfRacberth);
        System.out.println("Available Waiting List " + noOfWaitingList);
        System.out.println("-------------------------------------------------------------------------------");
    }

    //print all occupied passengers from all types including WL
    public static void printPassengers()
    {
        if(map.size() == 0)
        {
            System.out.println("No details of passengers");
            return;
        }
        for(Pasenger p : map.values())
        {
            System.out.println("PASSENGER ID " + p.passengerId );
            System.out.println(" Name " + p.name );
            System.out.println(" Age " + p.age );
            System.out.println(" Status " + p.seatNumber+ p.alloted);
            System.out.println("-------------------------------------------------------------------------------------------------");
        }
    }


    


}
