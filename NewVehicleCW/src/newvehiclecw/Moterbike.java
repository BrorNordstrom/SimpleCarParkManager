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
public class Moterbike extends Vehicles{
     // It extends from vehicle as car is the subclass of Vehicle
    
    private int sizeofengine;
    
    
    public Moterbike(String p, String b , DateTime t, int e){
        super(p,b,t);
        sizeofengine = e;
        
    }
    public void setEngineSize(int e){
        sizeofengine = e;
    }
    public int EngineSize(){
        return sizeofengine;
    }
    
    public String getVType(){
        return "Motorbike";
    }
    
    public String toString(){
        return "Motorbike: " +"VehiclePlate: " +this.getVehiclePlate() + " entry: " + this.getTime() + ". Size of engine:" + sizeofengine; 
    }
    // It will retrieve the vehicleplate, entrytime and size of the engine
    public String getVehicleDetails(){
        return "VehiclePlate: " +this.getVehiclePlate() + " has been deleted.";
    }
    // It will retrieve the vehicleplate and state its been deleted
}
