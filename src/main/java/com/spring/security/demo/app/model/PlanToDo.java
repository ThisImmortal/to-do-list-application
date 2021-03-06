package com.spring.security.demo.app.model;

import com.spring.security.demo.app.model.validation.ValidPlanDates;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@ValidPlanDates(first = "beginDate", second = "endDate", message = "Invalid date order")
public class PlanToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 10, message = "Enter at least 10 characters")
    @Size(max = 77, message = "You can write maximum 77 characters")
    @NotNull(message = "Enter at least 10 characters")
    private String description;

    @NotNull(message = "Begin date can not be empty")
    private Date beginDate;

    @NotNull(message = "End date can not be empty")
    private Date endDate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                          CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    public PlanToDo(){

    }

    public PlanToDo(int id, String description, Date beginDate, Date endDate) {
        this.id = id;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
