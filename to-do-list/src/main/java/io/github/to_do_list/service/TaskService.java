package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public UserTaskDTO addTasks(@RequestBody UserTaskDTO dto){
        Task entityTask = new Task(null, dto.title(), dto.description(), dto.isCompleted());
        var saved = repository.save(entityTask);
        return new UserTaskDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.isCompleted());
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
