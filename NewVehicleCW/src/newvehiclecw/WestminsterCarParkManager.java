/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newvehiclecw;
import java.util.*;
// I imported util for my threads
/**
 *
 * @author Andreas Nordstrom
 */
public class WestminsterCarParkManager implements Runnable{
    static Vehicles[] myCarPark = new Vehicles[20];
    // This is the array of the vehicles
    
    static Vehicles lastaccessedvehicle;
    static int isvanfull = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        WestminsterCarParkManager caller = new WestminsterCarParkManager();
        Thread T = new Thread(caller, "Thread");
        T.start();
        // This is the start of my thread
        String choice = "";
        while (!choice.equals("z")){
            
            System.out.println("WELCOME TO WESTMINSTER CAR PARK");
            System.out.println("PRESS 'V' - To View");
            System.out.println("PRESS 'A' - To Add");  
            System.out.println("PRESS 'D' - To Delete");
            System.out.println("PRESS 'C' - To Calculate fees");
            System.out.println("PRESS 'S' - To Show Statistics");                     
            System.out.println("PRESS 'F' - To Search");

            choice = in.next().toLowerCase();
            
            if(choice.equals("v")){
                int isitempty = 1;
                for (int i = 0; i < myCarPark.length; i++){
                    if(myCarPark[i] != null){
                        isitempty = 0;
                        break;
                    }
                }
                if (isitempty == 1){
                    System.out.println("No cars stored");
                }
                if (isitempty == 0){
                    System.out.println("Vehicles located:");
                    caller.viewCarPark();
                }
            }
            if(choice.equals("a")){
                
                int isitfull = 1;
                
                for (int i = 0; i < myCarPark.length-1; i++){
                    if (myCarPark[i] == (null) && myCarPark[i+1] == null){
                        isvanfull = 0;
                    }
                    
                    else{
                        isvanfull = 1;
                    }

                    
                    
                }
                for (int i=0; i<myCarPark.length;i++){
                    if(myCarPark[i] == null){
                        isitfull = 0;
                        break;
                    }
                }
                if (isitfull == 1){
                    System.out.println("The car park is full");
                }
                if (isitfull == 0){
                    caller.addvehicle();
                }
            }
            if (choice.equals("d")){
                caller.deletevehicle();
            }
            
            if (choice.equals("c")){
                caller.calculatecost();
            }
            if (choice.equals("s")){
                caller.mystats();
            }
            if (choice.equals("f")){
                caller.locateme();
            }
        }   
        // This is for the users to chose their choice
        
    }
    
    
    public void locateme(){
        Scanner in = new Scanner(System.in);
        System.out.println("Day:");
        int Day = in.nextInt();
        System.out.println("Month:");
        int Month = in.nextInt();
        System.out.println("Year:");
        int Year = in.nextInt();
        int Located = 0;
        // The user inputs the dd/mm/yyyy that he wishes to locate
        for (int i =0; i< myCarPark.length; i++){
            if (myCarPark[i] == (null)){
                continue;
            }
            if (myCarPark[i].getTime().getDay()==(Day) && myCarPark[i].getTime().getMonth()==(Month) && myCarPark[i].getTime().getYear()==(Year)){
                System.out.println(myCarPark[i]);
                Located = 1;
            }
            
            // If the dates entered match any vehicles in the car park it will state it
            
        }
        if (Located == 0){
            System.out.println("ERROR! not found!");
        }
        // If the dates entered does not match, error message will appear
    }
    
 public void run(){
     while(true){
         for (int i = 0; i < myCarPark.length; i++){
             if (myCarPark[i] == null){
                 continue;
             }
             if (myCarPark[i].getCost()/30 == 0){
                 if (myCarPark[i].getCost() < 9){
                     myCarPark[i].setCost(myCarPark[i].getCost()+3);
                 }
                 else{
                     myCarPark[i].setCost(myCarPark [i].getCost()+1);
                 }
                 // This enables the thread to run
             }
             else {
                 if(myCarPark [i].getCost()-30 < 9) {
                     myCarPark [i].setCost(myCarPark [i].getCost()+3);
                 }
                 else {
                     myCarPark[i].setCost(myCarPark[i].getCost()+1);
                 }
             }
         }
         
         // Calculating the thread making it calculate real time
         try {
             Thread.sleep(3600000);
             //every hour
         }
         catch (InterruptedException e) {
             
         }
     }
 }   
    
    
    
    public static void fees() {
        for(int i = 0; i < myCarPark.length; i++) {
            if(myCarPark[i] == null) {
                continue;
            }
            System.out.println("Vechicle ID :" + myCarPark [i].getVehiclePlate() + " has been charged : £" + myCarPark [i].getCost());
            //This will display the charges made on the different vehicles depending on duration
        }
    }
    
