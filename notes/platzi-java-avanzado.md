### Temario Java avanzado


 Servelts en JEE: framework de servidor, aplicaciones escalables y seguras.
 para correr aplcaciones web del lado del servidor se necesita
 - un SERVIDOR DE APLICACIONES como Glasfish, Jboss
 - o tambien un CONTENEDOR WEB como Tomcat (al ser mas ligero y se puede correr embebido en el codigo a traves de MVN, como el servidor apache que se puede ejecurtar dentro del codigo del modoilo de PHP)
 - Maven como gestor de paketes vendors de la aplciacion
 (no usamos servidores de aplicaciones complejos como Joss o Glasfish que permiten usar modulos de JEE, como los java beens, Tomcat es mas sencillo y permite usar las principales particularidades de JEE [tambirn lo completaremos con el framework de Spring])
 - Gradle
 - Spring framework
 - Un entorno de desarrollo con algun plugin de Spring o JEE
 *
 El war es ek formato en el que la aplicacion se compila y se deja preparada para produccion.
 Permite ser interpretada por cualquier servidor de apliciones, lpor ejemplo Tomcat, testearlo rapidamente y despues subirla a produccion o al entorno de sanity.
 *
 En el caso de aplicaciones desarrolladas con servidores ,como Jboss o Glasfih , el deployment de la aplicacion en produccion no se lleva  a cabo con el VCS Git
 (este ultimo como sistema de control de versiones distribuido, te permite deployar en produccion a trave sde hooks de Git , conectandonos por SSH a la plataforma del servidor y sincronizando del repositorio de upstream de produccion), sino a traves de Greadel y Maven.
 *
 el JDK de JEE estas compuesto de una gran cantidad de packetes para desplegar en servidores de aplcaiciones preparados para ello, tal es elm caso de Tomcatr que da soporte a una parte de la especificacion de JEE
 *
 patrones de diseño coemunes en las  plataformas de JEE + Spring:
 dispatcher servlet, udn unico purnto de entrads, que es el servlet y partar de ahi tendremos todos los controladores
 SSpring siempre instancia las clases como singletons
 *
 El objetovo de la aplicacion es crear el servicio RESTFULL y luego consumirlo con tecnologias web de cliente, lineas de comandos o plugins de cliente web como Chrome wo Firefox
 Para publicar un servicio de API web podeemos usar tecnologias comdo SOAP o REST.
 *
 AWS (amazon web serrvice) tiene un SDK para hacer deployment y desplegar las aplcaicones de microservicios en JEE.
 *
 en una aplcacion con una infraqestructura tan compleja y disgregada como JEE + Soring, muchos puntos de seguridad se de ben de soilventar, para ello existen modulos de Spring.
 *
Es tan extendido el usod e Tomcat como contenedor web que existe una version con una serie de modulos agregados qeue extienden las funcionalidades del framework de JDK de JEE

se puede trabajar tanto con el pom.xml de Maven o el.Gradle de Gradel, ambois manejadores de paquetes y sistema de inyeccion de dependencias y despliegue de tareasd como con grunt

ORM cono Hibernate se usan en aplicciones con JEE

