package ru.btproject.traineeservice;

import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter
@RequestMapping("api/hello")
public class HelloWorldController {

    @GetMapping
    public String getHello(){
        return "Hello!";
    }
}
