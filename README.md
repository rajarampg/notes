#A Simple Notes application API

##Here's a simple and elegant notes application API designed using Spring boot 2.2.2

#### Pre-requisites 
1. Install Java 8 or above
2. Install MySQL community edition 
3. Install any IDE- preferably Eclipse.
4. Install Maven
5. Install Lombok jar into IDE working directory
6. Have an application server installed- preferably Tomcat 8.

#### Update the application.properties file under src/main/resource with valid credentials
1. Update the source scanner parameter
2. Update the MySQL connection URL.

#### Running the application
1. From the application directory run the project -> mvn clean install
2. In the target folder, the runtime war is generated. Copy the war and install in your application server. 
3. Deploy the war in the server. You should be able to access the application from <http://your.ipaddress:8080/notesapp/api/****>
4. MySQL commands are available in schema.sql file. Run the script from command line.
5. Swagger documents provides the details about each API call- <http://your.ipaddress:8080/notesapp/swagger-ui.html>
 

