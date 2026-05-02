package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.dto.UserUpdateDTO;
import io.github.to_do_list.model.StatusTask;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.model.User;
import io.github.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserService userService;

    public List<UserTaskDTO> displayAllTasks() {
        return repository.findAll()
                .stream()
                .map(t -> new UserTaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.getUser().getId(), t.getStatus(), t.getCreatedAt()))
                .toList();
    }

    public UserTaskDTO addTasks(UserTaskDTO dto, Long userId){
        var user = userService.findById(userId);

        Task entityTask = new Task(null, dto.title(), dto.description(),  user, dto.status());
        var saved = repository.save(entityTask);
        return new UserTaskDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getUser().getId(), saved.getStatus(), saved.getCreatedAt());
    }

    public List<UserTaskDTO> findByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(t -> new UserTaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.getUser().getId(), t.getStatus(), t.getCreatedAt()))
                .toList();
    }


    public List<UserTaskDTO> displayByStatus(StatusTask status, Long userId){
       User userFound = userService.findById(userId);
       List<Task> tasksFound = userFound.getAllTasks().stream().filter(t -> t.getStatus() == status).toList();

       List<UserTaskDTO> tasksToDto = tasksFound.stream().map(UserTaskDTO::new).toList();

       return tasksToDto;

    }

    public UserUpdateDTO updateStatus(Long userId, Long id, StatusTask status) {
       User userFound = userService.findById(userId);

       Task taskFound = userFound.getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Task not found"));

       taskFound.setStatus(status);
       repository.save(taskFound);

       return new UserUpdateDTO(taskFound);
    }
}
