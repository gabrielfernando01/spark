# Starting Point: SparkSession
# To entry point into all functionality in Spark is the SparkSession class. To create
# a basic SparkSession, just use SparkSession, builder:
from pyspark.sql import SparkSession

spark = SparkSession \
        .builder \
        .appName("Python Spark SQL basic example") \
        .config("spark.some.config.option", "some-value") \
        .getOrCreate()

# Spark is an existing SparkSession
df = spark.read.json("people.json")

# Display the content of the DataFrame to stdout
df.show()

# Print the schema in a tree format
df.printSchema()

# Select only the "name" column
df.select("name").show()

# Select everybody, but increment the age by 1.
df.select(df['name'], df['age'] + 1).show()

# Select people older than 21
df.filter(df['age'] > 21).show()

# Count people by age
df.groupBy("age").count().show()

# The sql function on a SparkSession enables applications to run SQL queries 
# programmatically and returns the result as a DataFrame

# Register the DataFrame as a SQL temporary view
df.createOrReplaceTempView("people")

sqlDF = spark.sql("SELECT * FROM people")
sqlDF.show()

# Register the DataFrame as a global temporary view
df.createGlobalTempView("people")

# Global temporary view is tied to a system preserved database 'global_temp'
df.createGlobalTempView("people")

# Global temporary view is tied to a system preserved database 'global temp'
spark.sql("SELECT * FROM global_temp.people").show()

# Global temporary view is cross session
spark.newSession().sql("SELECT * FROM global_temp.people").show()

# Interoperating with RDDs
# Inferring the Schema Using Reflection
from pyspark.sql import Row

sc = spark.sparkConext

# Load a text file and convert each line to a Row
lines = sc.textFile("people.txt")
parts = lines.map(lambda l: l.split(","))
people = parts.map(lambda p: Row(name=p[0], age=int(p[1]))

# Infer the schema, and register the DataFrame as a table.
schemaPeople = spark.createDataFrame(people)
schemaPeople.createOrReplaceTempView("people")

# SQL can be run over DataFrame that have been registered as a table.
teeangers = spark.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19")

# The results of SQL queries are DataFrame objects.
# rdd return the content as an :class:'pyspark.RDD' of :class:'Row'
teenNames = teenagers.rdd.map(lambda p: "Name: " + p.name).collect()
for name in teenNames:
    print(name)
# Name: Justin


