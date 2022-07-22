
package edu.albany.datastructures.assignment2;

public class Person {
    
    private String first;
    private String last;
    private String st_address;
    private String state;
    private int zip;
    private String telephone;
    
    // Person Constructor that initializes a Person with all the inputed variables
    Person(String f, String l, String s_a, String s, int z, String t){
        this.first = f;
        this.last = l;
        this.st_address = s_a;
        this.state = s;
        this.zip = z;
        this.telephone = t;
    }
    // toString method that will print a Person in the specified format
    public String toString(){
        return ("\n-------------------------------\n"
                +first +" "+last+"\n"
                +st_address+"\n"+state+", "+zip+"\n"
                +telephone);
    }
    // Getters for Person
    public String getFirst(){
        return first;
    }
    public String getLast(){
        return last;
    }
    public String getStreetAddress(){
        return st_address;
    }
    public String getState(){
        return state;
    }
    public int getZip(){
        return zip;
    }
    public String getTelephone(){
        return telephone;
    }
    
    // Setters for Person
    public void setFirst(String f){
        this.first = f;
    }
    public void setLast(String l){
        this.last = l;
    }
    public void setStreetAddress(String sa){
        this.st_address = sa;
    }
    public void setState(String s){
        this.state = s;
    }
    public void setZip(int z){
        this.zip = z;
    }
    public void setTelephone(String t){
        this.telephone = t;
    }
}
