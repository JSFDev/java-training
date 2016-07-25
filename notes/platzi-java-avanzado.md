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
Se utilizan para unificar condiciones a setear para configuracion de servlets
**un filtro > multiples servlets**

CODING
- diferencias entre try(resource) y try {} catch() {}
Ambos son instrucciones diferentes y complementarias , un  try resource encapsula un recurso que se deba de limpiar en cache por parte del GC y asi manejarlo mas eficientemente (como una conexion o Statement a BBDD o un Buffer de entrada o salida)
Por otro lado un try catch sirve para el manejo de excepciones que puedan saltar en tiempo de ejecucion y asi capturarlas y tratarlas.

- diferencias entre verbos HTTP que se utilizan en los Servlets
GET: se recuperan parametros de la url, y se construye la respuesta para devolver informacion que se persiste en el sistema
POST: se envia informacion en la cabecera HTTP (en formato json, en el http body) y se utiliza para crear nuevas instancias en el sistema
PATCH: a diferencia que POST en el que recuperas todo en el resoursO, en el body del http, con este estado http te centras en segmentos especificos del recurso, al igual que POST se utiliza para crear nuevas instancias.
PUT: mismo que POST pero para manipular datos de una instancia.


Tomcat, Jety, Jboss, Glasfish
**sistemas de seguridad de un web service o un Rest service**
- si estas accediendo a datos sensibles del usuario, que el manipula durante su session y persiste en el sistema: **implementar servicio Oauth2**, creas un token de iodentificacion del usuario que se verifica en un servidor externo.
- Si accede a datos publicos del sistema: **API keys** (identificador del usuario para la api), **Throttling** es un limitador de conexiones o peticiones a la Api.

Hibernate: Orm mas popular de conexion a BBDD
Spring framework + Spring MVC.

ventajas de SOAP: auditorias de seguridad, definicion de servicio
ventajas de REST: flexibilidad, escalable y autodocumentado.

CDI= Context Dependency Injection.

RESTFULL API
- teoria de servicio: manejar servicios en una arquitecture cliente-servidor, consumo de datos.
- condiciones, reglas en un servicio REST:
  - **recursos identificados por una URI**: en el caso proveer un servicio web, el identificador de recurso es una URL.
  - **Manipulacion de recursos a traves de representaciones**: un servicio REST perite escojer diferentes representaciones de un mismo recurso (lo podemos devolver en XML, JSON...).
  - **Servicio Autodescriptivo**: Al basarse en un protocolo HTTP, se utilizan los metadatos de la peticion, para definir el estado de del servicio. Son el header y el body de la response y request (metadatos) quienes describen y configuran el servicio.
  - **HATEOAS - Hipermedia As The Engine Of Application State**: los datosq  que maneja a la peticion en el servicio del  recurso (request, response) son los que documentan el servicio.

DETRACCION DE RESTFULL
Hacer una peticion a un recurso que devuelve un conjunto de datos en un formato JSON o XML. NO es un servicio REST hasta que cumpla con las premisas anteriores:
- Identificacion por una URI
- Metadatos de definicion
- Representacion de Objetos
- HATEOAS

ACLARACIONES DE UN SERVICIO REST
- REST sirve recursos, en formato de consumo de datos: xml, json.
- **La URI debe indicar el recurso del servicio**, NO como se accede al recurso.
- No se deberia usar verbos en la URI
- Mal ejemplos
  - /adduser
  - /delete/user
  - /user/delete/morgan
- Buenos ejemplos
  - /user/morgan -GET -DELETE (el estado del request, verbos http, nos describen la accion del servicio REST)
  - /user -POST (create new user by data from request body)
  - /user -PUT (update user with data from request body)
  - /user/morgan/courses -GET (obtain especific resource)
  - /user/morgan/courses/java -GET
  - - /user/morgan/courses/java?skill=backend -GET
- **Codigos http**: sirven como descripcion del servicio en la response.
  - 2xx: success
  - 3xx: redireccion
  - 4xx: error del cliente. Por no existir la uri del resurso solicitada, o no son correctos los parametros o el formato de la peticion.
  - 5xx: Error del servidor. El servicio esta mal contruido. Error garrafal.
