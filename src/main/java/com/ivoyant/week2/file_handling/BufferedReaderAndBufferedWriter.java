package com.ivoyant.week2.file_handling;

import java.io.*;


public class BufferedReaderAndBufferedWriter {
    public static void main(String[] args) throws Exception{
        File file1=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\p1\\p1.txt");
        File file2=new File(file1.getParent(),"outputFile");
        file2.createNewFile();
        BufferedReader reader=new BufferedReader(new FileReader(file1));
        BufferedWriter writer=new BufferedWriter(new FileWriter(file2));
        int charRead=0;
        while((charRead=reader.read())!=-1){
            writer.write(charRead);
        }
        reader.close();
        writer.close();


    }
}
