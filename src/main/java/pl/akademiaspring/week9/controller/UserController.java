package pl.akademiaspring.week9.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiaspring.week9.aspects.AspectDb;
import pl.akademiaspring.week9.nosql.model.UserNoSql;
import pl.akademiaspring.week9.nosql.service.UserServiceNoSql;
import pl.akademiaspring.week9.sql.model.User;
import pl.akademiaspring.week9.sql.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private UserServiceNoSql userServiceNoSql;
    private AspectDb aspectDb;
    private FormObject formObject;

    @Autowired
    public UserController(UserService userService, UserServiceNoSql userServiceNoSql, AspectDb aspectDb) {
        this.userService = userService;
        this.userServiceNoSql = userServiceNoSql;
        this.aspectDb = aspectDb;
        this.formObject = new FormObject();
    }

    @GetMapping("/mainForm")
    public String mainForm(Model model) {

        model.addAttribute("aspectTime", formObject);

        return "mainForm";
    }

    @GetMapping("/saveDb")
    public String saveToDb(Model model) {

        userService.saveDataIntoDb();
        formObject.setSaveTime(aspectDb.getElapsedTime() / 1000);

        model.addAttribute("aspectTime", formObject);

        return "mainForm";
    }

    @GetMapping("/readDb")
    public String readFromDb(Model model) {

        List<User> users = userService.readDataFromDb();
        formObject.setReadTime(aspectDb.getElapsedTime() / 1000);

        model.addAttribute("aspectTime", formObject);

        return "mainForm";
    }

    @GetMapping("/saveMongoDb")
    public String saveToMongoDb(Model model) {

        userServiceNoSql.saveDataIntoDb();
        formObject.setSaveTimeMongoDb(aspectDb.getElapsedTime() / 1000);

        model.addAttribute("aspectTime", formObject);

        return "mainForm";
    }

    @GetMapping("/readMongoDb")
    public String readFromMongoDb(Model model) {

        List<UserNoSql> userNoSqls = userServiceNoSql.readDataFromDb();
        formObject.setReadTimeMongoDb(aspectDb.getElapsedTime() / 1000);

        model.addAttribute("aspectTime", formObject);

        return "mainForm";
    }
}
