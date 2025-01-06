import java.util.*;

public class TicketBook {
    static int aLB=23;
    static int aMB=23;
    static int aUB=23;
    static int aRAC=10;
    static int aWL=10;
    Scanner s=new Scanner(System.in);
    static List<Integer> lBP=new ArrayList<>(range(aLB));
    static List<Integer> mBP=new ArrayList<>(range(aMB));
    static List<Integer> uBP=new ArrayList<>(range(aUB));
    static List<Integer> racBP=new ArrayList<>(range(aRAC));
    static List<Integer> wlBP=new ArrayList<>(range(aWL));

    static List<Integer> bookedTicketList=new ArrayList<>();
    static Queue<Integer> RACList=new LinkedList<>();
    static Queue<Integer> WLList=new LinkedList<>();

    static LinkedHashMap<Integer,Passenger> BookedPassengerDetails=new LinkedHashMap<>();

    public static void bookTicket(Passenger p,int seatnum,String alloted){
        p.seatnum=seatnum;
        p.alloted=alloted;
        TicketBook.bookedTicketList.add(p.passengerId);
        TicketBook.BookedPassengerDetails.put(p.passengerId,p);
        System.out.println("\nYOURE TICKET IS BOOKED SUCCESSFULLY ");
        System.out.println("PASSENGER ID : "+p.passengerId);
        System.out.println("PASSENGER NAME : "+p.name);
        System.out.println("PASSENGER AGE : "+p.age);
        System.out.println("PASSENGER GENDER : "+p.gender);
        System.out.println("PASSENGER BERTH : "+p.seatnum+alloted);
        System.out.println("HAPPY JOURNEY\n");
    }
    public static void bookRACTicket(Passenger p,int seatnum,String alloted){
        p.seatnum=seatnum;
        p.alloted=alloted;
        TicketBook.RACList.add(p.passengerId);
        TicketBook.BookedPassengerDetails.put(p.passengerId,p);
        System.out.println("YOURE TICKET IS BOOKED IN RAC BERTH (: ");
        System.out.println("PASSENGER ID : "+p.passengerId);
        System.out.println("PASSENGER NAME : "+p.name);
        System.out.println("PASSENGER AGE : "+p.age);
        System.out.println("PASSENGER GENDER : "+p.gender);
        System.out.println("PASSENGER BERTH : "+p.seatnum+alloted);
        System.out.println("SORRY FOR THE INCONVENIENCE ..HAPPY JOURNEY!");
    }
    public static void bookWLTicket(Passenger p,int seatnum,String alloted){
        p.seatnum=seatnum;
        p.alloted=alloted;
        TicketBook.WLList.add(p.passengerId);
        TicketBook.BookedPassengerDetails.put(p.passengerId,p);
        System.out.println("YOURE TICKET IS IN WAITINGE LIST ");
        System.out.println("PASSENGER ID : "+p.passengerId);
        System.out.println("PASSENGER NAME : "+p.name);
        System.out.println("PASSENGER AGE : "+p.age);
        System.out.println("PASSENGER GENDER : "+p.gender);
        System.out.println("PASSENGER BERTH : "+p.seatnum+alloted);
        System.out.println("SORRY FOR THE INCONVENIENCE ..HAPPY JOURNEY");
    }

    public static void avl() {
        System.out.println("AVAIABLE LOWER BERTH TICKETS ARE : "+aLB);
        if(aLB>0){
            System.out.print("AVAIABLE LOWER BERTH SEATS ARE : ");
            for(int i: lBP){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println("AVAIABLE LOWER BERTH TICKETS ARE : "+aMB);
        if(aMB>0){
            System.out.print("AVAIABLE MIDDLE BERTH SEATS ARE : ");
            for(int i: mBP){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println("AVAIABLE LOWER BERTH TICKETS ARE : "+aUB);
        if(aUB>0){
            System.out.print("AVAIABLE UPPER BERTH SEATS ARE : ");
            for(int i: uBP){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println("AVAIABLE LOWER BERTH TICKETS ARE : "+aRAC);
        if(aRAC>0){
            System.out.print("AVAIABLE RAC BERTH SEATS ARE : ");
            for(int i: racBP){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println("AVAIABLE LOWER BERTH TICKETS ARE : "+aWL);
        if(aWL>0){
            System.out.print("AVAIABLE WAITING LIST SEATS ARE : ");
            for(int i: wlBP){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        if(aWL==0 && aRAC==0 && aLB==0 && aUB==0 && aMB==0){
            System.out.println("NO TICKETS ARE AVAILABLE");
        }
    }
    static List<Integer> range(int n){
        List<Integer> l=new ArrayList<>();
        for(int i=1;i<=n;i++){
            l.add(i);
        }
        return l;
    }

    public static void cancelTicket(int id) {
        if(!(BookedPassengerDetails.containsKey(id))){
            System.out.println("Passenger Not Available");
        }
        else{
            Passenger p=BookedPassengerDetails.get(id);
            BookedPassengerDetails.remove(id);
            bookedTicketList.remove(Integer.valueOf(id));
            if(p.alloted.equals("LB") || p.alloted.equals("MB") || p.alloted.equals("UB")) {
                int seatnum = p.seatnum;
                if (p.alloted.equals("LB")) {
                    aLB++;
                    lBP.add(seatnum);
                } else if (p.alloted.equals("MB")) {
                    aMB++;
                    mBP.add(seatnum);
                } else if (p.alloted.equals("UB")) {
                    aUB++;
                    uBP.add(seatnum);
                }
                if (!(RACList.isEmpty())) {
                    Passenger rac = BookedPassengerDetails.get(RACList.poll());
                    int racseatnum = rac.seatnum;
                    racBP.add(racseatnum);
                    aRAC++;
                    if (!(WLList.isEmpty())) {
                        Passenger wl = BookedPassengerDetails.get(WLList.poll());
                        int wlseatnum = wl.seatnum;
                        wlBP.add(wlseatnum);
                        wl.seatnum = racBP.getFirst();
                        racBP.removeFirst();
                        wl.alloted = "RAC";
                        aRAC--;
                        aWL++;
                    }
                Main.ticketBook(rac);}}
                else if (p.alloted.equals("RAC")) {
                    racBP.add(p.seatnum);
                    aRAC++;
                    if(!(WLList.isEmpty())){
                        Passenger wl = BookedPassengerDetails.get(WLList.poll());
                        int wlseatnum = wl.seatnum;
                        wlBP.add(wlseatnum);
                        wl.seatnum = racBP.getFirst();
                        racBP.removeFirst();
                        wl.alloted = "RAC";
                        aRAC--;
                        aWL++;
                    }
                }
                else if(p.alloted.equals("WL")){
                    WLList.add(p.seatnum);
                    aWL++;
                }
            }
    }
}
