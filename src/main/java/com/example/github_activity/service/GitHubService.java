/*
 * GitHubService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.github_activity.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * GitHubService.java
 *
 * @author Nguyen
 */
@Service
public class GitHubService {
    private static final String API_URL = "https://api.github.com/users/%s/events";

    public List<String> getUserActivity(String username) throws Exception {
        String urlStr = String.format(API_URL, username);
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int status = conn.getResponseCode();

        if (status == 404) {
            throw new RuntimeException("User not found!");
        }

        if (status != 200) {
            throw new RuntimeException("GitHub API error: " + status);
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        return parseEvents(response.toString());
    }

    private List<String> parseEvents(String json) {
        List<String> results = new ArrayList<>();

        // split từng event (simple approach)
        String[] events = json.split("\\},\\{");

        for (String event : events) {
            if (event.contains("\"type\":\"PushEvent\"")) {
                int commitCount = countOccurrences(event, "\"sha\"");
                String repo = extractRepo(event);
                results.add("- Pushed " + commitCount + " commits to " + repo);
            } else if (event.contains("\"type\":\"IssuesEvent\"")) {
                String repo = extractRepo(event);
                results.add("- Opened an issue in " + repo);
            } else if (event.contains("\"type\":\"WatchEvent\"")) {
                String repo = extractRepo(event);
                results.add("- Starred " + repo);
            }
        }

        return results;
    }

    private int countOccurrences(String str, String sub) {
        return str.split(sub, -1).length - 1;
    }

    private String extractRepo(String event) {
        try {
            int start = event.indexOf("\"name\":\"") + 8;
            int end = event.indexOf("\"", start);
            return event.substring(start, end);
        } catch (Exception e) {
            return "unknown repo";
        }
    }
}
