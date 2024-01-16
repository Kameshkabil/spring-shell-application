package com.example.springshellapplication.spring_shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestTemplate;

@ShellComponent
public class SpringShellCommand {

    @Autowired
    RestTemplate restTemplate;

    @ShellMethod(key = "getTrendingPost",value = "i will get trending post")
    public String getTrendingPost(){
        String url = "http://localhost:8080/api/trends";

        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        return "Response From Spring-Webs: "+response.getBody();
    }

    @ShellMethod(key = "getAllPosts", value = "i will get all posts")
    public String getAllPosts(){
        String getAllPostsURL = "http://localhost:8080/api/all/posts";
        return "Response From Spring-Webs: "+restTemplate.getForEntity(getAllPostsURL,String.class).getBody();
    }

}
