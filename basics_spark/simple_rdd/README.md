# Ingestas
## Introducción a Big Data e ingestas.

En este directorio se busca dar a entender cuales son los elementos básicos y necesarios para iniciar un proyecto con Apache Spark y el lenguaje de programación <code>Scala</code>.

![](https://raw.githubusercontent.com/gabrielfernando01/scala/master/Ingestas/image/header_scala.png)

Requisitos:

- Sistema Operativo Debian o alguna de sus derivadas (no necesariamente).
- Instalar JDK 8 u 11.
- Instalar scala
- Instalar Maven
- Instalar IDE IntelliJ Idea

### Instalación del Java Development Kit(JDK).

1. Check which version of the JDK your system is using:

```
$ java -version
```

If the OpenJDK is used, the results should look like:

```
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (build 1.8.0_242-b09)
OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)
```

If Oracle Java is used, the results should look like:

```
java version "1.8.0_241"
Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
```

2. Update the repositories:

```
$ sudo apt-get update
```

3. Install OpenJDK:

```
sudo apt-get install openjdk-8-jdk
```

4. Verify the version of the JDK:

```
java -version
```

```
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (build 1.8.0_242-b09)
OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)
```

5. If the correct version of Java is not being used, use the alternatives command to switch it:

```
sudo update-alternatives --set java /usr/lib/jvm/jdk1.8.0_version/bin/java
```

6. Verify the version of the JDK:

```
java -version
```

```
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (build 1.8.0_242-b09)
OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)
```
