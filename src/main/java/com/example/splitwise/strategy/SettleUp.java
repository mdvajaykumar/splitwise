package com.example.splitwise.strategy;

import com.example.splitwise.model.Expense;

import java.util.List;

public interface SettleUp {
    List<Expense> settleUp(List<Expense> expensesToSettle);

}
