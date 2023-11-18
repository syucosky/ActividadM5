package com.example.academiaspring.Service;


import com.example.academiaspring.Entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    public void addTask(TaskEntity task);

    public TaskEntity findById(int id);

    public List<TaskEntity> findAll();

    public void editTask(TaskEntity task);

    public void deleteById(int id);
}
