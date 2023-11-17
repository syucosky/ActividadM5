package com.example.academiaspring.Repository;

import com.example.academiaspring.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {

}
