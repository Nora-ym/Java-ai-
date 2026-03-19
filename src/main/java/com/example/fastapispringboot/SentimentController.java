package com.example.fastapispringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/sentiment")
public class SentimentController {
   @Autowired
   private SentimentService sentimentService;
   @GetMapping("/analyze")
    public Map<String, Object> analyze(@RequestParam String text){
       return sentimentService.analyze(text);
   }

}
