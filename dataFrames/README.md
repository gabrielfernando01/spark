# DataFrame y RDDs
## Proyecto cross selling

El siguiente proyecto da los primeros pasos de commo cargar, y manipular ficheros tipo csv en **Apache Spark** utilizando **PySpark** para ello vamos a testear con la terminal con el paquete que ya vimos [Instalación de Spark](https://github.com/gabrielfernando01/spark/blob/master/README.md).

Lo primero que haremos es descargar los archivos .csv con los que vamos a trabajar, estos los encontraremos en el repositorio de Kaggle en la siguiente dirección [kaggle-data](https://www.kaggle.com/datasets/mkechinov/ecommerce-events-history-in-cosmetics-shop). Son 5 archivos de nombre:

- 2019-Dec.csv
- 2019-Nov.csv
- 2019-Oct.csv
- 2020-Feb.csv
- 2020-Jan.csv

Asegurate de descargarlos y descomprimirlos en alguna carpeta que tengas bien ubicada, en mi caso, como ejemplo usare el directorio ~/Documentos/scientist/spark/data/cosmetics/csv. El peso de los archivos es el siguiente: 2.3 GB lo cual ya es importante.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/dataFrames/images/weigth_data.png)

Una vez, que tenemos listos nuestros datos. Arrancamos un cluster de Apache Spark en modo standalone, lo anterior quiere decir que tendremos el master y el worker en la misma máquina. Como ya creamos las variables de entorno, los mandamos llamar con el comando:

```
start-all.sh
```

Seguido abriremos la shell de PySpark:

```
pyspark
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/pyspark.png)

Y a través de la shell cargamos el dataset:

```
df = spark.read.optionss(header='True', inferSchema='True').csv(<path/*.csv>)
````

Contamos el número de registros:

```
df.count()
```

Mostramos la estructura del dataFrama

```
df.printSchema()
```

El dataset que ahora hemos cargado en nuestro cluster, muestra los diferentes movimientos que han habido en una tienda en línea. Nuestra intención es tomar un articulo y cruzarlo con todos los demás productos con los cuales han sido tomados dentro del carrito de compras.

Pensemos que la intención es que en futuras compras, si un usuario escoge algún articulo, poderle hacer sugerencias con que otros productos puede combinar su compra.

En la variable 'event_type' nos muestra el tipo de evento que tiene el registro, en este caso, estamos interesado en el evento 'cart'.

```
df.select("event_type").distinct.show()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/dataFrames/images/event_type.png)

Marcas o Proveedores disponibles:

```
df.select("brand").distinct.show()
```

Ahora que ya conocemos _tipo de evento_ y _marcas_. Si queremos encontrar los o el prducto concreto con los cuales se vende. Nuestra llave será el campo **'product_id'.**

```
df.select(["product_id"]).filter("event_type='cart'").show()
```

Nos da una lista de productos, que han sido metidos al carrito. Escogamos el primero de la lista.

```
df.select(["product_id"]).filter("event_type='cart'").first()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/dataFrames/images/first.png)

He escogido este producto 4958 (únicamente tome el primero de la lista), estoy interesado en saber todas las sesiones en las que este producto se ha metido al carrito.

```
sessions = df.select(["user_session"]).filter("event_type='cart' AND product_id=4958")
```

Ahora vamos a tomar todos los productos que distintos a nuestro producto original 4958 que estan en la lista u objeto sessions.

```
products = df.select(["product_id"]).filter("event_type='cart' AND product_id<>4958").filter(df["user_session"].isin(sessions["user_sessions]))
```

Tenemos la lista de productos que han sido tomadas en carrito conjuntamente con nuestro producto 4958.

```
products.select("product_id").show()
```

En consola nos muestra los primeros 20 productos. Queremos saber que productos son, necesitos una lista de productos unicos.

```
products = products.select("product_id").distinct()
products.select("product_id").count()
```

Hemos conseguido tener una estrategia de marketing al hallar una lista de productos, los cuales el usuario los prefiere al seleccionar otro en particular.

Si quisieramos dar un paso más, exportaríamos esta lista para poder reutilizarla.

```
products.write.mode("overwrite").csv('<path/name_directory>')
```

Se crea un directorio, en este caso de nombre _result1,_ con los ficheros csv generados por _products_.

### Usando la librería spark.sql

Creamos una vista temporal de nuestro dataFrame

```
df.createOrReplaceTempView("data")
```

Hacemos una consulta de los primeros 3 registros.

```
spark.sql("SELECT * FROM data LIMIT 3").show()
```

Query con el tipo de evento 'cart'.

```
spark.sql("SELECT * FROM data WHERE event_type = 'cart' LIMIT 3").show()
```

Consultar el número de registros que fueron puestos en el carrito.

```
spark.sql("SELECT COUNT(*) FROM data WHERE event_type = 'cart'").show()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/dataFrames/images/sql_count.png)
