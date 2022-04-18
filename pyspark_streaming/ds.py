from pyspark import SparkContext
from pyspark.streaming import StreamingContext

# Inicializamos contexto
sc = SparkContext("local[2]", "NetworkWordCount")
scc = StreamingContext(sc, 10)

lines = scc.socketTextStream("localhost", 9090)
