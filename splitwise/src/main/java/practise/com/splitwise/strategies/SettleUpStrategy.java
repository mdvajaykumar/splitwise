package practise.com.splitwise.strategies;

import org.springframework.stereotype.Component;
import practise.com.splitwise.model.Expense;

import java.util.List;

@Component
public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expensesToSettle);
}
