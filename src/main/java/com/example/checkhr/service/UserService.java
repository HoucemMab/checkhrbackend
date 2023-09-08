package com.example.checkhr.service;

import com.example.checkhr.model.Role;
import com.example.checkhr.model.User;
import com.example.checkhr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }
    public Optional<User> getUserById(Long id ){
        return this.userRepository.findById(id);
    }
    public void deleteUserById(Long id){
        this.userRepository.deleteById(id);
    }

    public List<User> findEmployees(){
        return this.userRepository.findUsersByRole(Role.EMPLOYEE);
    }

    public  User updateEmployee(User user) throws ClassNotFoundException {
        Optional<User> us = getUserById(user.getId_user());
        if(!us.isPresent()){
            throw new ClassNotFoundException("Cannot find User with this data ");
        }
        return this.userRepository.save(user);
    }

}
