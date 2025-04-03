package com.ivoyant.week2.file_handling;

import java.io.File;
import java.io.IOException;

public class FileAPI {
    public static void main(String[] args) throws IOException {
        File f1=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\p1\\p1.txt");
        File f2=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\p2\\p3.txt");
        if(!f2.exists())f2.createNewFile();//create new file if file in the path of instance doesnot exists
        File dir=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\directory");

        if(!dir.exists()){
            dir.mkdir();//create new directory if directory in the path of dir instance doesnot exists
        }
        File dir1=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\p2");
        //list all files inside dir1(inside p1 folder)
        //create a directory inside p2 folder
        File dir2=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\p2\\newDirectory");
        dir2.mkdir();
        String[] list=dir1.list();
        for(String s:list) {
            //prints files and directory names inside dir1 instance path
            //currently we have child as a string and file object of parent
            //using this create file instance for child
            File child=new File(dir1,s);
            if(child.isFile()) System.out.println("file: "+s);
            else if(child.isDirectory()) System.out.println("directory: "+s);
        }
    }
}
