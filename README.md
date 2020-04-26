# Trav Race App:

### Download the source code and cd into the project directory from your command line.

## Build application localy:

### for this application to work you need localy installed:

- *MongoDb version v4.2.3 (running localy) or later*

- *Java java 11.0.6 or later*

- *Apache Maven 3.3.9 or later*


### run this commands:

- *mvn compile*

### This is just to verify everything is compiling correctly in your env.

- *mvn package*

### This command will create a .jar file to start the application.



### From the same directory you are standing run now this command:

- *java -jar target/travrace-0.0.1.jar*

## The application should be up and running

### Verify app is working:

query() your mongoDB instance for "eventdata" collection to check that events been persisted, 
and follow the logs accros the polling job in the command line.
