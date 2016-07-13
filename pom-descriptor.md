### DECLARACIONES DEL pom.xml
EL pom.xml es el descriptor de la aplicacion web, sirve al builder manager (mvn) para crear la aplicacion empaquetada, el web archive (.war). Este archivo comprimido lo interpreta el servidor de aplicaciones de Java (Tomcat) para ejecutar la aplicacion

**```<project>```: Descripcion del proyecto**
- ```<modelVersion>```: version del xml que el schema interpreta.
- ```<groupId>```: namespace del projecto, recurso de la api publicada, se usa en la injeccion de dependencia.
- ```<artifactid>```: nombre del projecto, se usa en la injeccion de dependencia.
- ```<version>```: version de la aplicacion.
- ```<packaging>```: modelo de aplicaion empaquetada, en que se contrujye el build.
- ```<name>```: ${project.artifactId}: nombre del modulo empaquetado
- ```<build>```: nodo que se refiere al build (pauete) que mvn va a construir.
- ```build > filename```: ${project.artifactId}: nombre del war
- ```<plugin>```:



**```<plugins>```: Dependencias de builder**
  - *tomcat7-maven*: compilar + empaquetar + correr un tomcat embebido en mvn, para poder ejecutar la aplicacion.

  - *maven-war*: modulo que permite empaquetar la aplicacion como un web archive, by defauilt hace un .jar.
    Tiene un nodo de configuracion ```<failOnMissingWebXml>``` old proyect descriptor, trigger the possibility to create a web.xml, now replaced by pom.xml.

  - *maven-compiler*: compiler to create the war build.


**```<dependencies>```: Dependencias de desarrollo**
  - ```<artifactId>```: nombre de la dependencia
  - *javaee-api*: dependencia del ecosistema de API´s en el JEE. Como sabemos que es una dependencia que va a estar en el aplication server (framework de JEE), la declaramos con un ```<scope>provided</scope>```, asi mvn no la importara, solo la tendra como referencia.

-----

**Maven tiene una configuracion basada en herencia**
Algunos nodos del pom.xml se heredan del proyecto padre, la configuracion y dependencias de este se toman como modelo y se cargan por defecto en el proyecto actual.
El proyecto padre se define a traves de los nodos ```<artifactId>, <groupId>, <version>, <relativePath>```.

