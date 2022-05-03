![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/language.png)
  
# Instalación de Spark en GNU/Linux Debian
## Introduction

Apache Spark es un framework(conjunto de herramientas) usadas en el entorno de agrupación computacional para el **análisis de big data**.

En este turorial, mostrare como **instalar Spark en una distribución Debian o Ubuntu**. La guia muestra como inicializar un servidor maestro (master) y trabajador (slave), y como cargar las terminales (shells) de Scala y Python. Así como los principales comandos de Spark.

### Prerequisitos

- Un SO Debian o sus derivadas.
- Acceso a la linea de comandos o terminal.
- Un usuario con permisos sudo o **root**.

## Instalar los paquetes requeridos por Spark

Antes de descargar y configurar Spark, necesitamos instalar dependencias. Estos pasos incluyen la instalación de la siguiete paquetería.

- JDK
- Scala
- Git

Abrimos una terminal y corremos el siguiente comando para la instalación de las tres paqueterias a la vez:

``` javascript
sudo apt install default-jdk scala git -y
```

Una vez que el proceso este completado, **verifica que las dependencias esten instaladas** corriendo el siguiente comando:

``` javascript
java -version; javac -version; scala -version; git --version
```

Se imprimirán las salida con la versiones correspondientes, si la instalación por todos las paqueterías fue exitosa.

## Descargar y Configurar Spark en Debian o Ubuntu.

Ahora, necesitamos descargar la versión de Spark que quieras y este disponible desde el sitio web oficial. Al momento de editar este texto la versión más actualizada es _Spark 3.2.1_ (Enero-26-2022) conjuntamente con la paquetería _Hadoop 3.2_.

Usamos el comando **wget** junto con la liga del sitio  para la descarga de nuestro archivo Spark:

``` javascript
wget https://dlcdn.apache.org/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz
```

***
**Nota:** Si la URL no corre, por favor dirigete a la página oficial [Apache Spark](https://spark.apache.org/) y busca la versión más reciente en el menú descargas (Download). En otras palabras, también puedes intentar remplazar las versiones en la liga que te estoy compartiendo.
***

Ahora, extraemos el archivo guardado usando _tar:_

``` javascript
tar xvf spark-*
```

Deje que el proceso se complete. La salida muestra los ficheros que se están desempaquetando desde el archivo.

Finalmente, movemos el directorio desempaquetado spark-3.2.1-bin-hadoop3.2 al directorio _**opt/spark**_.

Usando el comando **mv** para cortar y pegar: 

``` javascript
sudo mv spark-3.2.1-bin-hadoop3.2 /opt/spark
```

## Configurar el entorno Spark

Antes de inicializar el servidor maestro, necesitamos configurar las variables de entorno. Estas son a menudo rutas (paths) en el Spark que necesitamos agregar al perfil de usuario.

Usando el comando **echo** agregamos las siguientes tres lines al _.profile:_

``` javascript
echo "export SPARK_HOME=/opt/spark" >> ~/.profile
echo "export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin" >> ~/.profile
echo "export PYSPARK_PYTHON=/usr/bin/python3" >> ~/.profile
```

También podemos agregar las rutas de exportación editando el fichero _.profile_ en el editor que eligas, como nano o vim.

Por ejemplo, para el editor nano, ingresamos:

```javascript
nano ~/.profile
```

Cuando carge profile, nos posecionamos al final del archivo:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/export_paths.png)

Entonces, agregamos las siguientes tres líneas:

```javascript
export SPARK_HOME=/opt/spark
export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin
export PYSPARK_PYTHON=/usr/bin/python3
```

Guardamos, confirmamos y salimos.

Cuando hayamos finalizado de agregarar las rutas (paths), cargamos el fichero _.profile_ escribiendo sobre la línea de comando:

```javascript
source ~/.profile
```

## Inicializando Standalone Servidor Maestro Spark

Ahora que hemos completado la configuración del entorno Spark, podemos inicializar el servidor maestro.

En la terminal, escribimos:

```javascript
start-master.sh
```

Para visualizar la interfaz web Spark, abrimos un navegador web y entramos a la dirección localhost IP sobre el puerto 8080.

