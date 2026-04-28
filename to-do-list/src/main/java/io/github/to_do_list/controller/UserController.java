package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserCreateDTO;
import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.model.User;
import io.github.to_do_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public void createUser(@RequestBody UserCreateDTO dto){
        service.createUser(dto);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
       return service.findById(id);
    }

    @GetMapping
    public List<User> displayUsers(){
        return service.displayUsers();
    }

}
