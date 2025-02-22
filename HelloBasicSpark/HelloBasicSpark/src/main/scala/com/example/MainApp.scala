package com.example

import org.apache.spark.sql.SparkSession

object MainApp {
  def main(args: Array[String]): Unit = {
    // Crear una sesión de Spark
    val spark = SparkSession.builder()
      .appName("SparkScalaExample")
      .master("local[*]") // Ejecutar en modo local
      .getOrCreate()

    // Código de ejemplo: Leer un DataFrame desde una lista
    val data = Seq(("Alice", 34), ("Bob", 45), ("Cathy", 29))
    val df = spark.createDataFrame(data).toDF("Name", "Age")

    // Mostrar el DataFrame
    df.show()

    // Detener la sesión de Spark
    spark.stop()
  }
}
