package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserCreateDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class TaskService {
    @Autowired
    private TaskRepository repository;

    public UserCreateDTO addTasks(@RequestBody UserCreateDTO dto){
        Task entityTask = new Task(null, dto.title(), dto.description(), dto.isCompleted());
        var saved = repository.save(entityTask);
        return new UserCreateDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.isCompleted());
    }
}
