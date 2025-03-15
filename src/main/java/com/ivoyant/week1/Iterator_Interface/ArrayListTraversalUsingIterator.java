package com.ivoyant.week1.Iterator_Interface;
import java.util.*;
public class ArrayListTraversalUsingIterator {
    public static void main(String[] args) {
        //creating arraylist along with values initialized
        ArrayList<String> al = new ArrayList<>(List.of("Apple", "Onion", "Tomato"));
        //Iterator interface provides methods like next() hasNext() remove() helps in traversing and deleting elements in collection
        //Iterable interface declares iterator() method
        //every collection class which implement Iterable interface has defined iterator() method for creating object of Itr class(implementaion class for Iterator interface) private inner class present inside every collection class
        //iterator() method is responsible for creating object of Itr(implementation class for Iterator interface) and returns it
        //using Iterator object we can access next() hasNext() and remove()

        Iterator<String> itr = al.iterator();//creating object of Itr
        //removing element while traversing though colections
        while (itr.hasNext()) {
            //next() gives current element hasNext() checks if element exists next to current element
            if(itr.next().equals("Onion"))itr.remove();//removes the current object if it is a Onion
        }
        System.out.println(al);
    }



}
