# RDDs, Aplicaciones, Broadcast y acumuladores

Esta es la segunda parte de la carpeta [dataFrames](https://github.com/gabrielfernando01/spark/tree/master/dataFrames) por lo que iniciaremos nuevamente en modo standalone, iniciando las instancias master-esclavo desde la shell de linux.

```
start-master.sh
```

Llamamos a un worker en nuestra propia máquina usando la url que podemos visualizar en la Spark Web Interface. Lo anterior lo podemos confirmar dentro de una pestaña de nuestro navegador llamando al localhost (127.0.0.1) y al puerto 8080, es decir, 127.0.0.1:8080

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/url.png)

```
start-slave.sh <url>
```

Damos refrescar al browser y podemos visualizar al worker. Es importante notar, que nuestro worker esta con status 'ALIVE', los núcleos de procesador que esta ocupando y la cantidad de memoria.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/slave.png)

Abrimos nuestra PySpark shell ejecutando pyspark.

```
pyspark
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/spark_shell.png)

Usamos el mismo conjunto de datos, el cual descargamos de la página de [kaggle-data](https://www.kaggle.com/datasets/mkechinov/ecommerce-events-history-in-cosmetics-shop) y cargamos estos ficheros. Mandandolos a llamar desde el path de nuestra máquina.

```
df = spark.read.options(header='True', inferSchema='True').csv('<path>/*.csv')
```

**Show features of dataFrame**

```
df.count()
df.printSchema()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/schema.png)

Nuestro conjunto de datos contiene el registro de el movimiento en una tienda digital por parte de varias marcas y productos. Entre las muchas cosas que nos podemos preguntar es, ¿cuántos productos se han comprado de una marca determinada, con el subtotal correspondiente?.

Mostramos todas las marcas disponibles:

```
df.select("brand").distinct().show()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/brands.png)

De las marcas disponibles, tomemos una, en este caso "riche". Encontremos ahora que productos se han vendido de dicha marca. Agregando que en este momento empezaremos a utilizar [RDDs](https://spark.apache.org/docs/latest/rdd-programming-guide.html)

***
### Operaciones con RDDs

Los RDD admiten dos tipos de operaciones: _transformaciones_, que crean un nuevo conjunto de datos a partir de uno existente, y acciones, que devuelven un valor al programa controlador después de ejecutar un cálculo en el conjunto de datos. Por ejemplo, el mapa es una transformación que pasa cada elemento del conjunto de datos a través de una función y devuelve un nuevo RDD que representa los resultados. Por otro lado, _reduce_ es una acción que agrega todos los elementos del RDD usando alguna función y devuelve el resultado final al programa controlador (aunque también existe un **reduceByKey** paralelo que devuelve un conjunto de datos distribuido).

Todas las transformaciones en Spark son _lazy_, ya que no calculan sus resultados de inmediato. En cambio, solo recuerdan las transformaciones aplicadas a algún conjunto de datos base (por ejemplo, un archivo). Las transformaciones solo se calculan cuando una acción requiere que se devuelva un resultado al programa controlador. Este diseño permite que Spark funcione de manera más eficiente. Por ejemplo, podemos darnos cuenta de que un conjunto de datos creado a través del mapa se usará en una reducción y devolverá solo el resultado de la reducción al controlador, en lugar del conjunto de datos mapeado más grande.

De forma predeterminada, cada RDD transformado se puede volver a calcular cada vez que ejecuta una acción en él. Sin embargo, también puede conservar un RDD en la memoria usando el método persistente (o caché), en cuyo caso Spark mantendrá los elementos en el clúster para un acceso mucho más rápido la próxima vez que lo consulte. También hay soporte para RDD persistentes en el disco o replicados en múltiples nodos.
***

Para la siguiente tarea usaremos una _lambda_, aunque para ello PySpark necesitamos definir primero una función para un contador que ocuparemos.

```
def myFunc(s):
	if["brand"]=="riche" and s["event_type"]=="cart":
		return[(s["product_id"], 1)]
	return[]	
```

Aplicamos un Map para insertar la función y que nos devuelva otro RDD, y en el caso de reduceByKey le pasaremos el resultado de la función para que los sume.

```
lines = df.rdd.flatMap(myFunc).reduceByKey(lambda a, b: a+b)
```

Queremos ver lo que hemos generado, para ello usamos un collect() para que recolecte lo procesado por el RDD.

```
for e in lines.collect():
	print(e)
