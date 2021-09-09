package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public @ResponseBody
    User findUserById(@PathVariable String id) {
        return userService.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/users/username/{username}")
    public @ResponseBody
    User findUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login/newuser")
    public String createUserPage() {
        return "newuser";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping(value = "/login/newuser", method = RequestMethod.POST)
    public String createUser(@RequestParam String username, @RequestParam String password){
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setAccountType("User");
        userService.saveUser(u);
        return "login";
    }

    @DeleteMapping("/users/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        if(userService.deleteUser(Integer.parseInt(id))) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users")
    public @ResponseBody
    User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
