package com.pomodoro.api.services;

import com.pomodoro.api.model.Task;
import com.pomodoro.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brad
 */
@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repository;
    
    public Long addNewTask(Task task){
        return repository.create(task);
    }
    
    public Task getTask(Long id){
        return repository.read(id);
    }
    
}
