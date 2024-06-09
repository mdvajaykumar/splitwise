package com.example.splitwise.repository;

import com.example.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Integer> {


    Optional<Group> findById(Long id);

}
