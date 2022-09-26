import java.util.*;
class MainMenu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Owner admin = new Owner("user","user@123");

        outermenu:
        while(true){
            System.out.println("\tMain Menu");
            System.out.println("Press 1 for customer.");
            System.out.println("Press 2 for owner.");
            System.out.println("Press 3 to exit.");
            System.out.println("\nMake a choice :");
            int choice = sc.nextInt();
            switch(choice){
                
                case 1:
                customermenu:
                while(true){
                    System.out.println("\n\tCustomer Menu");
                    System.out.println("Press 1 to assign a lot to vehicle");
                    System.out.println("Press 2 to remove a lot to vehicle");
                    System.out.println("Press 3 to print empty lots in a floor");
                    System.out.println("Press 4 to return to main menu\n");
                    System.out.print("Make a choice : ");
                    int choice1 = sc.nextInt();
                    switch(choice1){
                        case 1:
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
                            //pl.processExitsAndEntries();
                            break;
                        case 2:
                            System.out.print("Enter vehicle id: ");
                            vehicleID = sc.nextLine();
                            pl.leaveVehicle(vehicleID);
                            //pl.processExitsAndEntries();
                            
                            System.out.print("Press 0 to pay by cash and press 1 to pay by card :");
                            int paymentMethod = sc.nextInt();
                            break;
                        case 3:
                            pl.printFreeSlots();;
                            break;
                        case 4:
                            continue outermenu;
                        default:
                            System.out.println("Make a valid choice!!");        
                    }
                }
            
                case 2:
                System.out.println("Enter userID and password : ");
                String user = sc.nextLine();
                String pw = sc.nextLine();
                while(!admin.verify(user,pw)){
                    System.out.println("Invalid USERID and PW");
                    System.out.println("Enter again : ");
                    user = sc.nextLine();
                    pw = sc.nextLine();
                }

                ownermenu:
                while(true){
                    System.out.println("\n\tOwner Menu");
                    System.out.println("Press 1 to see free slots");
                    System.out.println("Press 2 to check money recieved");
                    System.out.println("Press 3 to remove a vehicle forcefully remove a vechicle.");
                    System.out.println("Press 4 to check parked vehicle details.");
                    System.out.println("Press 5 to return to main menu.\n");
                    int choice1 = sc.nextInt();
                    switch(choice1){
                        case 1:
                            //call method to display free slots
                            break;
        
                        case 2:
                            System.out.println("Money recieved from previous transactions : "+admin.getMoney());
                            break;
        
                        case 3:
                            System.out.println("Enter the vehicle id to be removed : ");
                            String removeId = sc.nextLine();
                            //call method to remove that id and display the fare amount until that moment
                            System.out.println("Vehicle Removed!");

                            break;
                    
                        case 4:
                            System.out.println("Enter the vehicle id to be removed : ");
                            String IDtocheck = sc.nextLine();
                            System.out.println("\tVehicle Details");
                            for (int i = 0; i<cList.size();i++){
                                System.out.println("Name            : " + /*printdetails*/);
                                System.out.println("Vehicle id      : " + /*pintdetails*/);
                                System.out.println("Vehicle Type    :"+/*electric or not shit */);
                                System.out.println("Time it entered : "+ /*time*/);
                                break;
                            }
                        case 5:
                            continue outermenu;
                        default:
                            System.out.println("Invalid choice!!");
                    }
                }
                case 3:
                    System.exit();
                default :
                    System.out.println("Make a valid choice!!");
            }
        }
    }
}
