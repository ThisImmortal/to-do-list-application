package com.spring.security.demo.app.web;

import com.spring.security.demo.app.model.PlanToDo;
import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.model.UserPrincipal;
import com.spring.security.demo.app.service.PlanService;
import com.spring.security.demo.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder initBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        initBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddForm(ModelMap modelMap){

        PlanToDo planToDo = new PlanToDo();
        modelMap.addAttribute("planToDo", planToDo);
        return "to-do";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addPlan(@AuthenticationPrincipal UserPrincipal principal, @ModelAttribute("planToDo") @Valid PlanToDo planToDo, BindingResult result,
                          ModelMap modelMap){

        if(result.hasErrors()){
            return "to-do";
        }

        User user = userService.getUserByEmail(principal.getUsername());
        planToDo.setUser(user);
        planService.savePlan(planToDo);


        return "redirect:/";

    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateForm(@RequestParam("id") int id, ModelMap modelMap){

        PlanToDo planToDo = planService.getPlanById(id);
        modelMap.put("planToDo", planToDo);

        return "to-do";
    }

//    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
//    public String updatePlan(@ModelAttribute("planToDo") @Valid PlanToDo planToDo, BindingResult result,
//                              ModelMap modelMap){
//        if(result.hasErrors()){
//            return "to-do";
//        }
//        User user = getUser();
//        planToDo.setUser(user);
//        planService.savePlan(planToDo);
//
//        return "redirect:/";
//    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deletePlan(@RequestParam("id") int id){

        planService.deletePlan(id);
        return "redirect:/";
    }

}
