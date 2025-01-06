import java.util.*;
public class Passenger {
    static int id=1;
    String name;
    int age;
    String gender;
    String bp;
    int passengerId=id++;
    int seatnum;
    String alloted;

    public Passenger(String name, int age, String gender, String bp){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.bp=bp;
        this.alloted="";
        this.seatnum=-1;
    }
}
