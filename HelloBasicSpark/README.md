![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/HelloBasicSpark/images/cover_project.png)

# Create Spark 💥 - Scala 🟥 project with IntelliJ IDEA 🟧

Para crear el siguiente proyecto Spark - Scala con IntelliJ IDEA te comparto los recursos que ocuparemos:

- 🟦 OS: Kubuntu 24.04
- ☕ Java JDK: openjdk 11.0.26
- 🟥 Scala version: 2.13.8
- 🪶 Maven version: 3.8.7
- 🔌 sbt version: 1.10.7
- 💥 Spark version: 3.5.1
- 🟧 IntelliJ IDEA: 24.04

Es importantante validar las versiones y las variables de entorno:

```
$ neofetch
Kubuntu 24.04.2 LTS x86_64
$ java -version
openjdk version "11.0.26" 2025-01-21
$ echo $JAVA_HOME
/usr/lib/jvm/java-11-openjdk-amd64
$ scala -version
Scala code runner version 2.13.8 -- Copyright 2002-2021, LAMP/EPFL and Lightbend, Inc.
$ echo $SCALA_HOME
/usr/local/share/scala
$ mvn -version
Apache Maven 3.8.7
Maven home: /usr/share/maven
$ sbt -version
sbt version in this project: 1.10.7
$ echo $SBT_HOME
/usr/local/sbt-1.10.7
$ spark-shell --version
version 3.5.1
Using Scala version 2.13.8, OpenJDK 64-Bit Server VM, 11.0.26
```

Una vez validado los recursos y las variables de entorno, continuamos con la configuración del proyecto en IntelliJ IDEA

1. Intalar el plugin de Scala en IntelliJ IDEA

Al abrir el IDE IntelliJ en el menú de la izquierda seleccionamos **Plugins**, en el buscador del panel derecho en la barra de buscador escribimos Scala, e intalamos el plugin.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/HelloBasicSpark/images/plugin_scala.png)