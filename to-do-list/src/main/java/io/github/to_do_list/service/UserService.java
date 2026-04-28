package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserCreateDTO;
import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.model.User;
import io.github.to_do_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }


    public UserCreateDTO createUser(UserCreateDTO dto) {
        User user = new User(dto.id(), dto.name());
        User savedUser = repository.save(user);
        return new UserCreateDTO(savedUser.getId(), savedUser.getName());
    }


    public List<User> displayUsers() {
        return repository.findAll();
    }
}
