package practise.com.splitwise.strategies;

import org.springframework.stereotype.Component;
import practise.com.splitwise.model.Expense;

import java.util.List;

@Component
public class HeapSettleStrategy implements SettleUpStrategy{

    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettle) {
        return null;
    }
}