Sistema de microservicios basados en REST: creamos el servicio REST, mapeamos los modelos (JPA y Hibernate, H2 que es una base de datos qu corre en memoria

JBE, uno de los entity manager de JPA, es uno de los modulos que aporta el framework de JEE, es necesaripo un servidor de aplcaciones, no Tomcat (caontenedor web).

uno de las layer que se debe condiderar para formar una aplicacion JEE de microservicos, es el layer de sguridad, se podrian abstraer capas de identificacion de usuarios permitidos con OAUTH

Las aplicaciones basadas en microservicios, que exponen una API empreserial, son totalmente ajeno a los clientes que consumen la aplcacios, ya sean otras aplicaciones de servidor o clientes finales, ya que solo consumen texto en formato de XML o JSON.

lo importante es tener bien claro el concepto de JEE como framework con un conjunto de API para la construccion de aplaciones de diverssas entidades que corren en una plataforma de JAVA y con un contenedor web o servidor de aplicaciones web.
- aplicaciones de microservicio basad aen REST, Web services o SOAP
- aplacaciones de presentacion.
- como se empaketan las aplicaciones JEE, mvn y gradel (WAR)
- como se descargan e inyectan las dependencias del proyecto. mvn y gragel
- contruccion de servlets para comunicar la aplcicacione web.

Soap tiene suna definicion de componente sde servicio web bien definido en documentos xml (schema de aplicaciones SOAP).
en REST se tiene una especificacion de como tratar los datos.

JJE, framework de desarrollo de aplicaciones web que expanden las funcionallidades de una aplicac ion standalone.
Maneja un servidor de aplicaciones atraves de sus multiples modulos de API y reponder al cliente.

API: aplicaction programming interface
tanto un servicio RESTFULL como una aplataforma de desarrollo como es JEE son un entorno de APIs.

JEE surgepor la aparicion de aplicaciones distribuidas, transaccionales, portables y seguras. (aplcicaiocnes standalone son muy monoliticas y de reducida infraestructura).

APIs multiples dentro del ecosistema de JEE: conexion a RDBMS, procesamoento de JSON (JSONP), contruir y proveer de servicios REST.

Criticas sobre la construccion de especificaciones de APIs: cualquier mejora de las APIs de la plataforma pasa por la aprobacion de consejo (Board) que revisan la necesidad de la plataforma por varios años y crean las especificaciones oficiales cada 4/6 años (igualmente que el upgrade de Java7-8).

Una de los beneficios de la supeditacion de un congreso que apruebe los cambios incorporados en las versiones de plataforfas de Jasva es la retrocompatibilidad entre versiones anteriores, el codigo de Java 6-7 corre en un sistema en el que esta instalado Java8, incluso aplicaciones hibridas de diferentes versiones de Java (cosa que no suele ocurrir en frameworks de clientes web).

Componentes de JEE:
 - componentes de interfaces de clientes: Applets y Widgets (muy retrogrados)
 - Java servlets, servlet pages (JSP) y servlet facelets/prime facelets (JSF): layers de presentacion, templates de cliente y componentes web varios.
 - Enterprise java beans: clases con comporttamiento especifico, componentes de negocio. Por ejemplo beans que controlan objetos de sesion que nos permiten crear una aplicacion statefull (que mantiene el estado del cliente con respecto a su sesion abierta en la aplicacion), beans entity que nos ayudan con los componentes como los JPA

Manejadores de componentes JEE
- WEB CONTAINERS: servlets (puntos de entrada de la aplicacion), componentes de web page (conexion a BBDD, seguridad...): a traves de contenedores web lightweight como Tomcat.
- EJB CONTAINERS: JAP, java enterprise beans, entity beans: a traves de servidor de aplicaciones web: Jboss, Glasfish, Weblogic Oracle server.


ARCHIVE, PACKAGING AND DEPLOYMENT
existenvarios tipo de paketes de aplicaciones empaquetadas: JAR, WAR, EAR (son archivos comprimidos)
cada uno tiene un objetivo dse deployment differente:
ARCHIVES: son archivos comprimidos (ear, war, jar) que un agente de packaging (mvn, gradle) crea para que los servidor de aplicaciones o contenedores web puedan interpretar.

EAR: enterprise archive: se crea cuando la aplicacion contiene ajava beans
WAR: web archive.
JAR: java archive: son las librerias de componentes de la aplicacion.

El web.xml es el descriptor de una aplicacion enterprise, contiene todo slos puntos de entrada de la aplicacion e instrucciones principales de deploy. Este documento se hace muy dificil mantenerlo al tiempo en el que la aplicacion escala.
Con la especificacion de Servlet3.0, el web.xml se ha sustituido por anotaciones, ahora es opcional.

El pom.xml tambien es el descriptor del deploy de la aplicacion. Es el responsable de mostrar a MVN como empaquetar el WAR.

Componentes del WAR: assembly root (raiz de compilacion del empacaje)
resources: recursos para compilar: la aplicacion
WEB-INF: web.xml (opcional), lib/ (external vendor libraries), /classes (archivos compilados para servir)
META-INF: metainformacion, no influye en la interpretacion o ejecucion de la aplicacion empaquetada, son metadatos que mvn necesita para saber como empaquetar. 


MAVEN
Maven publica las dependencias basicas necesarias para deployar sus proyectos (y las oficiales que tienen que ver con logica de negocio, como las de Spring, Jaxon...), en un repositorio centralizado: **[Cenrtal repository](http://search.maven.org/)**.

Es por ello que hay ciertas dependencias hijas, que no es necesario descargarelas ni añadirlas explicitamente al descriptor pom.xml, porque forman parte de la granja de dependencias del repositorio oficial de mvn.


mvn eclipse:eclipse se genera un proyecto en eclipce se crean los archivos( .classpath, .settings, .proyect)

las aplicaciones de presentacion funcionan hoy en dia en plataformas mas orientadas al front del cliente, frameworks como Djanjo con python, Laravel o COdeigniter con Php o Backbone, Angular, en Javascript, cumplen mejor el rendimiento de la capa de presentacion que no los moduols de Jawva bean para los servlets de presentacion en JEE, que son los JSP y JSF.

Asi que hay una tendencia a independizar la aplicacion en JEE para los microservicios o logica de negocio concreta. Y en cliente ejecutar el renderizado e interaccion de la capa de presentacion.


**API´s de JEE para la creacion de microservicios basados en REST**
- java servlets
- java API para servicios REST
- alternativa de JEE con Spring MVC.

la diferencia de crear servicios REST con JEE y SPRING
JEE: JAX-RS (anotaciones e interfaces para rest), CDI(injeccion de dependencias), JPA (creacion de objetos relacionados con Bases de datos).
SPRING MVC: mismo tipo de anotaciones pero anejas a la especificacion oficial e Java.

**Java servlets**
principal componente de cualquier framework de servicios en Java que representa una respuesta http.
Todos los frameworks se basan en facades de modelos de servlets.
Un servlet es una clase que responde al modelo de programacion request/response.
todos los servlets llevan como argumentos en cualquiera de sus interfaces dos objetos de conexion con http: **HttpServletRequest, HttpServletResponse**.
Se puede hacer una analogia de los **servlets de JEE con los middlewares de NodeJs**.
Componnetes de servlets:
- API´s: javax.servlet + javax.servlet.http
- scope objects: web context, session scope (poco relevante para una aplicacion de microservicion ya que no existe persistencia en la conexion, nos basamos en una respuesta HTTP stateless), request scope, page context.
- services method: doGet, doPost

SERIALIZACION DE OBJETOS
en la mayoria de casos en los que a traves de un microservicio recuperamos datos de un cliente, es para interactuar con algun modelo de persistencia de datos, ya sea la BBDD del sistema o su sesion.
Solemos recuperar y diseñar los datos con un modelo en JSON, comodo para la desserializacion de datos en modelos de objetos sobre los que podemos simplemente extrapolar al modelo de persistencia en cuestion.

Entonces a traves de un servlet, nuestro microservicio interactua con una llamada REST, recupera la peticion, aplica logica de negoocio sobre los datos de persistencia y obtienen un json de datos.
De ahi utilizamos librerias como Jackson que nos permiten desserializar el modelo de datos en un objeto de persistencia para el sistema (como dijimos para volcarlo en una BBDD o en un objeto de sesion).

- Jackson: deserializar json en objetos. com.fasterxml.jackson: jackson-core + jackson-databind


FILTROS
Se ejecutan antes de los Servlets.
los filtros son el preprocesamiento de las peticiones.
Son la analogia a los middlewares en NodeJs.
Al igula que cualquier Filtro de http, implementan el patron **Command Chain**, lo que permite encadenar filtros consecuentes (lo mismo que el callback de promises en los middlewares de Node).
Manipulan la peticion antes de llegar a los Servlets que routean la peticion del cliente.


CODING
- diferencias entre try(resource) y try {} catch() {}
Ambos son instrucciones diferentes y complementarias , un  try resource encapsula un recurso que se deba de limpiar en cache por parte del GC y asi manejarlo mas eficientemente (como una conexion o Statement a BBDD o un Buffer de entrada o salida)
Por otro lado un try catch sirve para el manejo de excepciones que puedan saltar en tiempo de ejecucion y asi capturarlas y tratarlas.

- diferencias entre verbos HTTP que se utilizan en los Servlets
GET: se recuperan parametros de la url, y se construye la respuesta para devolver informacion que se persiste en el sistema
POST: se envia informacion en la cabecera HTTP (en formato json, en el http body) y se utiliza para crear nuevas instancias en el sistema
PATCH: a diferencia que POST en el que recuperas todo en el resoursO, en el body del http, con este estado http te centras en segmentos especificos del recurso, al igual que POST se utiliza para crear nuevas instancias.
PUT: mismo que POST pero para manipular datos de una instancia.
