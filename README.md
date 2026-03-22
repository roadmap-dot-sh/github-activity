# GitHub User Activity

Use GitHub API to fetch user activity and display it in the terminal.

Project
URL: <a href="https://roadmap.sh/projects/github-user-activity">https://roadmap.sh/projects/github-user-activity</a>

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