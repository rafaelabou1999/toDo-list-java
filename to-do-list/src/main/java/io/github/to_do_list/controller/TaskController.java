package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserCreateDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.repository.TaskRepository;
import io.github.to_do_list.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    @Transactional
    public UserCreateDTO addTasks(@RequestBody UserCreateDTO dto){
       return service.addTasks(dto);
    }
}
