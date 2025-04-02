package com.ivoyant.CRUDinRESTAPI.repository;

import com.ivoyant.CRUDinRESTAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //using named parameters as placeholders
    //@parameter() binds successive parameters with named parameter specified inside it
    @Transactional
    @Modifying
    @Query("update Employee set lastName = :lastname  where id=:id")
    void updateLastNameById(@Param("id") int id, @Param("lastname") String lastname);
    //using placeholders ot receive value from service layer
    //?1 replaces placeholder by 1st parameter of method
    @Transactional
    @Modifying
    @Query("update Employee set firstName = ?2  where id=?1")
    void updateFirstNameById(int id,String firstName);
    //?2 says to spring boot that map the 2nd parameter accepted by below method here

}
