package practise.com.splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity()
public class Expense extends BaseModel {
    private  String description;
    @ManyToOne
    private User createdBY;
    private  int amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpensiveType expensiveType;
    private Date createdAt;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    List<ExpensiveUser> expensiveUser;

}
