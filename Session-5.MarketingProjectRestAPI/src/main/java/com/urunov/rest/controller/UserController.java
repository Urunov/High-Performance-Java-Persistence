package com.urunov.rest.controller;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.User;
import com.urunov.rest.repository.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserResource userResource;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userResource.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {

        User user = userResource.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Product not found for this"+ userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user){
        return userResource.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                                 @Valid @RequestBody User userDetails) throws ResourceNotFoundException{
        //
        User user = userResource.findById(userId).orElseThrow(()-> new ResolutionException("User not found for this" + userId));

        user.setName(userDetails.getName());
        user.setAddress(userDetails.getAddress());
        user.setContacts(userDetails.getContacts());
        user.setCreation_date(userDetails.getCreation_date());
        user.setEmail(userDetails.getEmail());
        user.setImage(userDetails.getImage());


        final User updateUser = userResource.save(user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException{


        User user = userResource.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found for this id::" + userId));

        userResource.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
