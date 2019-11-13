package pl.akademiaspring.week9.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.week9.aspects.AccessDb;
import pl.akademiaspring.week9.sql.model.User;
import pl.akademiaspring.week9.sql.repository.UserRepository;
import pl.akademiaspring.week9.sql.service.api.UserApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private UserRepository userRepository;
    private List<User> usersList;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getUsers() {
        RestTemplate restTemplate = new RestTemplate();

        UserApi[] users = restTemplate.getForObject("https://my.api.mockaroo.com/myuniquestring789.json?key=c19b3960",
                UserApi[].class);

        usersList = Arrays.stream(users)
                .map(u -> new User(u.getId(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getEmail(),
                        u.getGender(),
                        u.getIpAddress()))
                .collect(Collectors.toList());
    }

    @AccessDb
    public void saveDataIntoDb() {
        userRepository.saveAll(usersList);
    }

    @AccessDb
    public void readDataFromDb() {
        userRepository.findAll();
    }
}
