package pl.akademiaspring.week9.nosql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiaspring.week9.App;
import pl.akademiaspring.week9.aspects.AccessDb;
import pl.akademiaspring.week9.nosql.repository.UserRepositoryNoSql;

@Service
public class UserServiceNoSql {

    private UserRepositoryNoSql userRepository;
    private App app;

    @Autowired
    public UserServiceNoSql(App app, UserRepositoryNoSql userRepository) {
        this.app = app;
        this.userRepository = userRepository;
    }

    @AccessDb
    public void saveDataIntoDb() {
        if (app.getUsersNoSqlList() == null) return;
        userRepository.saveAll(app.getUsersNoSqlList());
    }

    @AccessDb
    public void readDataFromDb() {
        userRepository.findAll();
    }
}
