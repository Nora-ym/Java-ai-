package com.example.fastapispringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class SentimentService {
    @Autowired
    private RestTemplate restTemplate;
    private final String PYTHON_API_URL="http://localhost:8000/analyze";

    public Map<String, Object> analyze(String text){
        Map<String,Object> requsetBody=Map.of("text",text);
        ResponseEntity<Map> response=restTemplate.postForEntity(PYTHON_API_URL,requsetBody, Map.class);
        return response.getBody();
    }
}

