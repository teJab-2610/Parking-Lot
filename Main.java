import java.io.*;
import java.util.*;
import java.lang.*;


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

class Lot{
    int lotType;
    int fareDue;
    float electricityFare;
    String id;
    String vehicleID;
}

class Floor{
    int[] types;

    Floor(int[] types)
    {
        this.types = types;
    }

    // public boolean freeSlots()
    public void occupyLot(Lot l)
    {

    }

    public void vacateLot(Lot l)
    {
        l.vehicleID = null; // reset the lot id
        l.fareDue = 0;
        l.electricityFare = 0;
    }
}

class ParkingLot{
    LinkedList<Floor> floors = new LinkedList<Floor>();
    Queue<String> enterQueue = new LinkedList<String>();
    Queue<String> exitQueue = new LinkedList<String>();

    public void leaveVehicle(String vehicle)
    {
        enterQueue.add(vehicle);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}