![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/pseudocodigo_examples/image/cover_oop.png)

# OOP Programming with Java ☕.

## 🌟 Descripción general.

Este proyecto es una colección de tres ejercicios diseñados para practicar los principios de la **Programación Orientada a Objetos (POO)** utilizando Java ☕. Cada ejercicio se implementa en un directorio separado y se centra en resolver un problema distinto relacionado con la gestión de diferentes tipos de entidades (cuentas bancarias, contraseñas y elementos multimedia). Las soluciones destacan conceptos fundamentales de POO como encapsulación, herencia, polimorfismo e interfaces, mientras ofrecen ejemplos prácticos de diseño e interacción de clases.

El proyecto está estructurado en tres directorios principales, cada uno con la solución a un ejercicio:

1. **CuentaBancaria 🏦**: Gestión de cuentas bancarias con operaciones de depósito y retiro.
2. **GeneradorContraseñas 🔒**: Generación y evaluación de la fortaleza de contraseñas.
3. **GestiónMultimedia 🕹️**: Manejo de series y videojuegos con un sistema de entrega.

## 🎯 Objetivo de los Ejercicios.

1. **Gestión de Cuentas Bancarias 🏦** (<code>AccountApp</code>).

El objetivo de este ejercicio es modelar un sistema de cuentas bancarias. Se trata de crear una clase que represente una cuenta bancaria con un titular obligatorio y un saldo opcional. El sistema permite a los usuarios depositar y retirar dinero, con reglas específicas para manejar operaciones inválidas (por ejemplo, no se permiten depósitos negativos, y los retiros no pueden dejar el saldo en negativo). Este ejercicio se centra en diseñar una clase con atributos, constructores y métodos adecuados para gestionar transacciones de la cuenta.

2. **Generador y Evaluador de Contraseñas 🔒** (<code>Password</code>).

Este ejercicio tiene como objetivo crear un sistema para generar y evaluar contraseñas. Implica diseñar una clase que represente una contraseña con una longitud personalizable (por defecto, 8 caracteres). El sistema puede generar contraseñas aleatorias de la longitud especificada y determinar si una contraseña es fuerte según criterios como el número de letras mayúsculas, minúsculas y dígitos. El ejercicio también incluye un programa para generar múltiples contraseñas, evaluar su fortaleza y mostrar los resultados. El enfoque está en el diseño de clases, la generación aleatoria y la lógica condicional.

3. **Gestión de Elementos Multimedia con Series y Videojuegos 🕹️** (<code>GestorMultimedia</code>).

El objetivo de este ejercicio es gestionar una colección de elementos multimedia, específicamente series y videojuegos, con un sistema de entrega. Implica crear dos clases—una para series y otra para videojuegos—cada una con atributos como título, género y creador/compañía. Ambos tipos de medios pueden marcarse como "entregados" o "devueltos" utilizando una interfaz compartida. El ejercicio incluye un programa para crear colecciones de series y videojuegos, entregar algunos elementos, contar los elementos entregados e identificar el videojuego con más horas estimadas y la serie con más temporadas. Este ejercicio pone énfasis en el uso de interfaces, comportamientos compartidos y lógica de comparación.

***

### 📌 Explicación de "Entregados" y "Devueltos".

En el contexto del ejercicio, "entregados" y "devueltos" se refieren a un sistema de gestión de préstamos o entregas de elementos multimedia (series y videojuegos). Este sistema simula un escenario donde los objetos (series o videojuegos) pueden ser "prestados" (entregados) a alguien y luego "regresados" (devueltos) al sistema. Este comportamiento se implementa a través de una interfaz llamada <code>Deliverable</code>, que define los siguientes métodos:

+ <code>deliver()</code>: Cambia el estado del objeto a "entregado" (es decir, indica que el objeto ha sido prestado o entregado a alguien). En términos del código, esto significa que el atributo <code>isDelivered</code> (un booleano) pasa de <code>false</code> a <code>true</code>.
+ <code>returnItem()</code>: Cambia el estado del objeto a "no entregado" (es decir, indica que el objeto ha sido devuelto al sistema). Esto significa que el atributo <code>isDelivered</code>  pasa de <code>true</code> a <code>false</code>.
+ <code>compareTo(Object obj)</code>: Devuelve el estado actual del atributo <code>isDelivered</code>, permitiendo verificar si el objeto está prestado (<code>true</code>) o no (<code>false</code>).

Este sistema es común en aplicaciones que simulan bibliotecas, tiendas de alquiler o plataformas de préstamo, donde se necesita rastrear si un elemento está disponible o ha sido prestado.

***

### Ejemplo práctico de lo que hace el código.

**Paso 1: Crear los Arreglos de Series y Videojuegos**.

El programa crea dos arreglos de 5 posiciones cada uno: uno para series y otro para videojuegos. Cada posición se llena con un objeto creado con valores específicos.

**Paso 2: Entregar Algunos Elementos**.

El programa "deliver" (presta) algunos elementos. Supongamos que se decide entregar las siguientes series y videojuegos:

+ Series: "Stranger Things" y "The Mandalorian".
+ Videojuegos: "The Witcher 3" y "Super Mario Odyssey".

El programa llama al método <code>deliver</code> en estos objetos, lo que cambia su atributo <code>isDelivered</code> a <code>true</code>. Ahora:

+ "Stranger Things" y "The Mandalorian" están entregadas (prestadas).
+ "The Witcher 3" y "Super Mario Odyssey" están entregados (prestados).

**Paso 3: Contar los Elementos Entregados y Devolverlos**.

El programa cuenta cuántos elementos están entregados (es decir, cuántos tienen <code>deliver</code> = <code>true</code>):

+ Series entregadas: 2 ("Stranger Things" y "The Mandalorian").
+ Videojuegos entregados: 2 ("The Witcher 3" y "Super Mario Odyssey").

Luego, el programa "devuelve" estos elementos (cambia su estado a <code>deliver</code> = <code>false</code>) usando el método <code>returnItem()</code>. Esto simula que los elementos han sido regresados al sistema.

**Paso 4: Comparar y Mostrar Resultados**

Finalmente, el programa identifica:

+ El videojuego con más horas estimadas: "Elden Ring" (120 horas).
+ La serie con más temporadas: "Friends" (10 temporadas).

El programa muestra esta información en pantalla con todos los detalles de los objetos (usando el método <code>toString()</code>). Por ejemplo:

Salida en pantalla:

```
Videojuego con más horas estimadas:
Título: Elden Ring, Horas Estimadas: 120, Género: RPG, Compañía: FromSoftware, Entregado: false

Serie con más temporadas:
Título: Friends, Temporadas: 10, Género: Comedia, Creador: David Crane, Entregado: false
```

***

### Resumen de lo que Hace el Código.

El código simula un sistema de gestión de préstamos para series y videojuegos:

1. Crea colecciones de series y videojuegos con diferentes características.
2. Permite "entregar" (prestar) algunos elementos y luego "devolverlos" (regresarlos).
3. Cuenta cuántos elementos están prestados y los devuelve.
4. Compara los elementos para encontrar el videojuego con más horas estimadas y la serie con más temporadas, mostrando sus detalles.

En este contexto, "entregados" significa que el elemento ha sido prestado (no está disponible), y "devueltos" significa que ha sido regresado (vuelve a estar disponible). Este sistema podría aplicarse, por ejemplo, a una biblioteca de medios o una tienda de alquiler.