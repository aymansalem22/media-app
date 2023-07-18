# media-app
Media playlist application

 build a simple media playlist application that has the following features:

   - A basic web UI using jQuery and Bootstrap
     
   - REST APIs to perform the following:
        create a playlist
        add a song to a playlist
        fetch information about the playlist
        fetch all the songs in a playlist
        delete a song from a playlist
        move a song from one playlist to another
        delete a playlist
     
   - Uses an in-memory H2 database to persist information
     
   - Uses Swagger for API documentation


  Libraries and their versions

    - Spring Web

        org.springframework.boot:spring-boot-starter-web – This is the base dependency for creating REST and web applications.

        org.springframework.boot:spring-boot-starter-thymeleaf – This is for templating the server-side HTML response. 

    - Persistence
        org.springframework.boot:spring-boot-starter-data-jpa
        com.h2database:h2 – As we are going to use the H2 database for persisting our data, we use this library. 

    - Swagger

    Swagger is a REST API documentation library. For integrating the same with the application we are going to build, we need the following dependencies:
        io.springfox:springfox-spring-webmvc:2.10.5
        io.springfox:springfox-swagger2:2.10.5
        io.springfox:springfox-swagger-ui:2.10.5

    

    - Development Tools

        org.projectlombok:lombok – for generating getter, setters, toString, hashcode, equals, and constructors for Java classes.

        org.springframework.boot:spring-boot-devtools – for live reload and hot-swapping of the application; as we change the code, we need this dependency.

     - Server
        org.springframework.boot:spring-boot-starter-tomcat – our application is going to run inside a tomcat web server.

     - Utilities
        com.google.guava:guava:29.0-jre – contains various utility methods for creating and manipulating Java collections and many more.
