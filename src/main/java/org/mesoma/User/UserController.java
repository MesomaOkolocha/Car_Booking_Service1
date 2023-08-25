package org.mesoma.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers(){
        return (userService.getUsers());
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") UUID userId){
        return userService.getUserById(userId);
    }
    @PostMapping("{name}/{userId}")
    public void addNewUser(@PathVariable("name") String firstName,
                           @PathVariable(value = "userId", required = false) UUID userId){
        User newUser;
        if (userId != null) {
            newUser = new User(userId, firstName);
        } else {
            newUser = new User(firstName);
        }
        userService.addNewUser(newUser);
    }

    @PostMapping()
    public void registerNewUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        userService.registerNewUser(userRegistrationRequest);
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable ("userId") UUID userId){
        userService.deleteUserById(userId);

    }
}
