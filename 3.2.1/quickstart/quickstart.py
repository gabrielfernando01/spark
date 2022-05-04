# If PySpark is installed with pip in your current environment:
pyspark

# Let's make a new DataFrame from the text of the README file
# in the Spark source directory:
textFile = spark.read.text("/opt/spark/README.md")

# Number of rows in this DataFrame
textFile.count()

# First row in this DataFrame
textFile.first()

# filter() return a new DataFrame with a subset of the lines
linesWithSpark = textFile.filter(textFile.value.contains("Spark"))

# How many lines contains "Spark"?
textFile.filter(textFile.value.contains("Spark")).count()

# Let's say we want to find the line with the most words.
from pyspark.sql.function import *
textFile.select(size(split(textFile.value, "\s+")).name("numwords")).agg(max(col("numwords"))).collect()

# Use explode() in select(), to transform a Dataset of lines to a Dataset of words.
wordCount = textFile.select(explode(split(textFile.value, "\s+")).alias("word")).groupBy("word").count()

# To collect the word counts in our shell, we can call collect().
wordCount.collect()

# Spark also supports pulling data sets into a cluster-wide-in-memory cache.
linesWithSpark.cache()
linesWithSpark.count()






