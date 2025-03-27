package com.ivoyant.week3.SpringJDBC;

import com.ivoyant.week3.SpringJDBC.config.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertIntoStudent {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate template=context.getBean(JdbcTemplate.class);
        //using this template reference we can do insertion through update()m method provided by it
        String sql="insert into student (std_roll,std_name,std_marks) values(?,?,?)";
        String roll="100";
        String name="ananya";
        double marks=70;
        //update() return integer indicates number of rows updated
        int count=template.update(sql,roll,name,marks);
        if(count>0) System.out.println("insertion successful");
        else System.out.println("insertion failed");
         roll="101";
         name="amrutha";
         marks=100;
         count=template.update(sql,roll,name,marks);
        if(count>0) System.out.println("insertion successful");
        else System.out.println("insertion failed");
         roll="102";
         name="asha";
         marks=60;
         count=template.update(sql,roll,name,marks);
        if(count>0) System.out.println("insertion successful");
        else System.out.println("insertion failed");
    }
}
