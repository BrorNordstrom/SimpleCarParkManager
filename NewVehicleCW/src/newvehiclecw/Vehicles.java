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
public class Vehicles {  
    private int Cost = 3;
    
    private String brand;
    
    private String vehicleplate;
    
    private DateTime timeentered;
    
    
    
    public Vehicles(String p, String b ,DateTime t){
        timeentered = t;
        
        vehicleplate = p;
        
        brand = b;
    }
    
     public String getVehiclePlate(){
        return vehicleplate;
    }   
    public void setVehiclePlate(String p){
        vehicleplate = p;
    }
    
    public String getBrand(){
        return brand;
    }  

    public void setBrand(String bn){
        brand = bn;
    }

    public String getVType(){
        return null;
    }
    public String getVehicleDetails(){
        return null;
    }
    
    public void setTime(DateTime t){
        timeentered = t;
    }
    public DateTime getTime(){
        return timeentered;
    }
    
    public void setCost(int Cost) {
        this.Cost = Cost;
    }  
    public int getCost() {
        return Cost;
    } 
}
