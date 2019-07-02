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
public class Van extends Vehicles{
    // It extends from vehicle as its the subclass of Vehicle
    private int cargo;
    
    
    
    public Van(String p, String b , DateTime t, int c){
        super (p,b,t);
        cargo  = c;
        
    }
    public void setCargo(int c){
        cargo = c;
    }
    public int getCargo(){
        return cargo;
    }
    
    public String getVType(){
        return "Van";
    }
    public String toString(){
        return "Van: " + "VehiclePlate: " +this.getVehiclePlate() + " entry: " + this.getTime() + ". Cargo:" + cargo; 
    }
    // It will retrieve the vehicleplate, entrytime and cargo for van
    
    public String getVehicleDetails(){
        return "VehiclePlate: " +this.getVehiclePlate() + " has been deleted.";
    }
    // It will retrieve the vehicleplate and state its been deleted
}
