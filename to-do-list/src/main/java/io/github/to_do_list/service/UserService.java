package io.github.to_do_list.service;

import io.github.to_do_list.dto.UserHistoryDTO;
import io.github.to_do_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void displayTasks(@PageableDefault(size=5) Pageable pageable){
        repository.findAll(pageable).map(UserHistoryDTO::new);
    }
}