```javascript
http://127.0.0.1:8080/
```

La página muestra tu **URL Spark**, la información para el status de trabajadores (workers), recursos del hardware utilizados, etc.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/url.png)

La URL para el Maestro Spark es el nombre de tu dispositivo sobre el puerto 8080. Para mi caso es _**debian.gabi:8080**_. Así es que, aquí tenemos tres caminos posibles para cargar la Web UI Spark Master:

1. 127.0.0.1:8080
2. localhost:8080
3. deviceName:8080

## Inicializar el servidor trabajador Spark (start a worker process)

En esta configuración standalone de un solo servidor, inicializarremos un servidor trabajador conjuntamente con el servidor maestro.

Para esto, corremos el siguiente comando en este formato:

```javascript
start-slave.sh spark://master:port
```

El **master** en este comando puede ser una IP o un hostname.

En mi caso es **debian.gabi:**

```javascript
start-slave.sh spark://debian.gabi:7077
```

Ahora que el trabajador o esclavo esta cargado y corriendo, si recargamos la Spark Master's Web UI, deberás de verlo en la lista:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/slave.png)

### Especificar la asignación de recursos para los trabajadores

La configuración por defecto cuando inicializamos un trabajador sobre una máquinas es la disponible por todos los núcleos CPU. Puedes especificar el número de núcleos que pasan por las **-c** banderas al comando **start-slave**.

```javascript
start-slave.sh -c 1 spark://debian.gabi:7077
```

Recargamos el Spark Master's Web UI para confirmar la configuración del trabajador.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/core.png)

De manera similar podemos asignar la cantidad especifica de memoria cuando inicializamos al trabajador. La configuración por defecto es la cantidad de memoria RAM usada por la máquina menos 1GB.

Al iniciar un trabajador y asignarle una cantidad especifica de memoria, agregamos la opción **-m** y el número. Para gigabytes, usamos **G** y para megabytes, usamos **M.**

Por ejemplo, para iniciar un trabajador con 512MB de memoria, damos enter al siguiente comando:

```javascript
start-slave.sh -m 512MB spark://debian.gabi:7077
```

Recarga el Spark Master's Web UI para visualizar el status del trabajador y confirmar la configuración 

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/memory.png)

## Probar Spark Shell

Después de haber terminado de configurar y arrancar el servidor amo y esclavo, probamos si la Spark shell trabaja.

Cargamos la shell ingresando:

```javascript
spark-shell
```

Deberás obtener una notificación en pantalla y la descripción de Spark. Por defecto la interfaz es Scala, entonces cargara la shell cuando corras _spark-shell_.

Al finalizar la salida lucira la imagen con la versión que use al momento de escribir esta guia:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/spark_shell.png)

## Probando Python en Spark

Si no quieres usar la interfaz Scala por defecto, puedes usar Python.

Asegurate de salir de Scala y entonces ingresamos el siguiente comando:

```javascript
pyspark
```

La salida resultante luce similar a la anterior. En la parte inferior observarás la versión de Python.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/pyspark.png)

Para salir de esta shell, ingresa **quit()** y oprime enter.

## Comandos basicos para iniciar y detener el Servidor Amo y Escalavos (Master and Workers Server) 

Enseguida encotrarás los comandos basicos para arrancar y parar el servidor amo y esclavo de Apache Spark. Esta confiugración es para una sola máquina, los scripts corren por defecto en el localhost.

**Para iniciar una instancia del servidor mastestro** en la máquina actual, ejecutamos el comando que habiamos ya habiamos usado:

```javascript
start-master.sh
```

**Para detener la instancia maestro** empezamos por ejecutar el sigueinte script, ejecutamos:

```javascript
stop-master.sh
```

**Para detener un esclavo** que se esta ejecutando, ingresamos el siguiente comando:

```javascript
stop-slave.sh
```

En la Web UI Spark Master, mostrara en el campo 'status' del Worker Id como DEAD.

Puedes **iniciar ambas instancias maestro y esclavo** usando el comando start-all:

```javascript
start-all.sh
```

### Conclusión

Este tutorial muestra **como instalar Spark sobre una distribución Debian y sus derivadas**, como sus dependencias necesarias.
