package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.dto.UserUpdateDTO;
import io.github.to_do_list.model.StatusTask;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserService userService;

    public List<UserTaskDTO> displayAllTasks() {
        return repository.findAll()
                .stream()
                .map(t -> new UserTaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.isCompleted(), t.getUser().getId(), t.getStatus(), t.getCreatedAt()))
                .toList();
    }

    public UserTaskDTO addTasks(UserTaskDTO dto, Long userId){
        var user = userService.findById(userId);

        Task entityTask = new Task(null, dto.title(), dto.description(),  user, dto.isCompleted(), dto.status());
        var saved = repository.save(entityTask);
        return new UserTaskDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.isCompleted(), saved.getUser().getId(), saved.getStatus(), saved.getCreatedAt());
    }

    public List<UserTaskDTO> findByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(t -> new UserTaskDTO(t.getId(), t.getTitle(), t.getDescription(),t.isCompleted(), t.getUser().getId(), t.getStatus(), t.getCreatedAt()))
                .toList();
    }

    public UserUpdateDTO taskCompletion(UserUpdateDTO dto,  Long userId, Long id) {
        Task task = repository.findByIdAndUserId(id,userId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(dto.isCompleted());
        Task saved = repository.save(task);

        return new UserUpdateDTO(saved.getId(), saved.isCompleted(), saved.getUser().getId());
    }

    public List<UserTaskDTO> displayByStatus(StatusTask status){

       List<UserTaskDTO> tasksWithStatus = repository.findByStatus(status).stream().map(UserTaskDTO::new).toList();

       if(tasksWithStatus.isEmpty()){
           throw new RuntimeException("No tasks");
       }

       return tasksWithStatus;

    }

}
