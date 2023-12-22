
# Amado Furniture E-Commerce Spring Boot



## Authors

- [@bhupendrasambare](https://www.github.com/bhupendrasambare)


## Tech Stack

**Client:** Spring boot Thymeleaf, JavaScript, Bootstrap

**Server:** Spring Boot, Hibernate, H2 Database, Tomcat (optional)


## Run Tomcat server

Clone the project

```bash
git clone https://github.com/bhupendrasambare/amado-furniture-ecommerce-spring-boot
```

Go to the project directory

```bash
cd amado-furniture-ecommerce-spring-boot
```

Install dependencies

```bash
mvn clean install
```
Deploy the .war file to local tomcat server


## Run local server

Clone the project

```bash
git clone https://github.com/bhupendrasambare/amado-furniture-ecommerce-spring-boot
```

Go to the project directory

```bash
cd amado-furniture-ecommerce-spring-boot
```

Remove initilizer

### AmadoApplication.java
- Before
```java
public class AmadoApplication extends SpringBootServletInitializer{
```

- After
```java
public class AmadoApplication{
```

### pom.xml

- Remove dependencie
```xml
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
</dependency>
```

```bash
mvn clean install
mvn spring-boot:run
```

### Initilize data

localhost:8080/initialize
## Screenshots

#### HOME 
![Home](./images/home.png?raw=true)

### Account
![Account](./images/account.png?raw=true)

### Product
![Account](./images/product.png?raw=true)

### Register
![Account](./images/register.png?raw=true)


