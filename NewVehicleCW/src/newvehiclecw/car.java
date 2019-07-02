/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newvehiclecw;
/**
 *
 * @author Andreas Nordstrom
 */
public class car extends Vehicles {
    // It extends from vehicle as car is the subclass of Vehicle
    
    private int Doors;
    private String color;
    
    public car(String p, String b , DateTime t, int d, String c){
        super(p,b,t);
        Doors = d;
        color = c;
    }
    public void setdoors(int n){
        Doors = n;
    }
    public int getdoors(){
        return Doors;
    }
    public void setcolor(String c){
        color = c;
    }
    public String getcolor(){
        return color;
    }
    public String getVType(){
        return "car";
    }
    public String toString(){
        return "Car: "+ "VehiclePlate: " +this.getVehiclePlate() + " entry: " + this.getTime() + ". " + Doors + "." + color;
    }
    // It will retrieve the vehicleplate, entrytime, amount of doors and the color of the car
    
    public String getVehicleDetails(){
        return "VehiclePlate: " +this.getVehiclePlate() + " has been deleted.";
    }
    
    // It will retrieve the vehicleplate and state its been deleted
       
}
