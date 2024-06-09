package practise.com.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpensiveUser extends BaseModel {
    @ManyToOne
    private  Expense expense;
    @ManyToOne
    private  User user;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpensiveUserType expensiveUserType;
}
