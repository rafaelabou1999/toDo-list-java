package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserCreateDTO;
import io.github.to_do_list.dto.UserDisplayDTO;
import io.github.to_do_list.dto.UserTaskDTO;
import io.github.to_do_list.model.User;
import io.github.to_do_list.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity createUser(@RequestBody UserCreateDTO dto, UriComponentsBuilder uriBuilder){
        UserCreateDTO dtoCreate = service.createUser(dto);
        URI uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(dtoCreate.id())
                .toUri();

        return ResponseEntity.created(uri).body(dtoCreate);
    }

    @GetMapping
    public ResponseEntity<List<UserDisplayDTO>> displayUsers(){
        List<UserDisplayDTO> dtoDisplay = service.displayUsers();
        return ResponseEntity.ok(dtoDisplay);
    }

}
