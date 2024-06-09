package com.example.splitwise.service;

import com.example.splitwise.model.Expense;
import com.example.splitwise.model.Group;
import com.example.splitwise.model.User;
import com.example.splitwise.repository.ExpenseRepository;
import com.example.splitwise.repository.GroupRepository;
import com.example.splitwise.strategy.SettleUp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    private GroupRepository groupRepository;

    private ExpenseRepository expenseRepository;

    private SettleUp settleUpStrategy;



    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository){
        this.groupRepository =groupRepository;
        this.expenseRepository =expenseRepository;
    }

    // settle up user


           /*
            1. Get all expenses in which user is part of
            2. Iterate through all of the expenses and find out of
               all people involved in those expenses, who owes how much extra/ less.
            3. Use Min and Max Heap approach to find all the transactions that have to be made
            4. Return transactions involving the user
         */





    // settle up  group
       /*
        1. Get all expenses that were made in that group.
        2. Iterate through all of the expenses and find out of
           all people involved in those expenses, who owes how much extra/ less.
        3. Use Min and Max Heap approach to find all the transactions that have to be made
        4. Return all transaction
         */


    public List<Expense> settleGroup(int id){

        Optional<Group> group =   groupRepository.findById(id);

        if(group.isEmpty()){
            throw new RuntimeException();
        }

        List<Expense> expenses   = expenseRepository.findAllByGroup(group.get());

        List<Expense> expensesToSettle = settleUpStrategy.settleUp(expenses);

        return expensesToSettle;


    }


}
