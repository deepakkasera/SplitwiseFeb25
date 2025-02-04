package com.example.splitwisefeb25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "splitwise_groups")
public class Group extends BaseModel {
    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members;

    @OneToMany
    private List<Expense> expenses;
}

// Group ---- CreatedBy => M:1
// Group ---- Members => M:M
