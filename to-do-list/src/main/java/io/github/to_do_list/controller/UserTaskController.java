package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserTaskController {
    @Autowired
    private TaskService service;

    @PostMapping("/{userId}/tasks")
    public UserTaskDTO addTasks(@RequestBody UserTaskDTO dto, @PathVariable Long userId){
      return service.addTasks(dto, userId);
    }

    @GetMapping("/{userId}/tasks")
    public List<Task> findByUserId(@PathVariable("userId") Long userId){
        return service.findByUserId(userId);
    }
}
