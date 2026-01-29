package edu.icet.controller;

import edu.icet.dto.ToDO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequiredArgsConstructor
public class TodoController {

    private  final RestTemplate restTemplate;

    @GetMapping("/get-todo/{id}")
    public ToDO getTodo(@PathVariable Integer id){
        String url = "https://jsonplaceholder.typicode.com/todos/"+id;

        ToDO forObject = restTemplate.getForObject(url, ToDO.class);

        return forObject;
    }

    @GetMapping("/get-todos")
    public ToDO[] getTodo(){
        String url = "https://jsonplaceholder.typicode.com/todos";

        ToDO[] forObject = restTemplate.getForObject(url, ToDO[].class);

        return forObject;
    }
}
