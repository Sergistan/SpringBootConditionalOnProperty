package ru.netology.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private final GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    private final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeEach
    public void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void contextLoadsDevApp() {
        ResponseEntity<String> devEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
        Assertions.assertEquals(devEntity.getBody(), "Current profile is dev");
    }

    @Test
    void contextLoadsProdApp() {
        ResponseEntity<String> prodEntity = restTemplate.getForEntity("http://localhost:" + prodApp.getMappedPort(8081) + "/profile", String.class);
        Assertions.assertEquals(prodEntity.getBody(), "Current profile is production");
    }
}
