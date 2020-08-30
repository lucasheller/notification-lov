**NOTIFICATION API**

##Project
The project has the objective to manage notifications and notificate the users from lov platform 

## Lombok
We use the lombok lib in notification-lov, you must install the lombok plugin and activate the annotation processor

[How to install lombok plugin Intellij](https://projectlombok.org/setup/intellij)

##Running the project
To run the project you must have an instance of a MySQL DB. You can run the MySQL Container from this docker image:

```
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=notification mysql:8.0.20
```