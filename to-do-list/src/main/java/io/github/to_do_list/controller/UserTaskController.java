package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.dto.UserUpdateDTO;
import io.github.to_do_list.model.StatusTask;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserTaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public ResponseEntity<List<UserTaskDTO>> displayAllTasks(){
        List<UserTaskDTO> dtoTask = service.displayAllTasks();
        return ResponseEntity.ok(dtoTask);
    }

    @PostMapping("/{userId}/tasks")
    @Transactional
    public ResponseEntity<UserTaskDTO> addTasks(@RequestBody UserTaskDTO dto, @PathVariable Long userId){
        UserTaskDTO dtoTask = service.addTasks(dto, userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoTask);
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<UserTaskDTO>> findByUserId(@PathVariable("userId") Long userId){
        List<UserTaskDTO> dtoTask = service.findByUserId(userId);
        return ResponseEntity.ok(dtoTask);
    }


    @GetMapping("{userId}/tasks/{status}")
    public ResponseEntity<List<UserTaskDTO>> displayByStatus(@PathVariable("status") String status, @PathVariable("userId") Long userId){
        List<UserTaskDTO> dtoTask= service.displayByStatus(
                StatusTask.valueOf(status.toUpperCase()), userId
        );

        return ResponseEntity.ok(dtoTask);
    }

    @PatchMapping("{userId}/tasks/{id}")
    @Transactional
    public ResponseEntity<UserUpdateDTO> updateStatus(@PathVariable("userId") Long userId, @PathVariable("id") Long id, @RequestBody UserUpdateDTO dto){
        UserUpdateDTO dtoUpdate = service.updateStatus(userId, id, dto.status());

        return ResponseEntity.ok(dtoUpdate);
    }
}
