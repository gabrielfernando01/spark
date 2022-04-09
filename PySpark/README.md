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