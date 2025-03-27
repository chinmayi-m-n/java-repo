package com.ivoyant.week3.SpringJDBC;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student>{
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student st=new Student();
        st.setRollno(rs.getInt("std_roll"));
        st.setName(rs.getString("std_name"));
        st.setMarks(rs.getDouble("std_marks"));
        return st;
    }
}
