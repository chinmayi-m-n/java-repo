package com.ivoyant.week1.custom_sorting;
import java.util.*;
public class ComparatorInterface {
    public static void main(String[] args) {
        //custom sorting logic can be applied on primitive types(wrapper objects) only through Comparator
        //because their compareTo method is final and can't be overrided
        //sorting numbers according to their last digit
        ArrayList<Integer> al=new ArrayList<>(List.of(100,21,32,13,5,44));
        System.out.println(al);
        Comparator<Integer> com=new Comparator<Integer>(){
            //overriding compare() using anonymous inner class
            public int compare(Integer i,Integer j){
                if(i%10 > j%10){
                    //first number is greater
                    return 1;
                }
                else if(i%10 < j%10){
                    //first number is less than second number
                    return -1;
                }
                else return 0;//both the numbers are equal
            }
        };
        Collections.sort(al,com);//sorts numbers according to their last digit
        System.out.println(al);
    }
}