public void viewCarPark(){
            for (int i = 0; i < myCarPark.length; i++){
                if (myCarPark[i] == null){
                    continue;
                    
                    
                }
                if (myCarPark[i] != null){
                    System.out.println(myCarPark[i]);
                }
            }
            
            // This will display the vehicles in the car park
        }
public void addvehicle(){
    Scanner in = new Scanner(System.in);
    
    System.out.println("what is your vehicle number plate?");
    String vehicleplate;
    vehicleplate = in.next();
    for (int i = 0; i < myCarPark.length; i++){
        if (myCarPark[i] == null){
            continue;
        }
        if (myCarPark[i].getVehiclePlate().equals(vehicleplate)){
            System.out.println("Error! This vehicle id is already parked, try again");
            addvehicle();
        }
        
        //This makes sure that there cant be two of the same vehicle id
    }
    
    System.out.println("What brand is the vehicle?");
    String Brand;
    Brand = in.next();
    
    // Asks for the brand of the vehicle
    System.out.println("Enter date/time entered");
    System.out.println("Enter day:");
    int Day;
    Day = in.nextInt();
    while (Day <= 0 || Day >= 32) {
    System.out.println("Day can not be less than 1 and more than 32");
    Day = in.nextInt();
    }
    // Validation check to ensure users to enter right day
    System.out.println("Enter month");
    int Month;
    Month = in.nextInt();
    while (Month <=0 || Month >=13) {
    System.out.println("Month can not be less than 1 and more than 12");
    Month = in.nextInt();
    }
    // Validation check to ensure users to enter right month
    System.out.println("Enter year");
    int Year;
    Year = in.nextInt();
    while (Year <=1900 || Year >=2100) {
    System.out.println("Year can not be less than 1900 and more than 2100");
    Year = in.nextInt();
    }
    // Validation check to ensure users to enter right year
    System.out.println("Enter hour");
    int Hour;
    Hour = in.nextInt();
    while (Hour <=-1 || Hour >=25) {
    System.out.println("Hours can not be less than 0 and more than 24");
    Hour = in.nextInt();
    // Validation check to ensure users to enter right hour
    }
    System.out.println("Enter minutes");
    int Minutes;
    Minutes = in.nextInt();
    while (Minutes <=-1 || Minutes >=61) {
    System.out.println("Minutes can not be less than 0 and more than 60");
    Minutes = in.nextInt();
    }
    // Validation check to ensure users to enter right minutes
    DateTime timeentered = new DateTime(Day, Month, Year, Hour, Minutes);
    System.out.println("Is it a: [C]ar, [V]an, or [M]otorcycle?");
    String MyVehicleType;
    MyVehicleType = in.next().toLowerCase();
    int Try = 0;
    while (Try == 0){
        switch(MyVehicleType){
            case "c":
                System.out.println("What color?");
                String color;
                color = in.next();
                // Asks for the color of the car
                System.out.println("How many doors?");
                int doors;
                doors = in.nextInt();
                // Asks for the amount of doors the car has
                Try = 1;
     
                car VehicleCar = new car(vehicleplate, MyVehicleType,timeentered, doors, color);
                for (int i = 0; i<myCarPark.length; i++){
                    if(myCarPark[i] == null){
                        myCarPark[i] = VehicleCar;
                        break;
                    }
                }
                lastaccessedvehicle = VehicleCar;
                break;
            case "v":
                if (isvanfull == 1){
                    System.out.println("The car park is full");
                    return;
                    // If the car park is full error message will appear
                }
                System.out.println("Cargo volume of your van?");
                int Cargo;
                Cargo = in.nextInt();
                Try = 1;
                Van Vehiclevan = new Van(vehicleplate, MyVehicleType,timeentered,Cargo);
                for (int i =0; i<myCarPark.length;i++){
                    if(myCarPark[i] == (null)){
                        myCarPark[i+1] = Vehiclevan;
                        myCarPark[i] = Vehiclevan;
                        break;
                    }
                }
                lastaccessedvehicle = Vehiclevan;
                break;
            case "m":
                System.out.println("What is your engine size?");
                int sizeofengine;
                sizeofengine = in.nextInt();
                // Ask for the engine size
                Try = 1;
                Moterbike Vehiclemotorcycle = new Moterbike(vehicleplate, MyVehicleType, timeentered,sizeofengine);
                for (int i = 0;i<myCarPark.length;i++){
                    if( myCarPark[i] == (null)){
                        myCarPark[i] = Vehiclemotorcycle;
                        break;
                    }
                }
                lastaccessedvehicle = Vehiclemotorcycle;
                break;
            default:
                System.out.println("Error!, please try again");
                MyVehicleType = in.next().toLowerCase();
                    
                // error message
        }
    }
    int Add =0;
    for (int i =0; i<myCarPark.length;i++){
        if(myCarPark[i] == (null)){
            Add = Add + 1;
        }
    }
    if (Add > 0){
        System.out.println("In the car park there is " + Add + " spaces in the car park left");
    }
    sorter();
    //After the vehicle has been entered it will print out the amount of spaces left
    

    
}

