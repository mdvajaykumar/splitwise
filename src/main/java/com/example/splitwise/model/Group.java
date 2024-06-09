package com.example.splitwise.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Group extends BaseModel{

    private String name;

    private User createdBy;

    private List<User> user;

    private List<Expense> expenses;
}
