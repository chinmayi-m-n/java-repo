package com.ivoyant.week1.custom_sorting;
import java.util.*;
class Student implements Comparable<Student>{
    String name;
    int marks;
    public Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
    //override compareTo() method and specify custom sorting logic
    public int compareTo(Student other){
        if(this.marks<other.marks){
            //current student object is less than other student object
            return -1;
        }
        else if(this.marks==other.marks){
            //both student objects are equal
            return 0;
        }
        else{
            //current student marks is greater than other student marks
            return 1;
        }
    }
}
public class ComparableInterface {
    public static void print(ArrayList<Student> al){
        for(Student st:al){
            System.out.print(st.name+":"+st.marks+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //custom sorting using Comparable interface can only be done on objects of class that implements Comparable interface
        //sorting student objects according to their marks
        ArrayList<Student> al=new ArrayList<>();
        al.add(new Student("harish",10));
        al.add(new Student("harsh",100));
        al.add(new Student("amrutha",50));
        al.add(new Student("asha",40));
        al.add(new Student("ganesh",29));
        print(al);
        Collections.sort(al);//now Student objects in al gets sorted according to logic specified inside compareTo()
        print(al);
    }
}
