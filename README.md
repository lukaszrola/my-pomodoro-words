# my-pomodoro-words
Application is intrinsic part of **`my-pomodoro-cllient`** (https://github.com/lukaszrola/my-pomodoro-client).
It's purpose is to provide questions related with foreign language words.<br><br>

**Currently three endpoints are supported**:<br>

Endpoint | Type of question
--- | ---
/motherLanguageChoiceQuestions?numberOfQuestions=`N` | Returns `N` choice questions. You have to choose correct translation in your mother language.
/foreignLanguageChoiceQuestions?numberOfQuestions=`N` | Returns `N` choice questions. You have to choose correct translation in foreign language.
/writingQuestions?numberOfQuestions=`N` | Returns `N` writing questions. You have to write correct translation un foreign language.

##Application available on Heroku
Newest version of application is deployed on heroku:
* https://my-pomodoro-words.herokuapp.com/

##Run application in IntelliJ
Application can be imported to IntelliJ as a gradle project and run as SpringBoot application.
Component is using `PostgreSQL` as a data storage and need it to correct work.

There is need to provide following
properties:
* spring.datasource.url
* spring.datasource.username
* spring.datasource.password

They could be applied in application.properties or as environment variables. 

##Build and run application as a docker container
Execute following commands
1. `gradlew bootJar`
2. `gradlew docker`
3. Run container with id of build image + expose port 8080

## Run complete application with docker-compose
There is possibility to run application from images published in docker hub.

1. checkout repository https://github.com/lukaszrola/my-pomodoro-docker-configuration
2. Execute: `docker-compose up`
