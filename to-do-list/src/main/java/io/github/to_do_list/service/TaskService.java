package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.dto.UserUpdateDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.model.User;
import io.github.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserService userService;

    public List<Task> displayAllTasks() {
        return repository.findAll();
    }

    public UserTaskDTO addTasks(UserTaskDTO dto, Long userId){
        var user = userService.findById(userId);

        Task entityTask = new Task(null, dto.title(), dto.description(), dto.isCompleted(), user);
        var saved = repository.save(entityTask);
        return new UserTaskDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.isCompleted(), saved.getUser().getId());
    }

    public List<Task> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public UserUpdateDTO taskCompletion(UserUpdateDTO dto,  Long userId, Long id) {
        Task task = repository.findByIdAndUserId(id,userId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(dto.isCompleted());
        Task saved = repository.save(task);

        return new UserUpdateDTO(saved.getId(), saved.isCompleted(), saved.getUser().getId());
    }


}
