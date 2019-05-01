/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NikkiNguyen
 */
public abstract class Student {
    private String firstName;
    private String major;
    private int units;

    public Student(String firstName, String major, int units){
        this.firstName = firstName;
        this.major = major;
        this.units = units;
    }

    @Override
    public String toString(){
        return("Name: " + firstName + "\nMajor: " + major + "\nUnits: " + units);
    }

    abstract public int calculateTuition(int units);
}
