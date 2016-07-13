### Temario Java basico

 - herencia sencilla de un solo padre
 - identificar los casos de  herencia:
> Observar varias instancias de nuestro sistema cuyas clases proveen las mismas prorpiedades
> Taxi, Turismo y Deportivo Heredan de Vehiculo (TODOS los atributos y metodos compartidos, NO como prototipo de JS)
>
> En la herencia tenemos una relacion de SubClase (Hija) y SuperClase (Padre)
> Hay restriccion de los modificadores de acceso en la Herencia: protected
> Polimorfismo: Cuando una propiedad heredada de un Superclase tiene diferente implementacion

 - Sobrecarga de metodos:

 - Multithread, java es multihilo,
 > se puede aislar un proceso en concreto del sistema en un hilo virtual de ejecucion.
 > por lo tanto Java permite lanzar diferentes procesos en un mismo sistema, en diferentes hilos de ejecucion al mismo tiempo

 - Threads : Hilos de ejecucion
 > Analogia con la programacion asincrona en diferente hilo de ejecucion
 >
 > Se utiliza en momentos de alto estres de software
 > pero no hay que abusar porque pueden exister serios problemmas de complejidad de manejo de multithread por parte de la plataforma que ejecuta el programa

- Casos de uso de Threads:
 > descarga de imagenes en el clientes

- Threading: crear multiples threads en el programa, multiples LINEAS DE FLUJO DE CONTROL
 > complejidad: colision de Hilios

- ESTADOS: BORN + RUNNABLE (yield) + WAIT (no runnable) / DEAD

 se pueden crear threads, uno para cada clase, heredandola de Thread o implementando Runnable.
 Se encapsula en el metodo @Override run() (polimorfismo) la implementacion asincrona.
 Esta clase hahora hereda o implementa el comportamiento de un thred
 Se crea una variable de tipao thread que se instancia con un constructor de la clase objetivo
 Se lanza con start(), el fragmento de codigo encapsuladmo en el metodo run()

 como buena practica y para evitar colision de procesos y rotura del sistema, debemos CALENDARIZAR LOS HILOS , esto es hacer un diagrama de los hilos que se ejecutan y asignarles una prioridad eslpecifica.

 En java la escritura y lecturad de datos se lleva a traves de streams o flujos de datos
 tenemos una clasificacion de stremsas dependienod el tipo de de datos que estamos accesando:
 - Bytes : InputStream (lectura) / OutputStreams (escritura)
 - Caracteres: Reader (lectura) / Writer (escritura)

 **Clases que permiten leer / escribir de datos de un programa:**
 BYTES
      - ByteArray[Input|Output]Stream (byten en memoria), FIle[Input|Output]Stream (datos de un archivo), Piped[Input|Output]Stream (lectura de datos dentro del programa, usualmente un trhread).
      - Buffered[Input|Output]Stream (varios bytes a la vez), Data[Input|Output]Stream (datos Primitivos), Object[Input|Output]Stream (Objetos), PushBackInputStream (agregar datos de entada), SequenceInputStream (Concatena dos o mas flujos para tratarlos en uno mismo, PrintStream (escribir datos primitiovos y cadenas de flujo de salida)

 CARACTERES
      - CharArray[Reader|Writer] (arreglos de caracteres en memoria), File[Reader|Writer] (archivos), Pipe[Reader|Writer] (caracteres en un thread), String[Reader|Writer] (strings).
      - Buffered[Reader|Writer] (mas de un caracter a la vez), LineNumberReader (mas complejo que el BufferedReader, seguimiento de lineas, acceder a lineas esdpecificas...), PushBackReader (agregar datos adicionales al flujo de entrada), PrintWriter (escribir datos primitiovos y cadenas de flujo de salida)

 Conversion BYTE / CARACTER
      - InputStreamReader (leer caracteres de un flujo de bytes), OutputStreamReader (escribir caracteres en un flujo de bytes)


 **Conexion de bases de datos JDBC**
**Java.sql**: conjunto de clases del jdk para trabajar con bases de datos: oracle, mysql, sql-server
en la maquina donde se aloja el motor de base de datos es necesario instalar el driver para la conexion del programa
clases de java.sql:
  > **DriverManager**: cargar el driver de conexion
  > **Connection**: establecer conexion
  > **Statement**: ejecutar sql
  > **ResultSet**: almacenar datos de consulta

Necesitamos construir un diagrama entidad-relacion, en donde se establecen la cardinalidad entre las entidades de nuestro sistema.