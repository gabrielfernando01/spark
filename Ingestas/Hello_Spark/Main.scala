// ================================================================================================

package org.banco.delplan

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType

object Main {

    def main(args: Array[String]): Unit = {

        val sS = SparkSession
            .builder()
            .master(master = "local")
            .appName(name = "Hello Spark")
            .getOrCreate()

        val sC = sS.sparkContext

        val rdd1 = sC.parallelize(List(1, 2, 3, 4, 5))
        // println(rdd1.collect().toList)
        
        val rdd2 = rdd1.map(x => x * 2)
        // println(rdd2.collect().toList)

        val rdd3 = rdd2.map(x => this.esPar(x))
        println(rdd3.persist().collect().toList)

        println(rdd2.reduce((x, y) => x + y))

        val numeros = List(
            Tuple3(1, "Uno", "One"),
            Tuple3(2, "Dos", "Two"),
            Tuple3(3, "Tres", "Three"),
            Tuple3(4, "Cuatro", "Four"),
            Tuple3(5, "Cinco", "Five"))

        val rdd4 = sC.parallelize(numeros)
        val rdd5 = rdd4.filter(x => x._1 > 3)
        println(rdd5.collect().toList)

        val nuemros1 = List(
            "1, Uno, One;2, Dos, Two;3, Tres, Three;4, Cuatro, Four;5, Cinco, Five"
        )
        val rdd6 = sC.parallelize(numeros1)
        val rdd7 = rdd6.map(x => x.split(regex = ";"))
        val rdd8 = rdd7.flatMap(x => x)
        val rdd9 = rdd8.map(x => x.split(regex = ","))
        // val rdd10 = rdd9.map(x => Tuple3(x(0), x(1), x(2)))
        // println(rdd10.collect().toList)
        val rdd11 = rdd9.map(x => Row(x(0).toInt, x(1), x(2)))

        println(rdd11.collect().toList)

        val schm = new StructType()
            .add( name = "id", IntegerType)
            .add( name = "nombre", StringType)
            .add( name = "name", StringType)

        /* val df = sS.read
            .format("parquet")
            .schema()
            .options()
            .load() */

        val df = sS.createDataFrame(rdd11, schm)
        df.show()

    }

    def esPar(x: Int): Boolean = {

        if (x % 2 == 0) {
            return true
        } else {
            return false
        }

    }

}
