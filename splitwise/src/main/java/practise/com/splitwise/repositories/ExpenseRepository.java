package practise.com.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practise.com.splitwise.model.Expense;
import practise.com.splitwise.model.Group;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findALLByGroup(Group group);
}
