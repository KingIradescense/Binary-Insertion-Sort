import java.awt.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import static java.lang.String.valueOf;

public class Student{
    public Student(int ID, int age, String name, double GPA){
        this.ID = ID;
        this.age = age;
        this.name = name;
        this.GPA = GPA;
    }
    public Student(){
        this.ID = 0;
        this.age = 0;
        this.name = "";
        this.GPA = 0.0;
    }

    public int getID(){
        return ID;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public double getGPA(){
        return GPA;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }


    private int ID;
    private int age;
    private String name;
    private double GPA;
}
