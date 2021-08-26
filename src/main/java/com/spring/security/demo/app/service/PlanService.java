package com.spring.security.demo.app.service;

import com.spring.security.demo.app.model.PlanToDo;
import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;


    public List<PlanToDo> fetchUserPlans(long id){

        return planRepository.findByUser_Id(id);
    }


    public void savePlan(PlanToDo planToDo){
        planRepository.save(planToDo);
    }

    public PlanToDo getPlanById(int id){
        return planRepository.getById(id);
    }

    public void deletePlan(int id){
        planRepository.deleteById(id);
    }




}