public void mystats(){
    double car = 0;
    double van = 0;
    double motorcycle = 0;
    int Count = 0;
    
    
    
    for (int i =0; i<myCarPark.length;i++){
        if (myCarPark[i] == null){
            continue;
        }
        Count = Count + 1;
        
        if (myCarPark[i].getVType().equals("car")){
            car = car + 1;    
            
        }
        if (myCarPark[i].getVType().equals("motorbike")){
            motorcycle = motorcycle + 1;    
        }
        if (myCarPark[i].getVType().equals("van")){
            van = van + 1;    
        }
        
    }
    double cpercentage = ((car/Count)*100);
    System.out.println("");
    double mpercentage = (motorcycle/Count)*100;
    System.out.println("");
    double vpercentage = (van/Count)*100;
    System.out.println("");
    
    // This calculates the different percentages 
    
    System.out.println("--------------------------------");
    System.out.println("Percentages: ");
    System.out.println(" Car" + cpercentage);
    System.out.println("Motorbike " + mpercentage);
    System.out.println("van " + vpercentage);
    System.out.println("--------------------------------");
     // This prints out the different percentages
     
    System.out.println("Last vehicle accessed the parking " + lastaccessedvehicle);
    
    // This prints out the vehicle last accesing the parking
    for (int i = 0; i <myCarPark.length; i++){
            if (myCarPark[i] == null){
                System.out.println("The vehicle that stayed the longest: " + myCarPark[i-1]);
                break;
            }
            if (i == myCarPark.length-1 && myCarPark[i] != null){
                System.out.println("The vehicle that stayed the longest: " + myCarPark[i]);
            }
            
            // This prints out the vehicle that stayed the longest
}
}

public void deletevehicle(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter vehicle id of vehicle you want to delete");
    String deleter;
    deleter = in.next();
    int emptiest = 0;
    for (int i = 0; i < myCarPark.length;i++){
        if (myCarPark[i] == (null)){
            emptiest = 1;
            continue;
        }
        emptiest = 0;
        break;
        
        // User enters the vehicle id for the vehicle they wish to delete
    }
    if (emptiest == 0){
        for (int i = 0; i < myCarPark.length; i++){
            if (myCarPark[i] == (null)){
                continue;
            }
            if (myCarPark[i].getVehiclePlate().equals(deleter)){
            if (myCarPark[i].getVType().equals("car")){
                System.out.println("Date and time: " + myCarPark[i].getTime());
                System.out.println("The 'car' '"+ deleter +"' has been deleted");
                myCarPark[i] = null;
                break;
                // This shows the date and time the car has been deleted
            }
            if(myCarPark[i].getVType().equals("Van")){
                System.out.println("Date and time: " + myCarPark[i].getTime());
                System.out.println("The 'van' '" + deleter + "' has been deleted");
                myCarPark[i] = null;
                myCarPark[i+1] = null;
                break;
                // This shows the date and time the van has been deleted
            }
            if (myCarPark[i].getVType().equals("Motorbike")){
                
                System.out.println("Date and time: " + myCarPark[i].getTime());
                System.out.println("The 'motorbike' '"+deleter +"' has been deleted");
                myCarPark[i] = null;
                break;
                // This shows the date and time the moterbike has been deleted
             
            }

            }
             else{
                System.out.println("no vehicle found with this id. Please check your id");
                break;

   // Using the IF statement it will show if the vehicle id doesnt match with a vehicle in the garage 
            }
        }
    }
    sorter();
    
}





