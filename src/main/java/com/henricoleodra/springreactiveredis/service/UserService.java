package com.henricoleodra.springreactiveredis.service;

import com.henricoleodra.springreactiveredis.entity.User;
import com.henricoleodra.springreactiveredis.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Mono<User> saveUser(User user) {
        return repository.save(user);
    }

    public Mono<User> getUserById(String userId) {
        return repository.findById(userId);
    }

    public Flux<User> getAllUsers() {
        return repository.findAll();
    }

    public Mono<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Mono<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Mono<Boolean> userExistedByid(String userId) {
        return repository.existsById(userId);
    }

    public Mono<Boolean> userExistsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public Mono<Boolean> userExistsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public Mono<Void> deleteUserById(String userId) {
        return repository.deleteById(userId);
    }

    public Mono<Void> deleteUser(User user) {
        return repository.delete(user);
    }

    public Mono<Void> deleteAllUsers() {
        return repository.deleteAll();
    }

    public Mono<Long> userCount() {
        return repository.count();
    }
}
