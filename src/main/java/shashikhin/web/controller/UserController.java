package shashikhin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shashikhin.web.models.User;
import shashikhin.web.services.UserService;

@RestController
public class UserController{

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String run(){
        userService.getUsers();

        User user = new User(3L, "James", "Brown", (byte) 30);
        String first = userService.createUser(user);

        user.setName("Thomas");
        user.setLastName("Shelby");

        return first + userService.updateUser(user) + userService.deleteUser(user.getId().toString());
    }
}