import sys
from pyspark.sql import SparkSession

spark = SparkSession.builder.getOrCreate()

df = spark.read.options(header = 'True', inferSchema = 'True').csv(sys.argv[1])

def myFunc(s):
    if s["brand"]=="riche" and s["event_type"]=="cart":
        return[(s["product_id"], 1)]
    return[]

lines = df.rdd.flatMap(myFunc).reduceByKey(lambda a, b: a + b)

lines.saveAsTextFile(sys.argv[2])

