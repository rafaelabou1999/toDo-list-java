package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    @Transactional
    public UserTaskDTO addTasks(@RequestBody UserTaskDTO dto){
       return service.addTasks(dto);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id){
        return service.findById(id);
    }
}
