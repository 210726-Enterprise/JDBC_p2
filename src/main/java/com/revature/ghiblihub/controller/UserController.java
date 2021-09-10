package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.Role;
import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.RoleService;
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
    private final RoleService roleService;

    /**
     * Controller component of Spring MVC that will take in requests related to User objects
     * and resolve them utilizing dependency injections from the userService and roleService beans.
     *
     * @param userService
     * @param roleService
     */
    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     * Receives a request to get all the User objects in the database and returns all
     * User objects in a List.
     * @return a List of User objects stored in the database.
     */
    @GetMapping("/users")
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Receives a request to get a User object in the database by its ID and returns
     * the User object if it exists.
     * @param id
     * @return a User object with the matching id
     */
    @GetMapping("/users/{id}")
    public @ResponseBody
    User findUserById(@PathVariable String id) {
        return userService.getUserById(Integer.parseInt(id));
    }

    /**
     * Receives a request to get a User object in the database by its username and returns
     * the User object if it exists.
     * @param username
     * @return a User object with the matching username
     */
    @GetMapping("/users/username/{username}")
    public @ResponseBody
    User findUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    /**
     * Redirects the request to the login html page
     * @return a redirect to the login html
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * Redirects the request to the new user html page
     * @return a redirect to the new user html page
     */
    @RequestMapping(value = "/login/newuserPage", method = RequestMethod.GET)
    public String createUserPage() {
        return "newuser";
    }

    /**
     * Redirects the request to the profile html page
     * @return a redirect to the profile html page
     */
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    /**
     * Takes in a request to create a new user, checks if the user
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login/newuser", method = RequestMethod.POST)
    public String createUser(@RequestParam String username, @RequestParam String password){
        User u = new User();
        Role role = roleService.getRoleById(1);
        u.setUsername(username);
        u.setPassword(password);
        //u.setAccountType("User");
        u.setRole(role);
        try {
            userService.registerUser(u);
        } catch (Exception e) {
            return "registerError";
        }
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
