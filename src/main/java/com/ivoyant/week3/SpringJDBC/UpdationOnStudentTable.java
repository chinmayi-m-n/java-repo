package com.ivoyant.week3.SpringJDBC;

import com.ivoyant.week3.SpringJDBC.config.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdationOnStudentTable {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate template=context.getBean(JdbcTemplate.class);
        //using this template reference we can do updation of tuples through update() method provided by it
        String sql="update student set std_marks=? where std_roll=?";
        String roll="100";
        double marks=50;
        //update() return integer indicates number of rows updated
        int count=template.update(sql,marks,roll);
        if(count>0) System.out.println("updation successful");
        else System.out.println("updation failed");
    }
}
