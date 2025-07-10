![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/cover_pilotos.png)

# ✈️ Análisis de Datos de Pilotos con Apache Spark en Scala.

Este proyecto utiliza Apache Spark con Scala  para realizar análisis sobre un conjunto de datos relacionados con pilotos, sus salarios, nacionalidades, y estadísticas de vuelo. El objetivo es demostrar cómo se pueden utilizar DataFrames y operaciones de Spark para resolver preguntas analíticas específicas.

***

## ☀️ Descripción general del código.

El código está estructurado en una aplicación Spark que realiza las siguientes tareas: 

1. Creación de DataFrames :

Se crean varios DataFrames a partir de secuencias (<code>Seq</code>) que representan información personal, laboral y salarial de los pilotos, así como un diccionario de países y monedas. 

2. Análisis de Salarios y Nacionalidades :

Se calcula el salario de cada piloto y se muestra su nombre, apellidos, identificador, salario y nacionalidad en orden descendente de salario. 

3. Conteo de Vuelos por Piloto :

A partir de un archivo CSV que contiene información detallada de vuelos, se cuenta cuántos vuelos ha realizado cada piloto. 

4. Estadísticas de Distancia y Velocidad:

Se calcula:
 
+ La distancia total recorrida por cada piloto.
+ La velocidad mínima promedio alcanzada por cada piloto.

***

### Estructura del Código.

1. **⚙️ Configuración de Spark**.

Se inicializa una sesión de Spark utilizando <code>SparkSession</code> con la configuración necesaria para ejecutar el programa en modo local.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/conf_spark.png)

2. **Creació:n de RDDs y DataFrames**

Se definen cuatro conjuntos de datos iniciales en forma de secuencia (<code>Seq</code>):

+ Información Personal : Contiene nombres, apellidos, edad y nacionalidad de los pilotos.
+ Información Laboral : Incluye el nombre, ID de empleado, aerolínea y años de experiencia.
+ Salarios : Asocia cada ID de empleado con su salario correspondiente.
+ Diccionario de Países : Mapea códigos de país a nombres de país y monedas.

Estos datos se convierten en RDDs y posteriormente en DataFrames utilizando el método <code>.toDF()</code>.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/rdd_pilotos.png)

3. **Análisis de salarios y nacionalidade**.

Se realiza un join entre los DataFrames de información laboral y salarios para obtener el salario de cada piloto. Luego, se une este resultado con la información personal para mostrar el nombre, apellidos, ID de empleado, salario y nacionalidad en orden descendente de salario.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/join_pilotos.png)

4. **Conteo de Vuelos por Piloto**.

Se carga un archivo CSV que contiene información detallada de vuelos (número de vuelo, distancia, alturas, velocidades, etc.). Este archivo se transforma en un DataFrame y se realiza un join con los datos de los pilotos para contar cuántos vuelos ha realizado cada uno.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/numero_vuelos.png)

5. **Estadísticas de distancia y velocidad**.

Se calcula la distancia total recorrida y la velocidad mínima promedio para cada piloto utilizando funciones de agregación como <code>avg()</code>.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/statics_pilots.png)

***

### Requisitos del sistema.

El projecto esta hecho y listo para clonar usando el IDE IntelliJ IDEA, también sugiero altamente que tengas listos los siguientes recursos en tu ordenador:

+ ☕ javaJDK: openjdk 11.0.26
+ 🛣️ $JAVA_HOME: /usr/lib/jvm/java-11-openjdk-amd64
+ 🟥 scala version: 2.13.8
+ 🛣️ $SCALA_HOME: /usr/local/share/scala
+ 🪶 maven version: 3.8.7
+ 🛣️ path maven: /usr/share/maven
+ 🔌 sbt verison: 1.10.7
+ 💥 spark version: 3.5.1
+ 🛣️ path spark: /opt/spark
+ 🟧 IDE: IntelliJIDEA 24.04

***

### Preguntas resultas.

1.¿Qué salario tiene cada piloto? 

Se muestra el salario de cada piloto junto con su nombre, apellidos, ID de empleado y nacionalidad en orden descendente de salario. 

2. ¿Cuántos vuelos ha realizado cada piloto? 

Se cuenta el número de vuelos realizados por cada piloto utilizando un contador auxiliar. 

3. ¿Qué piloto ha recorrido más kilómetros? 

Se calcula la distancia total promedio recorrida por cada piloto. 

4. ¿Qué piloto ha tenido la menor velocidad? 

Se calcula la velocidad mínima promedio alcanzada por cada piloto.

***

### Consideraciones Adicionales.

+ Optimización : El código puede optimizarse utilizando vistas temporales y consultas SQL si es necesario.
+ Escalabilidad : Este código está diseñado para ejecutarse en modo local, pero puede adaptarse fácilmente para ejecutarse en un clúster distribuido cambiando la configuración de Spark.