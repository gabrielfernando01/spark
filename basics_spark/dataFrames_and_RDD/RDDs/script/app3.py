from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("app1").getOrCreate()

# Broadcast
broadcastVar = spark.sparkContext.broadcast([1, 2, 3])

print("")
print(broadcastVar.value)
print("")

# Acumulador
accum = spark.sparkContext.accumulator(0)
sumaError = (0)

def myFunc(x):
    global sumaError

    accum.add(x)
    sumaError += x

rdd = spark.sparkContext.parallelize([1, 2, 3, 4, 5])

rdd.foreach(myFunc)

print("")
print(accum)
print(sumaError)
print("")
