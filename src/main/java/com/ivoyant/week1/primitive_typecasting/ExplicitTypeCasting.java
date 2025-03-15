package com.ivoyant.week1.primitive_typecasting;

public class ExplicitTypeCasting {
    public static void main(String[] args) {
        //explicit typecasting is to be made explicitly when u try to store larger datatype value to smaller datatype
        //trying to put bucket of water to cup causes dataloss compiler won't do this we have to force compiler to do this
        int i=128;
        byte b;
        //b=i; creates compile time error due to dataloss
        b=(byte)i;//explicitly typecasting int to byte
        System.out.println(b);
        //value printed according to cyclic property
    }
}
