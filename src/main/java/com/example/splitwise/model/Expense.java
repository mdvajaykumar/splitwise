package com.example.splitwise.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{

    private String description;

    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private  ExpensiveType expensiveType;

    @ManyToOne
    private  Group group;
}
