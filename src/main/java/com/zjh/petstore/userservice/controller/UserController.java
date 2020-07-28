package com.zjh.petstore.userservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjh.petstore.userservice.entity.User;
import com.zjh.petstore.userservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired private UserRepository userRepository;

  @PostMapping("/")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User newUser = userRepository.save(user);
    return ResponseEntity.ok(newUser);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable String id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return ResponseEntity.ok(optionalUser.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Boolean> updateUser(@PathVariable String id, @RequestBody User user) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      user.setId(id);
      userRepository.save(user);
      return ResponseEntity.ok(true);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
    userRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
