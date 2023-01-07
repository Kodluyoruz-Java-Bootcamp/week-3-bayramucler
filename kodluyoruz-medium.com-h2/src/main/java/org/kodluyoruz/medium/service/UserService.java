package org.kodluyoruz.medium.service;

import org.kodluyoruz.medium.dao.UserDao;
import org.kodluyoruz.medium.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void createUser(User user){
        userDao.createUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    public void printAllUsers() {
        getAllUsers().forEach(user -> System.out.println(user));
    }

}
