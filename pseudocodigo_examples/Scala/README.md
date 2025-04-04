![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/cover_scala.png)

# Basics in Scala 🟥.

### Description 🥁.

Este proyecto, desarrollado en Scala 🟥, tiene como objetivo explorar y practicar conceptos fundamentales del leguaje de programación Scala 🟥 a través de una serie de ejercicios prácticos. El código principal se encuentra en el fichero <code>ScalaLauncher.scala</code> dentro del paquete <code>com.everis.curso.scala</code>. Además, el proyecto incluye pruebas unitarias para validar el comportamiento del código, utilizando frameworks como **JUnit**, **ScalaTest** y **Specs2**, cuyos archivos de prueba están en el directorio <code>test.scala.samples</code> (<code>junit.sc</code>, <code>scalatest.sc</code>, <code>specs.sc</code>).

El proyecto cubre desde conceptos básicos como variables, colecciones y funciones, hasta temas más avanzados como currificación, <code>foldLeft</code>/<code>foldRight</code>, y manejo de errores con <code>Option</code> y <code>Either</code>.

***

## Estructura del Proyecto ⛳.

+ <code>ScalaLauncher.scala</code>: Archivo principal que contiene el código de los ejercicios y ejemplos.
+ <code>junit.sc</code>: Fichero con pruebas unitarias utilizando JUnit.
+ <code>scalatest.sc</code>: Fichero con pruebas unitarias utilizando ScalaTest.
+ <code>specs.sc</code>: Archivo con pruebas unitarias utilizando Specs2.

***

### Contenido del Proyecto 🎲.

**1. Conceptos Básicos 🧀**.

El proyecto comienza con una introducción a los conceptos fundamentales de Scala, incluyendo:

+ **Tipos de datos**: Uso de <code>Int</code>, <code>Byte</code>, <code>Long</code>, <code>Short</code>, <code>Float</code>, <code>Double</code> y <code>String</code>. 
+ **Variables**: Diferencia entre <code>val</code> (inmutable) y <code>var</code> (mutable, no recomendado).
+ **Secuencias y Listas**: Uso de <code>Seq</code> y <code>List</code> para manejar colecciones, con operaciones como <code>max</code>, <code>last</code>, <code>contains</code>, <code>drop</code>, <code>intersect</code> y <code>distinct</code>.
+ **Formato de cadenas**: Uso del método <code>String.format()</code> para formatear cadenas.
+ **Mapas**: <code>Map</code> para manejar pares clave-valor, con operaciones como <code>contains</code>, <code>keys</code> y <code>values</code>.

**2. Funciones y Operaciones con Colecciones 🌟**.

Las funciones de <code>Seq</code> en Scala 🟥 son extremadamente poderosas y versátiles, permitiendo realizar operaciones complejas de manera concisa. Además de las funciones mencionadas, existen muchas más disponibles en la biblioteca estándar de Scala 🟥. Algunas de las más destacadas incluyen:

+ Transformaciones: <code></code>, <code></code>, <code></code>,
+ Filtrado: <code></code>, <code></code>, <code></code>, <code></code>.
+ Reducción: <code></code>, <code></code>, <code></code>.
+ Operaciones de Conjunto: <code></code>, <code></code>, <code></code>, <code></code>.

Estas funciones hacen que trabajar con colecciones en Scala sea intuitivo y eficiente, lo que lo convierte en un lenguaje ideal para el procesamiento de datos.

Se exploran funciones y operaciones comunes en Scala 🟥:

+ **Map y ForEach**: Aplicación de transformaciones a colecciones con <code>map</code> y uso de <code>foreach</code> para iterar.
+ **Tuplas**: Manipulación de secuencias de tuplas (por ejemplo, nombres y edades).
+ **Funciones personalizadas**:

	+ <code>add1</code>: Suma de dos número enteros.
	+ <code>averageAge</code>: Calcula la edad promedio de una lista de personas.
	+ <code>oldestPerson</code>: Encuentra el nombre de la persona con mayor edad.
	
**3. Estructura de Control 🥊**.

+ **Match**: Uso de la expresión <code>match</code> para manejar diferentes casos (e.g., <code>whatSpendToday</code> para decidir qué hacer según el día.
+ **For y bucles**: Iteración sobre rangos y colecciones.

**4. Manejo de Errores ⚠️**.

Se implementan diferentes enfoques para manejar errores:

+ **Any**: Uso de <code>Any</code> para devolver diferentes tipos de resultado (e.g., en una división).
+ **Option**: Uso de <code>Option</code> (<code>Some</code> y <code>None</code>) para mejorar operaciones que pueden fallar (como una división por cero).
+ **Either**: Uso de <code>Either</code> (<code>Left</code> y  <code>Right</code>) para manejar errores con mensajes personalizados.

**5. Currificación 🌟**.

+ Se implementan funciones currificadas como <code>add</code> y <code>multOcho</code>, que permiten definir funciones parcialmente aplicadas.

**6. FoldLeft y FoldRight 👽**.

+ Uso de <code>foldLeft</code> y <code>foldRight</code> para realizar operaciones acumulativas sobre listas, tanto de enteros como de cadenas.

**7. Ejercicios Prácticos 🤠**.

El proyecto incluye dos ejercicios específicos:

+ **Ejercicio 1**: Imprimir los números del 1 al 12 utilizando diferentes métodos (<code>for</code>, <code>foreach</code>, <code> map</code>).
+ **Ejercicio 2**: Crear una función genérica <code>getLastElement</code> que devuelve el último elemento de una lista, aplicable a cualquier tipo de dato.

***

### Pruebas Unitarias 🔒.

El proyecto incluye pruebas unitarias para validar el comportamiento del código. Estas pruebas están implementadas en los siguientes archivos:

+ <code>junit.sc</code>: Pruebas utilizando el framework JUnit.
+ <code>scalatest.sc</code>: Pruebas utilizando ScalaTest, un framework popular para pruebas en Scala 🟥.
+ <code>specs.sc</code>: Pruebas utilizando Specs2, otro framework de pruebas para Scala 🟥.

**Instrucciones para Ejecutar el Proyecto 🦁**

1. **Requisitos**:

	+ Tener instalado Scala (versión 2.13 o superior recomendada).
	+ Un entorno de desarrollo como IntelliJ IDEA con el plugin de Scala, o usar <code>sbt</code> para compilar y ejecutar.
	+ Dependencias para pruebas: JUnit, ScalaTest y Specs2.
	
2. **Compilar y Ejecutar**:

+ Clona 👽 el repositorio o copia los archivos a tu máquina local 🖥️.
+ Si usas <code>sbt</code>, ejecuta.

<code>$ sbt run</code>

+ Para ejecutar las pruebas 🫣:

<code>$ sbt test</code>

3. **Explorar el Código 👨🏼‍💻**:

+ Abre <code>ScalaLauncher.scala</code> para revisar los ejercicios y ejemplos.
+ Consulta los archivos de prueba (<code>junit.sc</code>, <code>scalatest.sc</code>, <code>specs.sc</code>) para ver cómo se valida el comportamiento del código.










