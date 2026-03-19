# Github User Activity

project
url: <a href="https://roadmap.sh/projects/github-user-activity">https://roadmap.sh/projects/github-user-activity</a>

## Run application

1. Clone repository

```
git clone https://github.com/roadmap-dot-sh/github-activity.git
cd github-activity
```

2. Start to run

```
mvn spring-boot:run -Dspring-boot.run.arguments=<username>
```

or build and run with .jar file

``` 
mvn clean package 
```

Output: `target/github-activity-0.0.1-SNAPSHOT.jar`

```
java -jar target/github-activity-0.0.1-SNAPSHOT.jar <username>
```