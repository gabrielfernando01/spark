# Como arrancar el Driver de Spark en IntelliJ IDEA.

***
La intención de este documento es crear nuestro **primer proyecto desde cero** para ejecutar el Driver de Spark en formato standalone(local) desde IntelliJ apoyandose en herramienta de construcción de Java Apache Maven.
***

Abrimos el IDE IntelliJ IDEA, en mi caso tengo la versión 2022, aunque puedes usar versiones anteriores para realizar este ejercicio.

Al abrirlo encontrarás una ventana similar a la siguiente, puede variar dependiendo de la version que hayas instalado.

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/plugins.png)

Para este primer proyecto <code>HelloScala</code> necesitas tener instalado el plugin <code>Scala</code> y <code>Maven</code>, aunque dependiendo de tus necesidades en un futuro tendrás que instalar otros.

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/plugin_maven.png)

Ahora damos click en Projects enseguida a <code>New Proyect</code>:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/new_project.png)

Nos abrira una ventana de configuaración, aqui es importante empezar a comentar que es un fichero <code>pom.xml</code>, de manera simplista podemos decir que es una plantilla que tendrá las configuraciones, dependencias, librerias de nuestro proyecto, y dado que el fichero que se encuentra en esta carpeta trae la version <code>scala 2.11</code> en el nuestro _pom.xml_ esa es la que tenemos que elegir, aunque si cambias el <code>pom.xml</code> basta con cambiarlo esta ventana de configuración, también es importante que en la barra desplegable JDK, uses precisamente una que contenga el JDK, en mi caso tengo descargada el openJDK-18 aunque te servirá cualquiera otra version JDK:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/configuration_hello.png)

La ventana que tiene que aparecer debe ser la siguiente, a continuación damos click derecho sobre el proyecto <code>HelloScala</code> en la parte superior izquierda, en el panel de los ficheros de nuestro proyecto:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/pantalla_inicial.png)

Y elegimios la opsción <code>Add Framework Support...</code> lo cual desplegara la siguiente ventana donde activaremos el check de <code>Maven</code>, debes saber que este paso es que habilita el servidor, dado que la arquitectura de Apache Spark cuando deje de funcionar en nuestra maquina <code>local</code> pasará a vivir en un cluster.

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/add_framework.png)

Y lo anterior te genera una fichero <code>pomp.xml</code> y varios directorios en el panel de la izquierda:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/pompt.png)

En esta carpeta de GitHub te comparto el fichero [pomp.xml](https://github.com/gabrielfernando01/scala/blob/main/Ingestas/Hello_Spark/pom.xml) el cual genera las dependencias a nuestro proyecto con Apache Spark, y como comente anteriormente señala la version de Scala que se esta ocupando <code>scala 2.11</code>.

Copiamos dicho fichero que te comparto dentro del fichero <code>pomp.xml</code> de nuestro proyecto <code>HelloScala</code> y ejecutamos los cambios dando click en el siguiente icono:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/new_pomp.png)

Y si hasta ahora todo lo hemos hecho bien deberás obtener varias librerias externas como se muestra en seguida:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/external.png)

## Marcar el directorio main como «Source Root».

Para este proyecto no será necesario agregar más configuraciones al fichero <code>pom.xml</code> aunque es importante saber para tus futuros proyectos. Que si quieres crear dependencias con otras aplicaciones como: <code>Kubernetes</code>, <code>Docker</code>, <code>Cassandra</code>, etc. Estas son muy sencillas de hacer, agregando dichas líneas de codigo <code>xml</code> al <code>pomp.xml</code>. En Google hay infinidad de ficheros _pomp.xml_ para cada dependencia necesaria.

En nuestro panel de directorios de lado izquierdo tenemos un carpeta llamada <code>src</code> que por delante tiene otra llamada <code>main</code> y dos mas adelante llamadas <code>java</code> y <code>resources</code>. A continuación eliminamos las dos carpetas: **java** y **resources**.

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/delete_dir.png)

Ahora damos click derecho sobre la carpeta <code>main</code> y elegimos la opción <code>Mark Directory as</code> seguida de la opción <code>Sources root</code>. Lo cual cambiará el color de la carpeta a azul como se muestra:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/blue_main.png)

## Crear el objeto «Class Scala».

Ahora estamos listo para crear nuestro objeto clase, lo siguiente debe generar un fichero Main.scala que tu puedes nombrar como gustes, en mi caso le doy ese nombre, esta clase es equivalente a lo que hacemos en Java al declara el famoso «public static void main(String[] args)», es decir, le estamos indicando a nuestro proyecto en que punto debe empezar a ejecutar el código. También es importante saber que el método <code>main</code> de **Java** en **Scala** se escribe como <code>Unit</code> como verás a continuación:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/object_main.gif)

Los pasos que se siguen en el gif anterior son: botón derecho sobre la carpeta <code>main</code> enseguida elegimos Scala Class > Object, di por nombre «Main»(cualquier otro es válido) y pulsamos <code>Enter</code>.

## Ejecutar la función main

Finalmete tenemos todos los elementos necesarios para crear una conexión Maven con Apache Spark, ahora basta con copiar y pegar el código [Main.scala](https://github.com/gabrielfernando01/scala/blob/main/Ingestas/Hello_Spark/Main.scala) en tu panel derecho y ejecutarlo. Aunque te recomiendo que lo hagas por bloques y revises que se estas haciendo para que comprendas las funcionalidades de Spark.

Por último recuerda que Apache Spark tiene dos tipos de funciones:

- Transformaciones
- Acciones

Por lo que es bueno que distingas en este primer ejercicio cuales son cada una de ellas. Lo único que resta es ejecutar el función <code>main</code> de la que hay diversas maneras, una de ellas es dando click en el botón <code>Play</code>.

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/play.png)

El resultado en el compilador debe ser el siguiente:

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/compilador.png)

Si pudiste ejecutar el código, **¡Felicidades!** has hecho tu primera conexión con Maven y el framework Apache Sapark.