```

Debemos de ver un lista similar al siguiente:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/collect.png)

Lo que tenemos es una lista con todos los productos que han sido tomados de una marca en especifico. Otra forma de mostrar esta lista en con take(), mostremos los 20 primeros productos que aparecen:

```
print(lines.take(20))
```

Que más podemos hacer para mostrar la lista. Podemos convertir el RDD en un dataFrame y mostrarlos.

```
lines.toDF().show()
```

Guardemos la lista en una carpeta, en mi caso la nombre 'result2'.

```
lines.saveAsTextFile("<path/directory_name>")
```

Debes de obtener un resultado similar al siguiente:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/result2.png)

### Ejecutar una API desde un clúster en Spark Web Interface.

Para ello mandaremos llamar al master apoyado con un proceso ./spark-submit ubicado en el directorio /opt/spark/bin de Spark. En otras palabras, creamos un script de nombre app1.py y para ejecutarlo lo guardamos en el directorio \<origin\>/bin/

```
import sys
from pyspark.sql import SparkSession

spark = SparkSession.builder.getOrCreate()

df = spark.read.options(header='True', inferSchema='True').csv(sys.argv[1])

def myFunc(s):
    if s["brand"]=="riche" and s["event_type"]=="cart":
        return[(s["product_id"], 1)]
    return[]

lines = df.rdd.flatMap(myFunc).reduceByKey(lambda a, b: a+b)

lines.saveAsTextFile(sys.argv[2])
```

donde argv[1] y argv[2] son los directorios de entrada y salida correspondientemente. Los cuales le pasaremos cuando ejecutemos la aplicación y deben ir entre comillas.

Para ejecutarlo llamamos al proceso ./spark-submit seguido de, --master local[4] que es lo que haré en este ejemplo, en seguida la el script .py que en mi caso lo nombre app1.py y finalmente los dos argumentos entre comillas, que son las rutas de entrada y salida en nuestra máquina, en el caso del argv[2] debes darle un nombre a la carpeta donde se depositarán los ficheros, en mi caso, la nombro _result3_. En mi terminal se observa de la siguiente manera:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/app1.png)

Exiten varias maneras de ejecutar el script .py. Si hiciste la intalación de **Spark** por medio de **PyPI** puedes ejecutar el script desde la terminila con tan solo escribir:

```
$ python3 app1.py
```


Para lo anterior, el fichero app1.py debe estar guardado en el \<HOME\> de tu computadora. Por otro lado si ejecutas el script usando el panel **Spark UI** debes de inserta; en el directorio \<HOME\/bin$> ./spark-submit --master \<URL\>, en mi caso es, spark://gabi-HP-Stream-Laptop-14-ax1xxx:7077 y entre comillas los directorios argv[1], argv[2], de esta manera el worker indicara los procesos ejecutados con su descripción.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/worker.png)

### Variables broadcast y acumuladores.

Dado que los RDDs hace procesos paralelamente, no podemos hacer uso de variables globales, en ese sentido es que usamos las variables broadcast que son solo de lectura y son cargadas por cada nodo. Construyamos otra API con el nombre app2.py en el mismo directorio prompt:/opt/spark/bin como ejemplo.

```
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("app1").getOrCreate()

# Broadcast
broadcastVar = spark.sparkContext.broadcast([1, 2, 3])

print("")
print(broadcastVar.value)
print("")
```

En este caso ejecutamos desde la línea de comandos:

```
prompt:/opt/spark/bin$ ./spark-submit --master <url_master> <name_app.py> 
```

Si la aplicación se ejecuto correctamente, debes de ver una pantalla similar a la siguiente:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/broadcast.png)

**Acumuladores** (contadores o sumas).

Creamos nuestra tercer APPI de nombre app3.py

```
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("app1").getOrCreate()

# Broadcast
broadcastVar = spark.sparkContext.broadcast([1, 2, 3])

print("")
print(broadcastVar.value)
print("")

# Acumulador
accum = spark.sparkContext.accumulator(0)
sumaError = 0

def myFunc(x):
	global sumaError
	
	acumm.add(x)
	sumaError += x
	
rdd = spark.sparkContext.parallelize([1, 2, 3, 4, 5])

rdd.foreach(myFunc)

print("")
print(accum)
print(sumaError)
print("")
```

Si la API fue ejecutada correctamente, debes obtener una pantalla similar a la siguiente:

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDDs/image/accum.png)

Esto nos devuelve un 15 para el acumulado y 0 para el sumatorio.

Nuestro RDD lo que hizo fue lo siguiente:

```
rdd = spark.sparkContext.parallelize([1, 2, 3, 4, 5])

	1 + 2 + 3 + 4 + 5
```

