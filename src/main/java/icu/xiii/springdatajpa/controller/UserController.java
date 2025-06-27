package icu.xiii.springdatajpa.controller;

import icu.xiii.springdatajpa.dto.user.*;
import icu.xiii.springdatajpa.entity.user.User;
import icu.xiii.springdatajpa.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/users"))
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDtoCreateResponse> createUser(@RequestBody UserDtoRequest request) {
        User user = service.create(request);
        return ResponseEntity.ok(UserDtoCreateResponse.of(user != null, user));
    }

    @GetMapping
    public ResponseEntity<UserDtoListResponse> getAllUsers() {
        List<User> users = service.getAll();
        return ResponseEntity.ok(UserDtoListResponse.of(users.isEmpty(), users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoGetByIdResponse> getUserById(@PathVariable("id") Long id) {
        User user = service.getById(id);
        return ResponseEntity.ok(UserDtoGetByIdResponse.of(id, user != null, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtoUpdateResponse> updateUserById(@PathVariable("id") Long id, @RequestBody UserDtoRequest request) {
        User user = service.updateById(id, request);
        return ResponseEntity.ok(UserDtoUpdateResponse.of(id, user != null, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDtoDeleteResponse> deleteUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(UserDtoDeleteResponse.of(id, service.deleteById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserDtoGetByNameResponse>  getUserByName(@PathVariable("name") String name) {
        User user = service.getByName(name);
        return ResponseEntity.ok(UserDtoGetByNameResponse.of(name, user != null, user));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDtoListByEmailResponse>  getUserByEmail(@PathVariable("email") String email) {
        List<User> users = service.getByEmail(email);
        return ResponseEntity.ok(UserDtoListByEmailResponse.of(email, users));
    }
}
