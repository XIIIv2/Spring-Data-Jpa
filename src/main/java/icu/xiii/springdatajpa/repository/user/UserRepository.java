package icu.xiii.springdatajpa.repository.user;

import icu.xiii.springdatajpa.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findByEmail(String email);
    User findByEmailEndsWith(String email);
    List<User> findAllByEmailEndsWith(String email);
}
