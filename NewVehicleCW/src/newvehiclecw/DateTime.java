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
public class DateTime {
    private int hours;
    private int minutes;
    private int day;
    private int month;
    private int year;
    
        public DateTime(int d,int w,int z,int h,int m){
            //This is in the order of dd/mm/yyyy, hh:mm
        hours = h;
        minutes = m;
        day = d;
        month = w;
        year = z;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int d) {
        this.day = d;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int w) {
        month = w;       
    }   
    public int getYear() {
        return year;
    }
    public void setYear(int z) {
        year = z;       
    }
        public int getHours() {
        return hours;
    }
    public void setHours(int h) {
        this.hours = h;
    }

    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int m) {
        this.minutes = m;
    }
    public String toString(){
        return "Date entered: " + day + ":" + month + ":" + year + " Time Entered: " + hours + ":" + minutes;
    }
     // It will retieve the date, in the format, dd/mm/yy, hh:mm
    
}

        