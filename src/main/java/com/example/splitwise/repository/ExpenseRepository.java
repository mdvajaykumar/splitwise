package com.example.splitwise.repository;

import com.example.splitwise.model.Expense;
import com.example.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository  extends JpaRepository<Expense, Integer> {

    List<Expense> findAllByGroup(Group group);
}