public void calculatecost(){
    for (int l =0; l <myCarPark.length; l++){
        if (myCarPark[l] == (null)){
            continue;
        }
        System.out.println(myCarPark[l].getVehiclePlate() + "= £" + myCarPark[l].getCost());
    }
    // This will retieve the cost and add the £
}


    public static void sorter(){
        for (int i = 0; i < myCarPark.length; i++){       
        for (int x = 0; x < myCarPark.length-1; x++){
            if (myCarPark[x] == null || myCarPark[x+1] == null){
                continue;
                
                //I generated a bubblesort
            }
            if (myCarPark[x].getTime().getYear() < myCarPark[x+1].getTime().getYear()){
                Vehicles Temp = myCarPark[x];
                myCarPark[x] = myCarPark[x+1];
                myCarPark[x+1] = Temp;
            }            
        }
        for (int x = 0; x < myCarPark.length-1; x++){
            if (myCarPark[x] == null || myCarPark[x+1] == null){
                continue;
            }
            if (myCarPark[x].getTime().getYear() == myCarPark[x+1].getTime().getYear()){
                if (myCarPark[x].getTime().getMonth() < myCarPark[x+1].getTime().getMonth()){
                    Vehicles Temp = myCarPark[x];
                    myCarPark[x] = myCarPark[x+1];
                    myCarPark[x+1] = Temp;
                }
            } 
        }
        for (int x = 0; x < myCarPark.length-1; x++){
            if (myCarPark[x] == null || myCarPark[x+1] == null){
                continue;
            }
            if (myCarPark[x].getTime().getYear() == myCarPark[x+1].getTime().getYear()){
                if (myCarPark[x].getTime().getMonth() == myCarPark[x+1].getTime().getMonth()){ 
                    if (myCarPark[x].getTime().getDay() < myCarPark[x+1].getTime().getDay()){
                        Vehicles Temp = myCarPark[x];
                        myCarPark[x] = myCarPark[x+1];
                        myCarPark[x+1] = Temp;
                }
                    }
                
            }                        
        }
        for (int x = 0; x < myCarPark.length-1; x++){
            if (myCarPark[x] == null || myCarPark[x+1] == null){
                continue;
            }
            if (myCarPark[x].getTime().getYear() == myCarPark[x+1].getTime().getYear()){
                if (myCarPark[x].getTime().getMonth() == myCarPark[x+1].getTime().getMonth()){ 
                    if (myCarPark[x].getTime().getDay() == myCarPark[x+1].getTime().getDay()){
                        if (myCarPark[x].getTime().getHours() < myCarPark[x+1].getTime().getHours()){
                            Vehicles Temp = myCarPark[x];
                            myCarPark[x] = myCarPark[x+1];
                            myCarPark[x+1] = Temp;
                }
                    }
                        }                
            } 
        }
        for (int x = 0; x < myCarPark.length-1; x++){
            if (myCarPark[x] == null || myCarPark[x+1] == null){
                continue;
            }
            if (myCarPark[x].getTime().getYear() == myCarPark[x+1].getTime().getYear()){
                if (myCarPark[x].getTime().getMonth() == myCarPark[x+1].getTime().getMonth()){ 
                    if (myCarPark[x].getTime().getDay() == myCarPark[x+1].getTime().getDay()){
                        if (myCarPark[x].getTime().getHours() == myCarPark[x+1].getTime().getHours()){
                            if (myCarPark[x].getTime().getMinutes() < myCarPark[x+1].getTime().getMinutes()){
                                Vehicles Temp = myCarPark[x];
                                myCarPark[x] = myCarPark[x+1];
                                myCarPark[x+1] = Temp;
            }                         
                            
 //This will sort from first entered till last entered vehicle
                }
                    }
                        }                
            }
    }
    }
    }





    
}
