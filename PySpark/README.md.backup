![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/header_pyspark.png)

# Starting PySpark

## Installing use PyPI

If you want to install extra dependencies for a specific component, you can install it as below:

```javascript
pip install pyspark
```

Si quieres instalar dependencias extras para componentes especificos, puedes instalar las siguientes:

```javascript
# Spark SQL
pip install pyspark[sql]
# pandas API on Spark
pip install pyspark[pandas_on_spark] plotly
```


For the next examples

- Quickstart: DataFrame
	- Viewing Data
	- Selection and Accesing
	- Data
	- Appliying a Funtion
	- Grouping Data
	- Getting Data in/out
	- Working with SQL
- QuickStart: Pandas API on Spark

 I will be using:
 
 - Shell of Debian 11 OS
 - IPython Qtconsole
 - Text editor

## Quickstart: DataFrame

This is a short introduction and quickstart for the PySpark DataFrame API. PySpark DataFrame are lazily evaluate. They are implemented on top of <a href="https://spark.apache.org/docs/latest/rdd-programming-guide.html">RDD</a>. When Spark transforms data, it does not inmediately compute the transformation but plans how to compute later. When actions such as collect() are explicitly called, the computation starts.

There is also other useful information in Apache Spark documentation site, see the latest version of

-  <a href="https://spark.apache.org/docs/latest/sql-programming-guide.html">Spark SQL and DataFrames</a>
-  <a href="https://spark.apache.org/docs/latest/rdd-programming-guide.html">RDD Programming Guide</a>
-  <a href="https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html">Structured Streaming Programming Guide</a>
-  <a href="https://spark.apache.org/docs/latest/streaming-programming-guide.html">Spark Streaming Programming Guide</a>
-  <a href="https://spark.apache.org/docs/latest/ml-guide.html">Machine Learning Library(MLlib) Guide</a>

PySpark applications start with initializing SparkSession which is the entry point of PySpark as below. In case of running it in PySpark shell via pyspark executable, the shell automatically creates the session in the variable spark for users.

```
from pyspark.sql import SparkSession
spark = SparkSession.builder.getOrCreate()
```

## DataFrame Creation

A PySpark DataFrame can be created via pyspark.sql.SparkSession.createDataFrame typically by passing a list of lists, tuples, dictionaries and pyspark.sql.Rows, a pandas DataFrame and RDD consisting of such a list.pyspark.sql.SparkSession.createDataFrame takes the schema argument to specify the schema of the DataFrame. When it is omitted, PySpark infers the corresponding shema by taking a sample from data.

- Create a PySpark DataFrame from a list of rows.
- Create a PySpark DataFrame with an explicit shema
- Create a PySpark DataFrame from a pandas DataFrame

Firstly, you can create a PySpark DataFrame from a list of row

```
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
```

Create a PySpark DataFrame with an explicit schema.

```
df = spark.createDataFrame([
    (1, 2., 'string1', date(2000, 1, 1), datetime(2000, 1, 1, 12, 0)),
    (2, 3., 'string2', date(2000, 2, 1), datetime(2000, 1, 2, 12, 0)),
    (3, 4., 'string3', date(2000, 3, 1), datetime(2000, 1, 3, 12, 0)),
], schema='a long, b double, c string, d date, e timestamp')
df
```

Create a PySpark DataFrame from a pandas DataFrame

```
pandas_df = pd. DataFrame({
    'a': [1, 2, 3],
    'b': [2., 3., 4.],
    'c': ['string1', 'string2', 'string3'],
    'd': [date(2000, 1, 1), date(2000, 2, 1), date(2000, 3, 1)],
    'e': [datetime(2000, 1, 1, 12, 0), datetime(2000, 1, 2, 12, 0), datetime(2000, 1, 3, 12, 0)]
})

df = spark.createDataFrame(pandas_df)

df
```

Create a PySpark DataFrame from RDD consisting of a list of tuples.

```
rdd = spark.sparkContext.parallelize([
    (1, 2., 'string1', date(2000, 1, 1), datetime(2000, 1, 12, 0)),
    (1, 3., 'string2', date(2000, 1, 1), datetime(2000, 1, 2, 12, 0)),
    (3, 4., 'string3', date(2000, 3, 1), datetime(2000, 1, 3, 12, 12, 0))
])

df = spark.createDataFrame(rdd, schema=['a', 'b', 'c', 'd', 'e'])

df
```

The DataFrame created above all have the same result and schema

```
# All DataFrame above result same.
df.show()
df.printSchema()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/df.png)

### Viewing Data

The top rows of a DataFrame can be displayed using DataFrame.show().

```
df.show(1)
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/top_df.png)

The rows can also be show vertically. This is useful when rows are too long to show horizontally.

```
df.show(1, vertical=True)
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/df_vertical.png)

You can see the DataFrame's schema and column names as follows:

```
df.columns

df.printSchema()
```

Show the summary of the DataFrame

```
df.select('a', 'b', 'c').describe().show()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/df_summary.png)

DataFrame.collect() collects the distributed data to the drive side as the local data in Python.

```
df.collect()
```

In order to avoid throwing an out-of-memory exception, use DataFrame.take() or Data.Frame.tail().

```
df.take(1)
``` 

PySpark DataFrame also provides the conversion back to a pandas DataFrame to leverage pandas API. Note that toPandas also collect all data into the driver side that can easily cause an out-of-memory-error when the data is too large to fit into the drive side.

```
df.toPanda()
```

### Selecting and Accesing Data

PySpark DataFrame is lazily evaluated and simply selecting a column does not trigger the computation but it return a column instance.

```
df.a
```

In fact, most column wise operations return columns.

```
from pyspark.sql import Column
from pyspark.sql.functions import upper

type(df.c) == type(upper(df.c)) == type(df.c.isNull())
```

DataFrame.select() takes the column instances that returns another DataFrame.

```
df.select(df.c).show()
```

Assign new Column instance.

```
df.withColumn('upper_c', upper(df.c)).show()
```

![](https://raw.githubusercontent.com/gabrielfernando01/spark/master/image/upper_df.png)

To select a subset of row, use DataFrame.filter().

```
df.filter(df.a == 1).show()
```

