# Proceso de datos en Streaming

Vamos a iniciar un master desde la línea de comando.

```
start-master.sh
```

Seguido de un worker o slave que se conecte a la url del master en modo standalone.

```
start-worker.sh <url>
```

Y empezamos creando una API usando un fichero .py guardado en el directorio ~/opt/spark/bin que es donde se encuentra el lanzador ./spark-submit

```
from pyspark import SparkContext
from pyspark.streaming import StreamingContext

# Inicializamos el contexto. El 10 en el argumento indica c/cuantos segundos la API se reconectara a un origen de datos.
sc = SparkContext("local[2]", "NetworkWordCount")
ssc = StreamingContex(sc, 10)

lines = ssc.socketTextStream("localhost", 9090)
```
