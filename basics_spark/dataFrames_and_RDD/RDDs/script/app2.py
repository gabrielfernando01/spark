from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("app1").getOrCreate()

# Broadcast
broadcastVar = spark.sparkContext.broadcast([1,2,3])

print("")
print(broadcastVar.value)
print("")
