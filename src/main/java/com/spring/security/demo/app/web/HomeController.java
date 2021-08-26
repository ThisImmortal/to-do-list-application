package com.spring.security.demo.app.web;

import com.spring.security.demo.app.model.PlanToDo;
import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.model.UserPrincipal;
import com.spring.security.demo.app.service.PlanService;
import com.spring.security.demo.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("email")
public class HomeController {

    @Autowired
    private PlanService planService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String uploadUserInfoAfterLoginProcess(@AuthenticationPrincipal UserPrincipal principal, ModelMap modelMap){

        List<PlanToDo> toDoList = new ArrayList<>();

        String email = principal.getUsername();
        String firstName = principal.getFirstName();

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principal instanceof UserDetails){
//            email = ((UserDetails) principal).getUsername();
//            modelMap.put("email", email);
//        }

        User user = userService.getUserByEmail(email);

        toDoList = planService.fetchUserPlans(user.getId());
        modelMap.put("todolist", toDoList);
        modelMap.put("firstName", firstName);
        return "to-do-list";

    }
}
