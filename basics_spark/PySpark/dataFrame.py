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
    (2, 3., 'string2', date(2000, 1, 1), datetime(2000, 1, 2, 12, 0)),
    (3, 4., 'string3', date(2000, 3, 1), datetime(2000, 1, 3, 12, 12, 0))
])

df = spark.createDataFrame(rdd, schema=['a', 'b', 'c', 'd', 'e'])

df

# All DataFrames above result same.
df.show()
df.printSchema()

# The top rows of a DataFrame can be displayed using DataFrame.show()
df.show(1)

# The rows can also be shown vertically. This is useful when rows are too long to show horizontally
df.show(1, vertical=True)

# You can see the DataFrame's schema and column names as follows:
df.columns

df. printSchema()

# Show the summary of the DataFrame
df.select('a', 'b', 'c').describe.show()

# DataFrame.collect() collects the distributed data to the driver side as the local data in Python.
df.collect()

# In order to avoid throwing an out-of-memory exception, use DataFrame.take() or DataFrame.tail()
df.take(1)

# PySpark DataFrame also provides the conversion back to a pandas DataFrame to leverage pandas API.
df.toPandas()

# Selecting and Accesing Data
from pyspark.sql import Column
from pyspark.sql.functions import upper

type(df.c) == type(upper(df.c)) == type(df.c.isNull())

# DataFrame.select() takes the Column instances that return another DataFrame
df.select(df.c).show()

# Assign new Column instance.
df.withColumn('upper_c', upper(df.c)).show

# To select a subset of rows, use DataFrame.filter()
df.filter(df.a == 1).show()

# PySpark support various UDFs and APIs to allows users to execute Python native functions.
import pandas
from pyspark.sql.functions import pandas_udf

@pandas_udf('long')
def pandas_plus_one(series: pd.Series) -> pd.Series:
    # Simply plus one by using pandas Series.
    return series + 1

df.select(pandas_plus_one(df.a)).show()


