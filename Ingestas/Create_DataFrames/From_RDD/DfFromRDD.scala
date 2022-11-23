// ================================================================================================

package org.client.test

import org.apache.spark.sql.SparkSession

object main{

    def main(args: Array[String]): Unit = {

        val spark: SparkSession = SparkSession.builder()
        .master( master = "local[1]").appName( name = "SparkByExample.com")
        .getOrCreate()

        import spark.implicit._

        val columns = Seq("language", "users_count")
        val data = Seq("Java", "2000"), ("Python", "10000"), ("Scala", "3000"))

        // Spark Create DataFrame from RDD

        val rdd = spark.SparkContext.parallelize(data)

        val dfFromRDD1 = rdd.toDF()
        dfFromRDD1.printSchema()

    }

}
