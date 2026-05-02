package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.dto.UserUpdateDTO;
import io.github.to_do_list.model.StatusTask;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserTaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public List<UserTaskDTO> displayAllTasks(){
        return service.displayAllTasks();
    }

    @PostMapping("/{userId}/tasks")
    @Transactional
    public UserTaskDTO addTasks(@RequestBody UserTaskDTO dto, @PathVariable Long userId){
      return service.addTasks(dto, userId);
    }

    @GetMapping("/{userId}/tasks")
    public List<UserTaskDTO> findByUserId(@PathVariable("userId") Long userId){
        return service.findByUserId(userId);
    }


    @GetMapping("{userId}/tasks/{status}")
    public List<UserTaskDTO> displayByStatus(@PathVariable("status") String status, @PathVariable("userId") Long userId){
        return service.displayByStatus(
                StatusTask.valueOf(status.toUpperCase()), userId
        );
    }

    @PatchMapping("{userId}/tasks/{id}")
    @Transactional
    public UserUpdateDTO updateStatus(@PathVariable("userId") Long userId, @PathVariable("id") Long id, @RequestBody UserUpdateDTO dto){
        return service.updateStatus(userId, id, dto.status());
    }
}
