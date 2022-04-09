# ==================================================================================================
# Quickstart: DataFrame

# Initializing SparkSession
from pyspark.sql import SparkSession
spark = SparkSession.builder.getOrCreate()

# Create PySpark DataFrame from a list of rows

from datetime import datetime, date
import pandas as pd
from pyspark.sql import Row

df = spark.createDataFrame([
    Row(a=1, b=2., c='string1', d=date(2000, 1, 1), e=datetime(2000, 1, 1, 12, 0)),
    Row(a=2, b=3., c='string2', d=date(2000, 2, 1), e=datetime(2000, 1, 2, 12, 0)),
    Row(a=4, b=5., c='string3', d=date(2000, 3, 1), e=datetime(2000, 1, 3, 12, 0))
])

df

# Create a PySpark DataFrame with an explicit schema.
df = spark.createDataFrame([
    (1, 2., 'string1', date(2000, 1, 1), datetime(2000, 1, 1, 12, 0)),
    (2, 3., 'string2', date(2000, 2, 1), datetime(2000, 1, 2, 12, 0)),
    (3, 4., 'string3', date(2000, 3, 1), datetime(2000, 1, 3, 12, 0)),
], schema='a long, b double, c string, d date, e timestamp')

df

# Create a PySpark DataFrame from a pandas DataFrame
pandas_df = pd. DataFrame({
    'a': [1, 2, 3],
    'b': [2., 3., 4.],
    'c': ['string1', 'string2', 'string3'],
    'd': [date(2000, 1, 1), date(2000, 2, 1), date(2000, 3, 1)],
    'e': [datetime(2000, 1, 1, 12, 0), datetime(2000, 1, 2, 12, 0), datetime(2000, 1, 3, 12, 0)]
})

df = spark.createDataFrame(pandas_df)

df

# Create a PySpark DataFrame from an RDD consisting of a list of tuples
rdd = spark.sparkContext.parallelize([
    (1, 2., 'string1', date(2000, 1, 1), datetime(2000, 1, 12, 0)),
    (1, 3., 'string2', date(2000, 1, 1), datetime(2000, 1, 2, 12, 0)),
    (3, 4., 'string3', date(2000, 3, 1), datetime(2000, 1, 3, 12, 12, 0))
])

df = spark.createDataFrame(rdd, schema=['a', 'b', 'c', 'd', 'e'])

df

# All DataFrames above result same.
df.show()
df.printSchema()

# The top rows of a DataFrame can be displayed using DataFrame.show()
df.show(1)





