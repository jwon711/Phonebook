/* Data Structures 231 - Programming Assignment 2 
   Name: Jason Wong
*/
package edu.albany.datastructures.assignment2;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Menu{
    boolean exit;
    
    // Declares an Arraylist of type Person
    ArrayList<Person> People = new ArrayList<Person>();
    
    public static void main(String[] args){
    
    // Declares a menu of type Menu
        Menu menu = new Menu();
    // Calls the menu function to run the Menu method
        menu.startMenu();
        
    }
    // Method that displays to the User the menu selections
    private void displayMenu(){
        System.out.println("Please make a selection: ");
        System.out.println("1) Add a Person");
        System.out.println("2) Remove a Person");
        System.out.println("3) Modify a Person");
        System.out.println("4) Print one Person");
        System.out.println("5) Print all People");
        System.out.println("6) Write all elements to text file");
        System.out.println("7) EXIT");
    }
    // Method that allows the User to enter their desired selection from the menu
    private int getUserInput(){
        Scanner scnr = new Scanner(System.in);
        int userInput = -1;
        while(userInput < 0){
            System.out.print("Enter your choice:\n");
            // Turns the User's string input and converts it to an integer
            userInput = Integer.parseInt(scnr.nextLine());
        }
        return userInput;
    }
    // Method that will detect the User's input and call the corresponding method
    private void detectInput(int userInput){
        
        if(userInput == 1){
            addPerson(People);
        }
        else if(userInput == 2){
            deletePerson(People);
        }
        else if(userInput == 3){
            modifyPerson(People);
        }
        else if(userInput == 4){
            displayOnePerson();
        }
        else if(userInput == 5){
            displayAllPeople();
        }
        else if(userInput == 6){
            writeAllToFile(People);
        }
        else if(userInput == 7){
            System.out.println("Program has exited.");
            System.exit(0);
        }
    }
    // Puts the displayMenu, getUserInput, and detectInput methods in a while loop so it can continously let the User edit the arraylist
    public void startMenu(){
        while(!exit){
            displayMenu();
            int userInput = getUserInput();
            detectInput(userInput);
        }
    }
    // When called, it prompts the User to enter information for a Person 
    private void addPerson(ArrayList<Person> People){
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter First Name: ");
        String f = scnr.nextLine();
        
        System.out.println("Enter Last Name: ");
        String l = scnr.nextLine();
        
        System.out.println("Enter Street Address: ");
        String sa = scnr.nextLine();
        
        System.out.println("Enter State: ");
        String s = scnr.nextLine();
        
        System.out.println("Enter Zip: ");
        int z = scnr.nextInt();
        
        System.out.println("Enter Telephone: ");
        String t = scnr.next();
     
      // After the User enters the information, it calls the Person Constructor and creates a new Person. 
        People.add(new Person(f, l, sa, s, z, t));
        
    }
    // When called, it prompts the User to enter an existing Person's first and last name
    private void deletePerson(ArrayList<Person> People){
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter First Name: ");
        String f = scnr.nextLine();
        
        System.out.println("Enter Last Name: ");
        String l = scnr.next();
        
        // If the Person's first and last name match with a Person in the Arraylist, it will remove that Person from the Arraylist
        for(int i=0; i<People.size(); i++){
            if(People.get(i).getFirst().equals(f) && People.get(i).getLast().equals(l)){
                People.remove(i);
            }
        }
    }
    // When called, it prompts the User to enter an existing Person's telephone number
    private void modifyPerson(ArrayList<Person> People){
        boolean NumberFound = false;
        Scanner scnr = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Enter Specific Person's Number: ");
        String t = scnr.next();
        
        // Goes through the Arraylist to check if the first and last name match with a Person in the Arraylist
        for(int i=0; i<People.size(); i++){
            if(People.get(i).getTelephone().equals(t)){
                NumberFound = true;
            }
        }
        // if the number doesn't match a Person's number in the Arraylist, it displays error message
        if(NumberFound == false){
            System.out.println("----------------------");
            System.out.println("ERROR: INVALID PERSON!");
            System.out.println("----------------------");
        }
 // If the telephone number matches with a Person's number in the Arraylist, it will prompt the User to select what to modify
        if(NumberFound == true){
        for(int i=0; i<People.size(); i++){
            if(People.get(i).getTelephone().equals(t)){
                System.out.println("Please make a selection for modification:\n"
                                    +"1) first\n2) last\n3) address\n4) state\n5) zip\n6) telephone");
                // Gets the User Input by calling the getUserInput method 
                int mod = getUserInput();
                
                // Depending on the User's input, it will prompt the User to then enter the new information and call the setter to replace the old information
                if(mod == 1){
                    System.out.println("Enter New First Name: ");
                    String f = scnr.next();
                    People.get(i).setFirst(f);
                }
                else if(mod == 2){
                    System.out.println("Enter New Last Name: ");
                    String l = scnr.next();
                    People.get(i).setLast(l);
                }
                else if(mod == 3){
                    System.out.println("Enter New Street Address: ");
                    String sa = scnr.next();
                    People.get(i).setStreetAddress(sa);
                }
                else if(mod == 4){
                    System.out.println("Enter New State: ");
                    String s = scnr.next();
                    People.get(i).setState(s);
                }
                else if(mod == 5){
                    System.out.println("Enter New Zip: ");
                    int z = scnr.nextInt();
                    People.get(i).setZip(z);
                }
                else if(mod == 6){
                    System.out.println("Enter New Telephone Number: ");
                    String ta = scnr.next();
                    People.get(i).setTelephone(ta);
                }
            }
        }  
     }
  }
    // When called, it will prompt the User to enter an existing Person's first and last name
    private void displayOnePerson(){
       boolean PersonFound = false;
       Scanner scnr = new Scanner(System.in);
       
       System.out.println("Enter Person's First Name: ");
       String f = scnr.nextLine();
       
       System.out.println("Enter Person's Last Name: ");
       String l = scnr.next();
       // Goes through the Arraylist to check if the first and last name match with a Person in the Arraylist
       for(int i=0; i<People.size(); i++){
           if(People.get(i).getFirst().equals(f) && People.get(i).getLast().equals(l)){
               PersonFound = true;
           }
       }
       // If the name doesn't match with a Person in the Arraylist, it displays error message
        if(PersonFound == false){
               System.out.println("----------------------");
               System.out.println("ERROR: INVALID PERSON!");
               System.out.println("----------------------");
           }
        // If the name does match with a Person in the Arraylist,
       if(PersonFound == true){
       for(int i=0; i<People.size(); i++){
           if(People.get(i).getFirst().equals(f) && People.get(i).getLast().equals(l)){
               System.out.println(People.get(i));
          }
       }
    }
}
    // When called, it will write the entire Arraylist of type Person objects into the specified text file
    private void writeAllToFile(ArrayList<Person> People){
        try{
        FileOutputStream fos = new FileOutputStream("addresses.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        // Writes the Arraylist of Person objects in the format of the toString
        oos.writeObject(People.toString());
        oos.close();
        }
        catch(Exception e){
            System.out.println("ERROR: COULD NOT WRITE TO FILE!");
        }
    }
    // When called, it will display the entire Arraylist of type Person objects using the toString method
    private void displayAllPeople(){
       for(int i=0; i<People.size(); i++){
           System.out.println(People.get(i));
       }
   }
}
