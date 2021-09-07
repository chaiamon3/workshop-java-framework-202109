package com.example.demoapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * <description>
 *
 * @author nattawat.k
 * @type com.example.demoapp.users
 * @contact nattawat.k@kbtg.tech
 * @date 9/7/2021 4:19 PM
 */
@Component
public class UserGateway {

    private final RestTemplate restTemplate;
    private final String apiHost;

    @Autowired
    public UserGateway(RestTemplateBuilder builder, @Value("${external_api_url}") String apiHost) {
        this.restTemplate = builder.build();
        this.apiHost = apiHost;
    }

    public Optional<UserResponse> getUserById(int id) {
        String url = apiHost + "/users/" + id;
        try {
            return Optional.ofNullable(restTemplate.getForObject(url, UserResponse.class));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }

}
