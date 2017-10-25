# hibernetmvc
A small and unassuming CRUD application (aka bookstore)

The username & password to access db are 'root' (in both cases)
and can be changed by editing src/main/resources/<b>db.properties</b>

To populate the database you may want to run the script:
<b>script.sql</b>

To run the application you can follow these steps,
<i>assuming that you are in the application directory</i>
(the paths should be adjusted to correspond your system):

1. mvn clean install
2. sudo rm -rf /opt/apache-tomcat-8.5.23/webapps/hibernet-mvc-1.0-SNAPSHOT
3. sudo rm -rf /opt/apache-tomcat-8.5.23/webapps/hibernet-mvc-1.0-SNAPSHOT.war
4. sudo cp ./target/hibernet-mvc-1.0-SNAPSHOT.war /opt/apache-tomcat-8.5.23/webapps/
5. sudo /opt/apache-tomcat-8.5.23/bin/startup.sh
6. In your browser use the path: http://localhost:8080/hibernet-mvc-1.0-SNAPSHOT/

To shutdown Tomcat you may use (the actual path depends on your system): sudo /opt/apache-tomcat-8.5.23/bin/shutdown.sh
