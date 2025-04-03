package com.ivoyant.week2.file_handling;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputStreamAndFileOutputStream {
    public static void main(String[] args) throws Exception{
        //Reading and writing Files byte by byte using ByteStream classes
        FileInputStream in=new FileInputStream("C:\\Users\\Chinmayi.M.N\\Desktop\\p1\\p1.txt");
        FileOutputStream out=new FileOutputStream("C:\\Users\\Chinmayi.M.N\\Desktop\\p1\\newFile.txt");
        //creating output stream for empty file to which data is to be written
        int byteRead=0;
        while((byteRead=in.read())!=-1){
            //until their is byte in file keep on reading
            //every character is associated with ascii value
            //every character is stored in memory according to character encoding(UNICODE)
            //read() fetches the byte pointed by offset and returns it as integer
            System.out.print((char)byteRead);//character equivalent of fetched byte is printed here
            out.write(byteRead);//writing the byte that is read from input file using input stream
        }
        in.close();
        out.close();
    }
}
