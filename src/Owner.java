class Owner(){
   
    private String user;
    private String pass;
    private boolean flag = false;    
    private double money;
   
    public Owner(String Username, String Password){
        this.user = Username;
        this.pass = Password;
        this.money = 0;
    }
   
    public boolean verify(String user, String pass){
        if (user.equals(this.user) && pass.equals(this.pass)){
            flag = true;
            return true;
        }
        return false;
    }
   
    public double addMoney(){
        this.money += this.money;
    }
    public double getMoney(){
        return this.money;
    }
   
     public void menu(/*arg*/){
        Scanner sc = new Scanner(System.in);
        if(flag == true){
        while(true){
            System.out.println("\tMenu");
            System.out.println("Press 1 to see free slots");
            System.out.println("Press 2 to check money recieved");
            System.out.println("Press 3 to remove a vehicle forcefully remove a vechicle.");
            System.out.println("Press 4 to check parked vehicle details.");
            System.out.println("Press 5 to return to main menu.\n")
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    //call method to display free slots
                    break;
   
                case 2:
                    System.out.println("Money recieved from previous transactions : "+this.getMoney());
                    break;
   
                case 3:
                    System.out.println("Enter the vehicle id to be removed : ");
                    String removeId = sc.nextLine();
                    //call method to remove that id and display the fare amount until that moment
                    System.out.println("Vehicle Removed!")
                   
                    break;
               
                case 4:
                    System.out.println("Enter the vehicle id to be removed : ");
                    String removeId = sc.nextLine();
                    System.out.println("\tVehicle Details");
                    for (int i = 0;i < cList.size();i++){
                        System.out.println("Name            : " + /*printdetails*/);
                        System.out.println("Vehicle id      : " + /*pintdetails*/);
                        System.out.println("Vehicle Tyep    :")
                        System.out.println("Time it entered : "+ /*time*/);
                        break;
                    }
                case 5:
                    continue outermenu;
                default:
                    System.out.println("Invalid choice!!");
           
                   
               
                }
            }
        }
       
    }
