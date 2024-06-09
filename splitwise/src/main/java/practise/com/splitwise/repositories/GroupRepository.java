package practise.com.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practise.com.splitwise.model.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long>{

    @Override
    Optional<Group> findById(Long aLong);
}
