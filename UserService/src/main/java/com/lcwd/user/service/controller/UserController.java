package com.lcwd.user.service.controller;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User u)
    {
        User user1 = us.saveuser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getSingleUSer(@PathVariable String userid)
    {
        User user = us.getUser(userid);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUser = us.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(allUser);
    }
}
