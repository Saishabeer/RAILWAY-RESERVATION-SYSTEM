import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Boolean loop=true;
        while(loop){
            System.out.println("ENTER YOUR OPTION\n1.BOOK TICKET\n2.CANCEL TICKET\n3.SHOW BOOKED TICKES\n4.SHOW AVAILABLE TICKETS\n5.EXIT");
            int choice=s.nextInt();
            switch(choice){
                case 1:
                    System.out.println("ENTER YOUR NAME : ");
                    String name=s.next();
                    System.out.println("ENTER YOUR AGE : ");
                    int age=s.nextInt();
                    System.out.println("ENTER YOUR GENDER : ");
                    String gender=s.next();
                    System.out.println("ENTER YOUR BEARTH-PREFERENCE : ");
                    String bp=s.next();
                    Passenger p=new Passenger(name,age,gender,bp);
                    ticketBook(p);
                    break;
                case 2:
                    System.out.print("Enter Your Passenger ID : ");
                    int id=s.nextInt();
                    TicketBook.cancelTicket(id);
                    break;
                case 3:
                    System.out.println("BOOKED TICKETS ARE : ");
                    TicketBook tb=new TicketBook();
                    for(Passenger i:tb.BookedPassengerDetails.values()){
                        System.out.println("PASSENGER ID: "+i.passengerId+"\nPASSENGER NAME : "+i.name+"\nPASSENGER AGE :"+i.age+"\nPASSENGER GENDER :"+i.gender+"\nPASSENGER SEAT :"+i.seatnum+i.alloted+"\n");
                    }
                    break;
                case 4:
                    System.out.println("AVAILABLE TICKETS ARE :");
                    TicketBook.avl();
                    break;
                case 5:
                    loop=false;
                    System.out.println("EXITTING________________ :)");
                    break;
            }
        }
    }

    public static void ticketBook(Passenger p) {
        if(TicketBook.aLB>0 || TicketBook.aMB>0 || TicketBook.aUB>0){
            if(TicketBook.aLB>0 && p.bp.equals("L")){
                System.out.println("LOWERBERTH ALLOCATED SUCCESSFULLY");
                TicketBook.bookTicket(p,TicketBook.lBP.get(0),"LB");
                TicketBook.lBP.remove(0);
                TicketBook.aLB--;
            }
            else if(TicketBook.aMB>0 && p.bp.equals("M")){
                System.out.println("MIDDLEBERTH ALLOCATED SUCCESSFULLY");
                TicketBook.bookTicket(p,TicketBook.mBP.get(0),"MB");
                TicketBook.mBP.remove(0);
                TicketBook.aMB--;
            }
            else if(TicketBook.aUB>0 && p.bp.equals("U")){
                System.out.println("UPPERBERTH ALLOCATED SUCCESSFULLY");
                TicketBook.bookTicket(p,TicketBook.uBP.get(0),"UB");
                TicketBook.uBP.remove(0);
                TicketBook.aUB--;
            }
            else if(TicketBook.aLB>0){
                System.out.println("LOWERBERTH ALLOCATED DUE TO SEAT INSUFFICIENCY :)");
                TicketBook.bookTicket(p,TicketBook.lBP.get(0),"LB");
                TicketBook.lBP.remove(0);
                TicketBook.aLB--;
            }
            else if(TicketBook.aMB>0){
                System.out.println("MIDDLEBERTH ALLOCATED DUE TO SEAT INSUFFICIENCY :)");
                TicketBook.bookTicket(p,TicketBook.mBP.get(0),"MB");
                TicketBook.mBP.remove(0);
                TicketBook.aMB--;
            }
            else if(TicketBook.aUB>0){
                System.out.println("UPPERBERTH ALLOCATED DUE TO SEAT INSUFFICIENCY :)");
                TicketBook.bookTicket(p,TicketBook.uBP.get(0),"UB");
                TicketBook.uBP.remove(0);
                TicketBook.aUB--;
            }}
        else if(TicketBook.aRAC>0){
            System.out.println("TICKET ALLOCATED IN RAC BERTH DUE TO SEAT INSUFFICIENCY :)");
            TicketBook.bookRACTicket(p,TicketBook.racBP.get(0),"RAC");
            TicketBook.racBP.remove(0);
            TicketBook.aRAC--;
        }
        else if(TicketBook.aWL>0) {
                System.out.println("YOURE IN WAITINGLIST DUE TO SEAT INSUFFICIENCY :)");
                TicketBook.bookWLTicket(p, TicketBook.wlBP.get(0), "WL");
                TicketBook.wlBP.remove(0);
                TicketBook.aWL--;

            }

    }
}
