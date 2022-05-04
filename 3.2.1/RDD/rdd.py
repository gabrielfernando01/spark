# RDD Programming Guide
# Import some Spark Spark classes
from pyspark import SparkContext, SparkConf

# Initializing Spark
conf = SparkConf().setAppName(appName).setMaster(master)
sc = SparkContext(conf=conf)

# The appName parameter is a name for your application to show on the cluster UI. master is
# a Spark, Mesos, or Yarn cluster URL, or a special "local" string to run in local mode.

# Using the Shell
# In the PySpark shell, a special interpreter-aware SparkContext is already created for you,
# in the variable called sc. Making your oun SparkContext will not work. You can se wich master
# the context connects to using the --master argument. For example, to run bin/pyspark on
# exactly four cores, use:
$ ./bin/pyspark --master local[4]

# For a complete list of options, run spark-shell --help

# Resilient Distributed Datasets(RDDs)
# RDDs, which is a faul-tolerant collection of elements that can be operated on in parallel.
# There are two ways to create RDDs: parallelizing an existing collection in your driver 
# program, or referencing a dataset in an external storage system.

# Parallelized Collection
# Here is how to create a parallelized collection holding to numbers 1 to 5.
data = [1, 2, 3, 4, 5]
distData = sc.parallelize(data)

# Once created, the distributed dataset(distData) can be operated on in parallel. For example,
# we can cal distData.reduce(lambda a, b: a + b) to add up the elements of the list.

# External Datasets
# Text file RDDs can be created using SparkContext's textFile method. Here is an example invocation:
distFile = sc.textFile("data.txt")

# Once created, distFile can be acted on by dataset operations. For example, we can add up
# the size of all the lines using the map and reduce operations as follows: 
# distFile.map(lambda s: len(s)).reduce(lambda a, b: a + b).

# RDD Operations
# RDD support two types of operations: transformations, which create a new dataset from an
# exising one, and actions, which return a value to the driver program after running a 
# computation on the datase.

# To illustrate RDD basics, consider the simple program below:
lines = sc.textFile("data.txt")
lineLengths = lines.map(lambda s: len(s))
totalLength = lineLengths.reduce(lambda a, b: a + b)

# If we also wanted to use lineLengths again later, we could add:
lineLenghts.persist()

# Passing Function to Spark
# For example, to pass a longer function than can be supportted using lambda, consider the code below:
"""MyScript.py"""
if _name_ == "_main_":
    def myFunc(s):
        words = s.split("")
        return len(words)

    sc = SparkContext(...)
    sc.textFile("file.txt").map(myFunc)

# Printing elemts of an RDD
# To print all elements on the driver, one can use the collect() method to first bring the RDD
# to the driver node thus: rdd.collect().foreach(printls). This can cause the driver to run out
# memory, though, because collect() fetches the entire RDD to a single machine; if you only
# need to print a few elements of the RDD, a safe approach is to use the 
# take():rdd.take(100).foreach(println)

# Working with Key-Values Pairs
# The following code uses the reduceByKey operation on key-value pairs to count how many times
# each line of text occurs in a file:
lines = sc.textFile("data.txt")
pairs = lines.map(lambda s: (s, 1))
counts = pairs.reduceByKey(lambda a, b: a + b)

# We could also use count.sortByKey(), for example, to sort the pairs alphabetically, and finally
# counts.collect() to bring them back to the driver program as a list of objects.










