package io.github.to_do_list.controller;

import io.github.to_do_list.dto.UserCreateDTO;
import io.github.to_do_list.dto.UserHistoryDTO;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.repository.UserRepository;
import io.github.to_do_list.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public void displayTasks(@PageableDefault(size=5) Pageable pageable){
        service.displayTasks(pageable);
    }

}
