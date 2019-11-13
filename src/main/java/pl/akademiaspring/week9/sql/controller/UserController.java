package pl.akademiaspring.week9.sql.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiaspring.week9.aspects.AspectDb;
import pl.akademiaspring.week9.sql.service.UserService;

@Controller
public class UserController {

    private UserService userService;
    private AspectDb aspectDb;
    private FormObject formObject;

    @Autowired
    public UserController(UserService userService, AspectDb aspectDb) {
        this.userService = userService;
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

        userService.readDataFromDb();
        formObject.setReadTime(aspectDb.getElapsedTime() / 1000);

        model.addAttribute("aspectTime", formObject);

        return "mainForm";
    }
}
