# Ecommerce Backend API
### Tools and Versions
* Eclipse IDE for Enterprise Java and Web Developers - 2024-06
* Oracle SQL Developer 23.1.1
* Oracle Database 19C
* Java 17
* Spring Boot 3.2.10-SNAPSHOT
* Swagger UI 3.x
### Dependencies
* Oracle Driver
* Spring Web
* Spring Data JPA
* SpringDoc WebMVC UI
### Instruction
1. Clone the repository.
2. In pom.xml, you need to check following dependencies are included. If not, you need to add dependency in pom.xml.
   ```
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
   ```
   ```
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```
   ```
   <dependency>
       <groupId>com.oracle.database.jdbc</groupId>
       <artifactId>ojdbc11</artifactId>
       <scope>runtime</scope>
   </dependency>
   ```
   ```
   <dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
       <version>2.6.0</version>
   </dependency>
   ```
3. We must configure the datasource via ORM tool To connect to the database. <br>
   For Oracle database, following respective properties are used. <br>
   ![image](https://github.com/user-attachments/assets/0ddd722b-4754-4f1e-b078-97fee8bee554)
4. Right Click the following class file. (src\main\java\com\EcommerceBackendAPI\EcommerceBackendApiApplication.java)<br>
   ![image](https://github.com/user-attachments/assets/b4b2aa7d-e899-4a14-bd1d-37d75fbf18fd)
5. Choose Run As and Java Application for running the backend API.<br>
   ![image](https://github.com/user-attachments/assets/45dbed17-71cb-4ca0-ba65-663e86383091)
6. It will run as Java Application and if the following is displayed in Console, the backend API is successfully run with no errors and can start to test the Backend API.<br>
   ![image](https://github.com/user-attachments/assets/f1f55507-43d6-423b-a900-a40a4c588811)

