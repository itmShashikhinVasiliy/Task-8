package shashikhin.web.services;

import shashikhin.web.models.User;

public interface UserService {
    void getUsers();
    String createUser(User user);
    String updateUser(User user);
    String deleteUser(String id);
}