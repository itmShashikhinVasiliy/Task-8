package shashikhin.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shashikhin.web.models.User;

@Service
public class UserServiceImpl implements UserService {

    private final String URL = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public void getUsers() {
        var responseGet = restTemplate.exchange(URL, HttpMethod.GET, null, String.class);
        headers.add("Cookie", responseGet.getHeaders().getFirst(HttpHeaders.SET_COOKIE));
    }

    public String createUser(User user) {
        return restTemplate
                .exchange(URL, HttpMethod.POST, new HttpEntity<>(user, headers), String.class)
                .getBody();
    }

    public String updateUser(User user) {
        return restTemplate
                .exchange(URL, HttpMethod.PUT, new HttpEntity<>(user, headers), String.class)
                .getBody();
    }

    public String deleteUser(String id) {
        return restTemplate
                .exchange(URL + "/" + id, HttpMethod.DELETE, new HttpEntity<>(headers), String.class)
                .getBody();
    }
}