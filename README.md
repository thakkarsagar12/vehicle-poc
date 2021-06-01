

# Things which can be improved
* Can add build stage on docker file (need some more time)
* Can utilise [Spring Native](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/) for fast boot of spring application which can help to scale application faster.
* [We can go for Project Reactive in spring](https://spring.io/reactive)
* [Utilise R2DBC with Reactive Stack](https://spring.io/projects/spring-data-r2dbc) 

# Note to be taken
* Spring boot application is stateless so have not provided any volume to it.
* Basic controller with requested functionality.
* created Docker file with build functionality so no need to add any dependency on host machine like java.
    * So just install docker and docker-compose according to machine os and
    in code directory `docker-compose up` will initiate the whole code.
  