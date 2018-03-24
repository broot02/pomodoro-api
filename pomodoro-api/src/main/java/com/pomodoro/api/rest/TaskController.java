package com.pomodoro.api.rest;

import com.pomodoro.api.model.Task;
import com.pomodoro.api.services.TaskService;
import java.util.Collection;
import java.util.Collections;
import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Rest API for dealing with the {@link Task} model.
 *
 * @author Brad Root
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Task getTask(@PathVariable(name = "id") Long id) {
    return taskService.getTask(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    Long id = taskService.addNewTask(task);
    return ResponseEntity.created(ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(id).toUri()).build();
  }
  
}
