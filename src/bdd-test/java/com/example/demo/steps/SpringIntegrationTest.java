package com.example.demo.steps;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    public static ResponseEntity<String> latestResponse = null;

    @Autowired
    private TestRestTemplate restTemplate;

    public void executeGet(String path) {
        latestResponse = this.restTemplate.getForEntity(path, String.class);
    }

}
