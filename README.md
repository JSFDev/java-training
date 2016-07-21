# Training Java practices

- [Install JDK 8u91 (packages and resources) including JRE (virtual machine, sandbox to compile code)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Download Java Enterprise SDK](http://www.oracle.com/technetwork/java/javaee/downloads/index.html).
- [Install Maven build management system](https://maven.apache.org/download.cgi).
- Update user or system environment variables
```bash
# /etc/environment
# ~/.bashrc
MAVEN_3=/opt/apache-maven-3.3.9
export MAVEN=$MAVEN_3
GLASSFISH_EE=/opt/glassfish4
export JAVA_EE=$GLASSFISH_EE
JAVA_8=/usr/jdk/jdk1.8.0_91
export JAVA_HOME=$JAVA_8
export PATH="$PATH:$JAVA_HOME/bi:$MAVEN/bin:$JAVA_EE/bin"
export ROOT_USER_MYSQL=***
export ROOT_PASS_MYSQL=*****
# $source /etc/environment
```
- import maven dependencies onto target project
```bash
$mvn clean install
```
- execute web archive from **tomcat embebd plugin**
```bash
$mvn[Debug] tomcat7:run
```
- execute web archive from **spring boot tomcat module**
```bash
$java -jar ./target/java-training.war
```

- Open Remote debug code into port: 8000
- Run Tomcat: **http://localhost:9191[/java-training]**
- Routes to services:
  - /java-training/user?name&surname&email&borndate -GET
  - /user -GET -POST
  - /instructors/test

- Run standalone Tests: **src.test.com.**.MainTest**