package practise.com.splitwise.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "users")
public class User extends  BaseModel{
    private String name;
    private String password;
    private String phoneNumber;
}
