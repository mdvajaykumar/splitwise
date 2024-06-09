package practise.com.splitwise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practise.com.splitwise.exception.GroupNotFoundException;
import practise.com.splitwise.exception.UserNotFoundException;
import practise.com.splitwise.model.Expense;
import practise.com.splitwise.model.ExpensiveUser;
import practise.com.splitwise.model.Group;
import practise.com.splitwise.model.User;
import practise.com.splitwise.repositories.ExpenseRepository;
import practise.com.splitwise.repositories.ExpensiveUserRepository;
import practise.com.splitwise.repositories.GroupRepository;
import practise.com.splitwise.repositories.UserRepository;
import practise.com.splitwise.strategies.SettleUpStrategy;

import java.util.*;


@Service
public class SettleUpService {

    private  ExpenseRepository expenseRepository;

    private  GroupRepository groupRepository;

    private SettleUpStrategy settleUpStrategy;

    private UserRepository userRepository;

    private ExpensiveUserRepository expensiveUserRepository;

    @Autowired
    public SettleUpService(ExpenseRepository expenseRepository, GroupRepository groupRepository,
                           SettleUpStrategy settleUpStrategy,UserRepository userRepository, ExpensiveUserRepository expensiveUserRepository) {
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.userRepository =userRepository;
        this.expensiveUserRepository =expensiveUserRepository;
    }

    public List<Expense> settleUpforUser(long user_id) {
          /*
            1. Get all expenses in which user is part of
            2. Iterate through all of the expenses and find out of
               all people involved in those expenses, who owes how much extra/ less.
            3. Use Min and Max Heap approach to find all the transactions that have to be made
            4. Return transactions involving the user
         */

        Optional<User> optionalUser = userRepository.findById(user_id);

        if(optionalUser.isEmpty()){
             throw new UserNotFoundException();
        }

        User user = optionalUser.get();

        List<ExpensiveUser> expensiveUsers = expensiveUserRepository.findALLByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for(ExpensiveUser expensiveUser: expensiveUsers){
            expenses.add(expensiveUser.getExpense());
        }

        List<Expense> expensesToSettle = settleUpStrategy.settleUp(expenses.stream().toList());
        List<Expense> expensesToReturn = new ArrayList<>();

        for(Expense expense: expensesToSettle){
            for(ExpensiveUser expensiveuser :expense.getExpensiveUser()){
                if(expensiveuser.getUser().equals(user)){
                    expensesToReturn.add(expensiveuser.getExpense());
                    break;
                }

            }
        }


        return null;

    }

    public List<Expense> settleUpforGroup(long groupId) {
          /*
        1. Get all expenses that were made in that group.
        2. Iterate through all of the expenses and find out of
           all people involved in those expenses, who owes how much extra/ less.
        3. Use Min and Max Heap approach to find all the transactions that have to be made
        4. Return all transaction
         */

        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) {
            throw new GroupNotFoundException();
        }


        Group group = groupOptional.get();
        List<Expense> expenses = expenseRepository.findALLByGroup(group);
        List<Expense> expensesToSettle =settleUpStrategy.settleUp(expenses);

        return expensesToSettle;
    }

}
