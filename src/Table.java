/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gul Zain
 */
public class Table {
    
    public Integer capacity;
    public Boolean bookStatus;
    public String timeSlot;
    
    public Table(Integer capacity, Boolean bookStatus){
        this.capacity=capacity;
        this.bookStatus=bookStatus;
        timeSlot="";
    }
    
    public Table(Integer capactity, Boolean bookStatus, String timeSlot){
        this.capacity=capacity;
        this.bookStatus=bookStatus;
        this.timeSlot=timeSlot;
    }
    
}
