package practise.com.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practise.com.splitwise.model.ExpensiveUser;
import practise.com.splitwise.model.User;

import java.util.List;

@Repository
public interface ExpensiveUserRepository extends JpaRepository<ExpensiveUser, Long> {


    List<ExpensiveUser> findALLByUser(User user);


}
