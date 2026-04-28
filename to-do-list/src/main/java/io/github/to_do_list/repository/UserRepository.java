package io.github.to_do_list.repository;

import io.github.to_do_list.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
