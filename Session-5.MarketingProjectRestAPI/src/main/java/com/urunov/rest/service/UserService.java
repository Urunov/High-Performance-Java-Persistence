package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.User;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    Optional<User> getById(Long userId);

    List<User> getAllUsers();

    void addUser(User user, long id);
    Order updateUser(long id, User userDetails) throws ResourceNotFoundException;
    Map<String, Boolean> deleteUserById(long id) throws ResourceNotFoundException;

}
