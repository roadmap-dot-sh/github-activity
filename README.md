# GitHub User Activity

Use GitHub API to fetch user activity and display it in the terminal.

Project
URL: <a href="https://roadmap.sh/projects/github-user-activity">https://roadmap.sh/projects/github-user-activity</a>

## Requirements

The application should run from the command line, accept the GitHub username as an argument, fetch the user's recent
activity using the GitHub API, and display it in the terminal. The user should be able to:

- Provide the GitHub username as an argument when running the CLI.

    ```shell
    github-activity <username>
    ```
- Fetch the recent activity of the specified GitHub user using the GitHub API. You can use the following endpoint to
  fetch the user's activity:

    ```text
    # https://api.github.com/users/<username>/events
    # Example: https://api.github.com/users/kamranahmedse/events
    ```

- Display the fetched activity in the terminal.

    ```text
    Output:
    - Pushed 3 commits to kamranahmedse/developer-roadmap
    - Opened a new issue in kamranahmedse/developer-roadmap
    - Starred kamranahmedse/developer-roadmap
    - ...
    ```
  You can <a href="https://docs.github.com/en/rest/activity/events?apiVersion=2022-11-28">learn more about the GitHub
  API here</a>.

- Handle errors gracefully, such as invalid usernames or API failures.
- Use a programming language of your choice to build this project.
- Do not use any external libraries or frameworks to fetch the GitHub activity.

## Run application

Open terminal and type these following commands to run application

##### 1. Clone repository and change to project directory

```shell
git clone https://github.com/roadmap-dot-sh/github-activity.git
cd github-activity
```

##### 2. Run application

Use `mvn` to run:

```shell
mvn spring-boot:run -Dspring-boot.run.arguments=<username>
```

or build `.jar` file

```shell
mvn clean package 
```

Output: `target/github-activity-0.0.1-SNAPSHOT.jar`

and run:

```shell
java -jar target/github-activity-0.0.1-SNAPSHOT.jar <username>
```