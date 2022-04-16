# RDDs, Aplicaciones, Broadcast y acumuladores

Esta es la segunda parte de la carpeta [dataFrame](https://github.com/gabrielfernando01/spark/tree/master/dataFrame) por lo que iniciaremos nuevamente en modo standalone, iniciando las instancias master-esclavo.

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

Abrimos nuestra consola usando PySpark

```
pyspark
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/export_paths.png)

Usamos el mismo conjunto de datos, el cual descargamos de la página de [kaggle-data](https://www.kaggle.com/datasets/mkechinov/ecommerce-events-history-in-cosmetics-shop) y cargamos estos ficheros. Recordar el lugar donde hayamos colocados los ficheros, que es la parte que tenemos que sustituir en path.

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
Operaciones RDD

Los RDD admiten dos tipos de operaciones: _transformaciones_, que crean un nuevo conjunto de datos a partir de uno existente, y acciones, que devuelven un valor al programa controlador después de ejecutar un cálculo en el conjunto de datos. Por ejemplo, el mapa es una transformación que pasa cada elemento del conjunto de datos a través de una función y devuelve un nuevo RDD que representa los resultados. Por otro lado, _reduce_ es una acción que agrega todos los elementos del RDD usando alguna función y devuelve el resultado final al programa controlador (aunque también existe un **reduceByKey** paralelo que devuelve un conjunto de datos distribuido).

Todas las transformaciones en Spark son _lazy_, ya que no calculan sus resultados de inmediato. En cambio, solo recuerdan las transformaciones aplicadas a algún conjunto de datos base (por ejemplo, un archivo). Las transformaciones solo se calculan cuando una acción requiere que se devuelva un resultado al programa controlador. Este diseño permite que Spark funcione de manera más eficiente. Por ejemplo, podemos darnos cuenta de que un conjunto de datos creado a través del mapa se usará en una reducción y devolverá solo el resultado de la reducción al controlador, en lugar del conjunto de datos mapeado más grande.

De forma predeterminada, cada RDD transformado se puede volver a calcular cada vez que ejecuta una acción en él. Sin embargo, también puede conservar un RDD en la memoria usando el método persistente (o caché), en cuyo caso Spark mantendrá los elementos en el clúster para un acceso mucho más rápido la próxima vez que lo consulte. También hay soporte para RDD persistentes en el disco o replicados en múltiples nodos.
***

Para la siguiente tarea usaremos una _lambda_, aunque para ello en PySpark necesitamos definir primero una función para hacer el contador que ocupamos.

```
def myFunc(s):
	if["brand"]=="riche" and s["event_type"]=="cart":
		return[(s["product_id"], 1)]
	return[]
``` 
