package pl.akademiaspring.week9.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiaspring.week9.App;
import pl.akademiaspring.week9.aspects.AccessDb;
import pl.akademiaspring.week9.sql.model.User;
import pl.akademiaspring.week9.sql.repository.UserRepository;

import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private App app;

    @Autowired
    public UserService(App app, UserRepository userRepository) {
        this.app = app;
        this.userRepository = userRepository;
    }

    @AccessDb
    public void saveDataIntoDb() {
        if (app.getUsersList() == null) return;
        userRepository.saveAll(app.getUsersList());
    }

    @AccessDb
    public List<User> readDataFromDb() {
        return userRepository.findAll();
    }
}
