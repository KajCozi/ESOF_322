
package hw_2_esof;

//Imports
import java.util.Scanner;

    
public class HW_2_ESOF 
{
    
    static Scanner myScan = new Scanner(System.in);
    
    abstract class storeStrat
    {
        public void store(){
            System.out.println("This is the default storing strategy. \n");
        }
    }
    
    class Relationable extends storeStrat
    {
        public void store(){
            System.out.println("This is the Relationable storing strategy. \n");
        }
    }
    
    class NoSQL extends storeStrat
    {
        public void store()
        {
            System.out.println("This is the NoSQL storing strategy. \n");
        }
    }
    
    class Graph extends storeStrat
    {
        public void store()
        {
            System.out.println("This is the Graph storing strategy. \n");
        }
    }
        
    public static void main(String[] args) {
        String quit = "n";
        try{
        while(quit.equals("n")){
            int choice = 0;
            System.out.println("Please choose one of the three store behaviors. ");
            System.out.println("\nPress 1 for Relationable. ");
            System.out.println("\nPress 2 for NoSQL. ");
            System.out.println("\nPress 3 for Graph. ");
        
            choice = Integer.parseInt(myScan.nextLine());
        
        switch(choice){
            case 1:
                //relationable = new Relationable();
                break;
            case 2: 
                //noSql();
                //Strategy = new Strategy();
                break;
            case 3:
                //graph();
                //Strategy = new Strategy();
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
