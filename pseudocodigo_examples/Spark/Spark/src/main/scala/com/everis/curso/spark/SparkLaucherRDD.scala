package com.everis.curso.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object SparkLaucherRDD extends App {

  implicit val spark = SparkSession.builder()
    .appName("Apache Sparl App")
    .config("spark.master", "local")
    .getOrCreate()

  val sc = spark.sparkContext

  /**
   * RDD
   */

  /*
    Crear un RDD con 3 particiones a partir de un dataset generado
   */

  val mySeq: Seq[Int] = Seq(34, 32, 543, 234, 23, 67)

  val numerosRDD: RDD[Int] = sc.parallelize(mySeq, 3)

  val maxValue: Int = numerosRDD.max()
  println("El valor máximo del RDD es: " + maxValue)

  val minValue: Int = numerosRDD.min()
  println("El valor mínimo del RDD es: " + minValue)

  val suma = maxValue + minValue

  println("la suma es: " + suma)


  val lorenRDD: RDD[String] = sc.textFile("src/main/resources/in/LorenIpsum.txt", 3)
  lorenRDD.foreach(println)

  lorenRDD.take(3).foreach(println)

  /*
    EJERCICIO 1. HACER CONTADOR DE PALABRAS
   */

  val palabrasRDD = lorenRDD.flatMap(linea => linea.split(" ")) //.cache() = persist("MEMORY_ONLY")

  val palabrasMaped = palabrasRDD.map(clave => (clave, 1))
//    .map(clave => (clave, 1))
//    .reduceByKey(_ + _)
//    .sortBy(_._2, false)
//    .coalesce(1)

  palabrasRDD.foreach(println)

//  Thread.sleep(120000)

  /*
   .flatMap()
   */

  /**
   *
   * EJERCICIO 3. Realiza un filtrado del RDD anterior quedándonos únicamente con las palabras de tamaño 6 o superior.
   * Luego, transforma esas palabras a mayúsculas. Mostrar unicamente el 25% de las palabras.
   *
   */

  // .filter()


}
