package org.mesoma.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/users")
    public List<User> getUsers(){
        return (userService.getUsers());
    }

    @GetMapping("api/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
        return userService.getUserById(userId);
    }
    @PostMapping("api/users/{name}/{userId}")
    public void addNewUser(@PathVariable("name") String firstName,
                           @PathVariable(value = "userId", required = false) Integer userId){
        User newUser;
        if (userId != null) {
            newUser = new User(userId, firstName);
        } else {
            newUser = new User(firstName);
        }
        userService.addNewUser(newUser);
    }

    @PostMapping("api/users")
    public void registerNewUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        userService.registerNewUser(userRegistrationRequest);
    }
}
