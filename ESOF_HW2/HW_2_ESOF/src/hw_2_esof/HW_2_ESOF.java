/*
    Logan Dolechek
    Kajia Coziahr
*/
package hw_2_esof;

//Imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//abstract class storeStrat has store() that is overriden by other classes store
//functions. 
abstract class StoreStrat
    {
        public void store()
        {
            //this is the default store strategy. 
            //Never prints anything at run time until it is overrided.   
        }
        
        //create the file here and write to file. This changes depending on what is being called upon by the user.
        public void writeToFile(String line) throws IOException
        {
            String x = "";
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Enter data");
            x = scan.nextLine();
            
            FileWriter writer = new FileWriter("Temp_Store.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write(x);
            bufferedWriter.newLine();
            bufferedWriter.close();
           
        }
        
    }
    //The following three classes are extending our abstract class. 
    //Allowing the program to override the default store() in stratStore
    class Relationable extends StoreStrat
    {
        @Override
        public void store()
        {            
            System.out.println("\nYou are now in Relationable. Your information has been stored using table store. \n");  
        }
    }
    
    class NoSQL extends StoreStrat
    {
        @Override
        public void store()
        {
            System.out.println("\nYou are now in NoSQL. Your information has been stored using document store. \n");
        }
    }
    
    class Graph extends StoreStrat
    {
        @Override
        public void store()
        {
            System.out.println("\nYou are now in Graph. Your information has been stored using document store. \n");
        }
    }

public class HW_2_ESOF 
{
    //Global scanner for user input.
    static Scanner myScan = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        String quit = "n"; // variable for while loop. Allows user to continue or to close program.
        StoreStrat strategy;
        
       
        try{
        while(quit.equals("n")){
            int choice = 0;
            System.out.println("\tMENU");
            System.out.println("Please choose one of the three store behaviors. ");
            System.out.println("\nPress 1 for Relationable. ");
            System.out.println("\nPress 2 for NoSQL. ");
            System.out.println("\nPress 3 for Graph. ");
        
            choice = Integer.parseInt(myScan.nextLine());
        //switch menu allows user at runtime to swap between all three methods.
        //setting the store methods depending on what user picks.
        switch(choice){
            case 1:
                    strategy = new Relationable();
                    strategy.store();
                try
                {
                    strategy.writeToFile("Succesfully using Relationable storing method. "); 
                }
                catch(IOException io)
                {
                    System.out.println(io.getMessage());
                }
                break;
            case 2: 
                strategy = new NoSQL();
                strategy.store();
                try
                {
                    strategy.writeToFile("Succesfully using NoSQL storing method. "); 
                }
                catch(IOException io)
                {
                    System.out.println(io.getMessage());
                }
                break;
            case 3:
                strategy = new Graph();
                strategy.store();
                try
                {
                    strategy.writeToFile("Succesfully using Graph storing method. "); 
                }
                catch(IOException io)
                {
                    System.out.println(io.getMessage());
                }
                break;
            default:
                System.out.println("Invalid input - try again");
                break;
        
        }
            System.out.println("Would you like to quit? y/n");
            quit = myScan.nextLine().toLowerCase();
            
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
