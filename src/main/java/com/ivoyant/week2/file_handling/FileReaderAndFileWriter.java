package com.ivoyant.week2.file_handling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class FileReaderAndFileWriter {
    public static void main(String[] args) throws Exception{
        File file=new File("C:\\Users\\Chinmayi.M.N\\Desktop\\p1\\p1.txt");
        //getting parent directory path using file instance
        //creating file instance using parent directory path and child file name as string(which is not present)
        File txtFile=new File(file.getParent(),"txtFile");
        //creating new textfile
        txtFile.createNewFile();
        //creating writer object for newly created empty text file
        FileWriter out=new FileWriter(txtFile);
        //creating FileReader object for source file
        FileReader reader=new FileReader(file, StandardCharsets.UTF_8);
        int charRead=0;
        while((charRead=reader.read())!=-1){
            //reading a character from file printing it and writing that char to empty text file
            System.out.print((char)charRead);
            out.write(charRead);
        }
        reader.close();
        out.close();

    }
}
