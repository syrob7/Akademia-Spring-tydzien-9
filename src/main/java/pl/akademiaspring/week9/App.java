package pl.akademiaspring.week9;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.week9.nosql.model.UserNoSql;
import pl.akademiaspring.week9.sql.model.User;
import pl.akademiaspring.week9.sql.service.api.UserApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class App {

    private List<User> usersList;
    private List<UserNoSql> usersNoSqlList;

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

        usersNoSqlList = Arrays.stream(users)
                .map(u -> new UserNoSql(u.getId(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getEmail(),
                        u.getGender(),
                        u.getIpAddress()))
                .collect(Collectors.toList());
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public List<UserNoSql> getUsersNoSqlList() {
        return usersNoSqlList;
    }
}
