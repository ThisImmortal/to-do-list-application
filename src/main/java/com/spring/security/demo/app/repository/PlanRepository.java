package com.spring.security.demo.app.repository;

import com.spring.security.demo.app.model.PlanToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlanRepository extends JpaRepository<PlanToDo, Integer> {

//    @Query("SELECT '*' FROM PlanToDo p WHERE p.user.username = :username")
public List<PlanToDo> findByUser_Id(long id);


}
