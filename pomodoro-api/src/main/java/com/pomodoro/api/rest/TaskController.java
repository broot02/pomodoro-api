package com.pomodoro.api.rest;

import com.pomodoro.api.model.Task;
import java.util.Collection;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Brad Root
 */
@RestController
@RequestMapping("/{userId}/tasks")
public class TaskController {

    @GetMapping
    public Collection<Task> getTask(@PathVariable(name = "userId") Integer userId) {
        return Collections.EMPTY_LIST;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Task> createTask(@PathVariable(name = "userId") Integer userId, @RequestBody Task task) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/1").buildAndExpand().toUri()).build();
    }

}
