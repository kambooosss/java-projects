package train;

public class Pasenger {
    static int id=1;
    String name;
    int age;
    int passengerId;
    String birtPreference;
    String alloted;
    int seatNumber;
    public Pasenger(String birthPreference , int age,String name) {
        this.age=age;
        this.birtPreference=birthPreference;
        this.name=name;
        passengerId=id++;
        birtPreference="";
        alloted="";
        seatNumber=-1;
        
    }

    
}
