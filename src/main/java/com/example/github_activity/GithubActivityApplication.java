package com.example.github_activity;

import com.example.github_activity.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GithubActivityApplication implements CommandLineRunner {

    @Autowired
    private GitHubService gitHubService;

    public static void main(String[] args) {
        SpringApplication.run(GithubActivityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: github-activity <username>");
            return;
        }

        String username = args[0];

        try {
            List<String> activities = gitHubService.getUserActivity(username);
            activities.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
