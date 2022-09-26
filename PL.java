import java.util.*;
import java.io.*;
import java.lang.*;
import java.security.*;
import java.time.*;
/*
 * Types is the number of parking lots of each type
 * on each floor
 * types[0] = compact
 * types[1] = large
 * types[2] = handicapped
 * types[3] = motorcycles
 * types[4] = electric
 */

 /*
  * Vehicle Types:
  1. Car
  2. Truck
  3. Van
  4. Motorcycle
  */

interface Money{
    boolean payFees(String vehicleId, int fees);
}

class Payment implements Money{
    String getCard(String vehicleId){
        return "32232322332";
    }
    public boolean payFees(String vehicleId, int fees){
        System.out.println("Fee of "+fees+" paid by "+getCard(vehicleId));    
        return true;
    }

    public boolean payFees(String vehicleId, int fees, int elecFees){
        System.out.println("Fee of "+(fees + elecFees)+" paid by "+getCard(vehicleId));    
        return true;
    }
}

class ParkingLot{
    
    class Floor{
        
        class Lot{ //Struct
            public int lotType;
            public long startTime;
            public float electricityFare;
            public String vehicleID;

            //Lot constuctor to specify the type of lot
            public Lot(int lotType){
                this.lotType=lotType;
                vehicleID="";
                electricityFare=0;
            }
        }
    
        ArrayList<Lot> types;
    
        Floor(int[] types){
            this.types = new ArrayList<Lot>();
            for (int j=0; j<5; j++){
                for (int i=0; i<types[j]; i++){
                    this.types.add(new Lot(j));
                }
            }
            System.out.println(this.types);
        }
    
        public boolean freeSlots(){
            for (Lot lot: types) if (lot.vehicleID=="") return true;
            return false;
        }

        public void occupyLot(String vehicleID, int type){
            for (Lot lot: types){
                if (lot.lotType==type && lot.vehicleID==""){
                    lot.vehicleID=vehicleID;
                    lot.startTime = System.currentTimeMillis();
                    lot.electricityFare=0;
                    break;
                }
            }
        }
    
        public void vacateLot(Lot l){
            l.vehicleID = null; // reset the lot id
            l.electricityFare = 0;
        }
    }
    
    Floor[] floors;
    Queue<String> enterQueue = new LinkedList<String>();
    Queue<String> exitQueue = new LinkedList<String>();

    public void enterVehicle(String vehicle, int type)
    {
        enterQueue.add(type+vehicle);
    }

    public void leaveVehicle(String vehicle){
        for (Floor floor: floors){
            for (Floor.Lot lot: floor.types){
                if (lot.vehicleID==vehicle.substring(1)){
                    lot.vehicleID="";
                    break;
                }
            }
        }

        exitQueue.add(vehicle);
    }

    public void process(){
        if(enterQueue.size() != 0)
        {
            String entering = enterQueue.remove();
            for (Floor floor: floors){
                if (floor.freeSlots()){
                    floor.occupyLot(entering.substring(1), (entering.charAt(0) - '0'));
                    break;
                } 
            }
        }

        if(exitQueue.size() != 0)
        {
            String leaving = exitQueue.remove();
            Floor.Lot occupied;
            Floor needed;
            for (Floor floor: floors){
                for (Floor.Lot lot: floor.types) if (lot.vehicleID==leaving.substring(1)){
                    occupied=lot;
                    needed=floor;
                    Payment fee =new Payment();
                    int time = (int)((System.currentTimeMillis()-lot.startTime)*3600);
                    int time1 = time;
                    int fees = 0, elecFees = 0;
                    while(time > 0)
                    {
                        fees += 20; // first hour
                        time--;
    
                        if(time == 0)
                            break;
                        fees += 10; // second hour
                        time--;
    
                        if(time == 0)
                            break;
                        fees += 10*time; // rest
                        time = 0;
                    }
                    if(leaving.charAt(0) == '4')
                    {
                        elecFees = time1*10;
                        fee.payFees(leaving.substring(1), fees, elecFees);
                    }
                    else fee.payFees(leaving.substring(1), fees);
                    needed.vacateLot(occupied);
                }
            }
            
        }
    }

    public void printFreeSlots(){
        int[] count = new int[5];
        Arrays.fill(count, 0);
        for (Floor floor: floors){
            for (Floor.Lot lot: floor.types){
                if (lot.vehicleID=="") count[lot.lotType]++;
            }
        }
        System.out.println("Free compact slots: "+count[0]);
        System.out.println("Free large slots: "+count[1]);
        System.out.println("Free handicapped slots: "+count[2]);
        System.out.println("Free motorcycle slots: "+count[3]);
        System.out.println("Free electric slots: "+count[4]);
    }

    public ParkingLot(int[][] lots, int size){
        int index=0;
        floors = new Floor[size];
        for (int floorLots[]: lots){
            floors[index] = new Floor(floorLots);
            System.out.println(floors[index]);
            index++;
        }
    }
}

public class PL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] lots = {{20,10,20,0,10},{20,10,20,0,10},{20,20,0,30,10},{20,20,0,30,10}};
        ParkingLot pl = new ParkingLot(lots,4);
        String vehicleID;

                                /******  MENU *******/
        System.out.println("\t\tMenu");
        System.out.println("Press 1 to assign a lot to vehicle");
        System.out.println("Press 2 to remove a lot to vehicle");
        System.out.println("Press 3 to print empty lots in a floor");
        System.out.println("Press 4 to quit");
        while(true){
            System.out.print("Make a choice : ");
            int choice = sc.nextInt();
            if(choice == 1)
            {
                sc.nextLine();
                    System.out.print("Enter vehicle ID: ");
                    vehicleID = sc.nextLine();
                    
                    System.out.println("Enter the type of vehicle: ");
                    System.out.println("1.Car\n2.Truck\n3.Van\n4.Motorcycle");
                    int typeOfVehicle = sc.nextInt();

                    System.out.print("If the driver is handicapped, press 1, else 0 :");
                    int handicapped = sc.nextInt();

                    System.out.print("If the vehicle is electric, press 1, else 0 :");
                    int electric = sc.nextInt();

                    int type = 0;
                    if(electric == 1)
                        type = 4;
                    else if(handicapped == 1)
                        type = 2;
                    else 
                    {
                        if(typeOfVehicle == 1)
                            type = 0;
                        else if(typeOfVehicle == 2 || typeOfVehicle == 3)
                            type = 1;
                        else if(typeOfVehicle == 4)
                            type = 3;
                    }

                    pl.enterVehicle(vehicleID, type);
            }
            else if(choice == 2)
            {
                    sc.nextLine();
                    System.out.print("Enter vehicle id: ");
                    vehicleID = sc.nextLine();
                    pl.leaveVehicle(vehicleID);
                    
                    //ask for payment methods
                    System.out.println("Press 0 to pay by cash and press 1 to pay by card");
                    int paymentMethod = sc.nextInt();
            }
            else if(choice == 3)
                pl.printFreeSlots();
            else if(choice == 4)
                break;

            if(choice < 3)
                pl.process();
            } 
        }
    }
