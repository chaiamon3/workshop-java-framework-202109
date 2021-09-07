package com.example.demoapp.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

    @Autowired
    UserGateway userGateway;

    @Test
    void getUserById() {
        // Act
        Optional<UserResponse> response = userGateway.getUserById(1);
        // Assert
        assertTrue(response.isPresent());
        UserResponse userResponse = response.get();
        assertEquals(1, userResponse.getId());
        assertEquals("Bret", userResponse.getUsername());
    }

}