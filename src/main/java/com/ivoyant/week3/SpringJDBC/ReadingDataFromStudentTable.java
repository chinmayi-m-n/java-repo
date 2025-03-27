package com.ivoyant.week3.SpringJDBC;

import com.ivoyant.week3.SpringJDBC.config.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;

public class ReadingDataFromStudentTable {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate template=context.getBean(JdbcTemplate.class);
        String sql="select * from student where std_marks > ?";
        double marks=50;
        //using query() method for executing select which returns list of student objects
        List<Student> lst=template.query(sql,new StudentRowMapper(),marks);
        for(Student s:lst)System.out.println(s);
        //using queryForList which returns list of hashmap where each row of resultset is stored in the form of hashmap inside list
        List<Map<String,Object>> lstMap=template.queryForList(sql,marks);
        for(Map map:lstMap) System.out.println(map);
    }
}
