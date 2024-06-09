package practise.com.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity(name="usergroup")
@Getter
@Setter

public class Group extends BaseModel {
    private String groupName;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

    @ManyToMany
    private List<User> members;
    @ManyToOne
    private User createdBy;
}
