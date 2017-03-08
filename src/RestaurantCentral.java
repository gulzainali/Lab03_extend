/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gul Zain
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.*;
public class RestaurantCentral {
    
    public void start(int numberOfPeople, int hours, int presentHour){
        //checking priority queue
       
        /*
1.	1 extra-large table with max capacity of 12 people.
2.	3 large tables with max capacity of 6 people.
3.	8 medium tables with max capacity of 4 people.
4.	4 small tables with max capacity of 2 people.

        */
        Integer[][] tables= new Integer[11][16];
        for(int i = 0 ; i < 11 ; i++){
            for(int j= 0 ; j< 16; j++){
                tables[i][j]=1;
            }
        }
        
        //finding available tables
        if(presentHour+hours> 22){
         return;
        }
        ArrayList<Integer> listTables= new ArrayList<Integer>();
        for(int i = presentHour; i< (presentHour+hours);i++){
           for(int j = 0 ; j < 16; j++){
               if(j==0 && tables[i][j]==1){
                   listTables.add(12);
               }
               else if(j>0 && j< 4 && tables[i][j]==1){
                   listTables.add(6);
               }
               else if(j>3 &&  j<12 && tables[i][j]==1){
                   listTables.add(4);
               }
               else if(j>11 && j< 16 && tables[i][j]==1 ){
                   listTables.add(2);
               }
           }
        }
        int[] availableTables= new int[listTables.size()];
        for(int i = 0 ; i < listTables.size();i++){
            availableTables[i]=listTables.get(i);
        }
        int[][] sorted=dynamic(availableTables,numberOfPeople);
        System.out.println(sorted);
        
        
        
        
        
        
        
       /* TableComparator comparator= new TableComparator();
        ArrayList<String> timeSlots= new ArrayList<String>();
        Queue<Table> queue = new PriorityQueue<>(16, comparator);
        createQueue(queue);*/
        /*queue.add(1);
        queue.add(2);
        queue.add(7);
        queue.add(4);
        queue.add(5);
        queue.add(200);
        queue.add(199);
        while(true){
            Integer i= queue.poll();
            if(i==null) break;
            System.out.print(i + " ");
        }*/
        
        
        
    }
    
    private void createQueue(Queue queue){
         queue.add(new Table(12,false));
        for(int i = 0 ; i < 3 ; i++){
            queue.add(new Table(6,false));
            
        }
        for(int i = 0 ; i < 8 ; i ++){
            queue.add(new Table(4,false));
           
        }
        for(int i = 0; i < 4; i++){
            queue.add(new Table(2,false));
        }
    }
    private void addTimeSlots(ArrayList<String> list){
        list.add("11:00 am-12:00 pm");
        list.add("12:00 am - 1:00 pm");
        list.add("1:00 pm - 2:00 pm");
        list.add("2:00 pm - 3:00 pm");
        list.add("3:00 pm - 4:00 pm  ");
        list.add("4:00 pm - 5:00 pm ");
        list.add("5:00 pm - 6:00 pm ");
        list.add("6:00 pm - 7:00 pm ");
        list.add("7:00 pm - 8:00 pm ");
        list.add("8:00 pm - 9:00 pm ");
        list.add("9:00 pm - 10:00 pm ");
        
    }
    
    
    
    public static int[][] dynamic(int[] v, int amount) {
		int[][] solution = new int[v.length + 1][amount + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= v.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			solution[0][i] = 0;
		}

		// now fill rest of the matrix.

		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= amount; j++) {
				// check if the coin value is less than the amount needed
				if (v[i - 1] <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					solution[i][j] = solution[i - 1][j]
							+ solution[i][j - v[i - 1]];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		return solution[v.length][amount];
	}
   
}

