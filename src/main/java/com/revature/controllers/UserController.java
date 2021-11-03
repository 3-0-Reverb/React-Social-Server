package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping(path="/testNoAuth")
    public ResponseEntity<User> getTestUserNoAuth(@AuthenticationPrincipal User user) {
        User returnThis = new User();
        returnThis.setEmail("Poncho_Villa_No_Auth");
        
        if(user != null) {
        	System.out.println("I figured out who I am! " + user.getUid());
        } else {
        	System.out.println("NO USER");
        }

        return ResponseEntity.ok(returnThis);
    }

    @GetMapping(path="/testWithAuth")
    public ResponseEntity<User> getTestUserWithAuth(@AuthenticationPrincipal User user) {
        User returnThis = new User();
        returnThis.setEmail("Poncho_Villa_With_Auth");
        
        System.out.println("I figured out who I am! " + user.getUid());
        
        return ResponseEntity.ok(returnThis);
    }

    @PostMapping
    public ResponseEntity<User> createUser(
            @RequestBody User neoUser
    ) {
        User returnThis = new User();
        returnThis.setEmail("User Created: "+ neoUser.getEmail());
        return ResponseEntity.ok(returnThis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(
            @PathVariable(value = "id") Long userID
    ) {
        User returnThis = new User();
        returnThis.setEmail("Delete User: "+ userID);
        return ResponseEntity.ok(returnThis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Long userID,
            @RequestBody User neoUser
    ) {
        User returnThis = new User();
        returnThis.setUid("0");
        returnThis.setEmail("Update User: "+ userID);
        return ResponseEntity.ok(returnThis);
    }


}
