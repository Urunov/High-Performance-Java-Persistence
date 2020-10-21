package com.urunov.rest.serviceRun;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.User;
import com.urunov.rest.repository.UserResource;
import com.urunov.rest.service.UserService;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserServiceRun implements UserService {

    private UserResource userResource;

    @Override
    public Optional<User> getById(Long userId) {
        return userResource.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void addUser(User user, long id) {

    }

    @Override
    public Order updateUser(long id, User userDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteUserById(long id) throws ResourceNotFoundException {
        return null;
    }
}
