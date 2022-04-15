# DataFrame y RDDs
## Proyecto cross selling

El siguiente proyecto da los primeros pasos de commo cargar, y manipular ficheros tipo csv en **Apache Spark** utilizando **PySpark** para ello vamos a testear con la terminal con el paquete que ya vimos [Instalación de Spark](https://github.com/gabrielfernando01/spark/blob/master/README.md).

Lo primero que haremos es descargar los archivos .csv con los que vamos a trabajar, estos los encontraremos en el repositorio de Kaggle en la siguiente dirección [data](https://www.kaggle.com/datasets/mkechinov/ecommerce-events-history-in-cosmetics-shop). Son 5 archivos de nombre:

- 2019-Dec.csv
- 2019-Nov.csv
- 2019-Oct.csv
- 2020-Feb.csv
- 2020-Jan.csv

Asegurate de descargarlos y descomprimirlos en alguna carpeta que tengas bien ubicada, en mi caso, como ejemplo usare el directorio ~/Documentos/scientist/spark/cosmetics/data. El peso de los archivos es el siguiente: 2.3 GB lo cual ya es importante.

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/RDD/images/weight_data.png)

Una vez, que tenemos listos nuestros datos. Arrancamos un cluster de Apache Spark en modo standalone, lo anterior quiere decir que tendremos el master y el worker en la misma máquina. Como ya creamos las variables de entorno, los mandamos llamar con el comando:

```
prompt:~$ start-all.sh
```

Seguido abriremos la shell de PySpark:

```
prompt:~$ pyspark
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/pyspark.png)

Cargamos los dataset:

```
df = spark.read.optionss(header='True', inferSchema='True').csv(<path/*.csv>)
````