- Buen ejemplo de servicio REST: [Github public REST Api](https://developer.github.com/v3/)
- Es correcto utilizar parametros en la peticion para especiicar el recurso, por sulogica o como filtro.


DESIGN PATTERN : DEPENDENCY INJECTION
Tambien llamado **inversion de control**
Se basa en como se manejen las dependencias dentro de una clase.
NVN es el encargado de injecar las dependencias en el WAR.
Nos permite ser agnosticos, junto a los Wizards del IDE.

Ejemplo dInjeccion Legacy o Vanilla:
Se trata de tener un componente (instancia o dependencia, como propiedad de clase o instancia), que se pueda setear a traves de un metodo publico.
De manera que desde fuera de la clase, a traves de la instancia, se pueda cambiar el comportamiento de esta dependencia.
Al ser esta dependencia mutable, suele ser de tipo de la interfaz que heredan la clases que otorgan su comportamiento (es decir las que se setean):
```java
class HappyMessage implements Message {}
class SadMessage implements Message {}
class Status {
  private Message message = new HappyMessage();
  public setMessage(Message message) {
    this.message = message;
  }
}

public static void main(String[] args){
  Status myStaus = new Status();
  myStatus.setMessage(new SadMessage());
}
```

DESIGN PATTER: FACTORY
Se crea una clase que implementa factorias, estas factorias se encargan de manipular el comportamiento de  la dependencia (configuracion de objetos determinada).
Era complicada porque se creaba un singleton encargado de mutar la dependencia a traves de la implementacion de las diferentes interfaces.

SPRINTG CONTEXT
se trata de layer de mas bajo nivel de Spring, incluje el Context, Core, Beans
El @Component es un modulo basico en Spring que se encarga de la injeccion de dependencias, los @Bean representan instancias a modo de singletons que exponen metodos esepecificos dentro de la clase contexto.
Estos metodos lo que hacen por detras en manejar un singleton de esa dependencia, de modo que dependiendo del bean que le indiquemos nos dan un comportamiento de esta dependencia (una instancia diferente), por lo tanto se apica un patron Factory.

SPRING CORE
Spring nacio como framework que solucionaba CDI (Component dependency injection, ahora en su version de @Component), y se especializo en la POA (programacion orientada a Aspectos).

MODULOS DE SPRNING
- CDI
- POA
- abstraccion de modulos de JEE: REST, MVC, Servlets, Filters
- des/serializacion de Objetos en servicios RESTFULL

PATRON DE DISEÑO FRONTCONTROLLER
se trata de un modulo de Spring MVC, que hereda la funcionalidad del DispatcherServlet.
El DispatcherServlet es un unico Servlet de aplicacion que se encarga de conectar el Front de la aplicacion.

FrontController: Router que parsea la URL, filtra o preprocesa la URL.

SPRNGBOOT
Es una abstraccion de los modulos de Spring


REPOSITORIO DE MAVEN
se especifica con la variable de entorno M2_HOME"
Es donde se alojan localmente las dependencias que consume MVN en cada aplicacion demtro del equipo donde se aloja la aplicacion.

WIRING
Es como es denomina al proceso de injeccion de dependencias.
Una clase @Component es la que se encarga de instanciar la dependencia a traves de esta anotacion.
la dependencia se injecta a traves de una clase @Configuration que declara una serie de factorias de esta dependencia (con diferente configuracion).

La manera en la que un @Component injecta dependencias a traves de la factoria @Configuration, es a traves de @Autoweired.
De esta manera buscara la factoria anotawda con @ComponentScan que exponga dependencias con la instancia que este buscando injectar.

ANOTACIONES PARA CLASES DE CDI
@Component: mas sencilla, objetos
@Controller
@Repository: objetos de persistencia
@Service:
@ClassPathBeenDefinitionScanner

Definicion de @Ban
En cualquier entorno un Bean es una instancia de un Objecto.
en Spring, para el CDI, el componente encargado de injectar el Bean, sera el encargado de definir el tipo (dependiendo de la anotacion para CDI).
un Pojo es un Bean con la configuracion de un Objeto simple.
Un Entity es un Bean con la representacion de un objeto que persiste en BBDD (son los JPA de JEE).

Los EJB (Enterprise java beans) se refiere a esto mismo, un Bean, un objeto, con una configuracion de propiedades especificas.

JAVA8, nuevas interfaces y paradigmas.
- Lambdas expresions: funcioners como argumentos, codigo como datos. Se utiliza para simplifoicar implementaciones de interfaces de un solo metodo abstracto
- mejora de programacion funcional: paradigma diferenciado de la POO en la que las funciones son el principal protagoinista y actuan como datos,. Se anidan las funciones, devolver valores a traves de la llamada entre funciones.
- Streams: Critica malas a java: es verboso (demasiado complejo para crear ciertos datos , por ejemplo un array), ahora se pueden encadenar streams de datos.
Los Streams son una secuencia de operaciones de agregacion sobre una fuente.
En los Streams una vez que los hemos usado como pipe, tenemos dos objetos de tipo Stream:
Streams que nos devuelven objetos finales: cierran el stream: stream().collect([object catched]).
Streams que nos devuelven objetos intermediarios: devuelve otro stream para anidar otro pipe: stream().filter([iterator or lambda]).
- Date Api.
- Optional: es un Tipo de Objeto que permite recumerar cualquier tipo de instancia y devolver null en caso de que no se pueda recuperar o crear. Es un wrap al tipico NullpointerException y se aplica en los objetos que devuelven algunas interfaces de la Api de SpringBoot. Se recupera el valor con .get().

PREGUNTAS
- JpaRepository de Spring es:

- La anotación @GeneratedValue de JPA sirve para:


- ¿Qué es el ResponseEntity de Spring MVC?

PROGRAMACION BASADA EN PRUEBAS
- pruebas unitarias, de integracion, funcionales.
- las pruebas unitarias testean el comportamiento dentro de una clase. Puede darse el caso de que este integrado por un metodo en concreto, o que se combinen varios metodos para definir la funcionalidad de una clase.
- Probar la Unidad: Debemos **aislar** las dependencias, metodos y propiuedades de nuerstra clase, que puedan testear un  comportamiento aislado de nuestra clase.
- MOckito permite aislar una instancia onfigurada por un comportamiento descrito por nuestra implementacion.