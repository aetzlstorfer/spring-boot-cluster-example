# Explanation
This spring boot example application is used being deployed on several tomcat nodes to form a cluster delivered through docker containers.

# Basic Architectural overview
* **Thymeleaf** is used as the rendering engine for the web.
* **JPA** is used as the main data layer.
* **Spring-Security** is used to secure the application.
* **Spring-Session** is used to replicate the session over the cluster nodes on a redis server.
* **Lombok** is used for all kind of data objects to reduce noise in the source code.
