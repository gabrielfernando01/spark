package com.everis.curso.scala

object ScalaLauncher extends App {

  //Hello world

  /*
    Hello world
    How are you?
   */

  /**
   * CONCEPTOS BÁSICOS
   */

  val z: Int = 3
  var y: Int = 6                        // No recomendado

  val cincoInt: Int = 5
  val cincoByte: Byte = 5
  val cincoLong: Long = 5
  val cincoShort: Short = 5
  val cincoFloat: Float = 5.0f          // Float: precisión 7
  val cincoDouble: Double = 5.0         // Double: precisión 15
  val cincoString: String = "5"

  println("Esto es la variable: " + cincoInt)

  val formatString: String = "La temperatura máxima de hoy será de %d y la mínima de %d"
  println(String.format(formatString, 40, 27))

  val miSecuencia: Seq[String] = Seq("Hola", "que", "tal", "estas")
  val miSecuenciaDos: Seq[Any] = Seq("Hola", "que", "tal", "estas", 67, true)
  val miLista = List("Me", "llamo", "Pablo", 27)

  println(miSecuencia(0))
  println(miLista(0))

  val mySeqInt: Seq[Int] = Seq(2, 4, 5, 6, 7, 2, 7, 10)
  val mySeqInt2 = Seq(3, 6)
  println("El tercer valor es: " + mySeqInt(2))
  println("El máximo valor es: " + mySeqInt.max)
  println("El último valor es: " + mySeqInt.last)
  println(mySeqInt.contains(7))
  println(mySeqInt.drop(3))
  println(mySeqInt.intersect(mySeqInt2))
  println(mySeqInt.distinct)

  /**
   * FUNCIÓN MAP & FOREACH
   */
  println(mySeqInt.map(x => x + 3))
  println(mySeqInt.map(_ + 5))

  mySeqInt.map(x => println(x))
  mySeqInt.foreach(x => println(x))

  println(mySeqInt.foreach(x => x + 1))
  println(mySeqInt.foreach(_ + 8))

  val personasSeq = Seq(("Alejadro", 27), ("Estephany", 25), ("Juan", 20))

  println(personasSeq.map(_._2 - 2))
  println(personasSeq.map(x => (x._1 + "-", x._2 + 3)))

  /**
   * MAP (key -> value)
   */

  val paises = Map(
    "SP" -> "España",
    "PR" -> "Portugal",
    "AR" -> "Argentina"
  )

  println(paises("SP"))
  println(paises.contains("FR"))
  println(paises.keys)
  println(paises.values.last)

  /**
   * VARIABLES LOCAL Y GLOBAL
   */

  val x = 3
  def f(x: Int): Int = x + 1

  val resultado = {
    val x = f(3)                      //> 3 + 1 = 4
    x * x                             //> 4 * 4 = 16
  } + x                               //> 19


  /**
   * Scala function definition
   */

  /**
   * Función dedicada a la suma de dos variables
   *
   * @param x     primera variable de entrada: Int
   * @param y     segunda variable de entrada: Int
   * @return      valor resultado: Int
   */

  def add1(x: Int, y: Int): Int = {
    x + y
  }

  val listPeople: List[(String, Int)] = List(("Steve", 29), ("Kenia", 26), ("Fred", 30))

  // Ejercicio: Hallar la edad media del grupo de personas

  def averageAge(people: List[(String, Int)]): Double = {
    people.map(_._2).sum.toDouble / people.length.toDouble
  }
  println("The average age is: " + averageAge(listPeople))

  // Ejercicio: Hallar el nombre de la persona con más edad
  def oldestPerson(people: List[(String, Int)]): String = {
    val ageMax = people.map(_._2).max
    people.filter(x => x._2 == ageMax)(0)._1
  }
  println("The person oldest is: " + oldestPerson(listPeople))

  /**
   * MATCH
   */
  def whatSpendToday(day: String): Unit = {
    day match {
      case "Saturaday" => println("Party")
      case "Sunday" => println("Sleep")
      case _ => println("Programming in Scala")
    }
  }
  whatSpendToday("Saturday")
  whatSpendToday("anything")

  /**
   * ANY & OPTION & EITHER
   */

  def division(x: Double, y: Double): Any = {
    y match {
      case 0 => "Estas dividiendo entre 0"
      case _ => x/y
    }
  }
  println(division(5,0))
  println(division(5.0,2.0))

  /*
    Option:
      - None: No ha ido bien la operación pero evitamo el fallo
      - Some: Indica que ha ido bien
   */
  def divisionOption(x: Int, y: Int): Option[Int] = {
    y match {
      case 0 => None
      case _ => Some(x/y)
    }
  }
  println(divisionOption(5,0))
  println(divisionOption(5,2).get)

  /*
    Either:
      Left -> No ha ido bien la operación pero evitamo el fallo. Nos permite devolver un string
      Right -> Indica que ha ido bien
   */
  def divisionEither(x: Int, y: Int): Either[String, Int] = {
    y match {
      case 0 => Left("No se puede dividir entre 0")
      case _ => Right(x/y)
    }
  }
  println(divisionEither(5,0).left.get)
  println(divisionEither(5,2).right.get)

  /*
    CURRIFICACIÓN
   */

  def add(x: Int)(y: Int): Int = x + y

  val add1 = add(5)(6)              // 5 + 6
  val add2 = add(4)_                // Función que suma 4
  val add3 = add2(7)                // 4 + 7

  println(add1)

  println(add3)

  def multOcho(a: Int)(b: Int = 8): Int = a * b
  println(multOcho(2)(15))
  println(multOcho(7)())

  /*
    FOLDLEFT & FOLDRIGHT

      def foldLeft[B](z: B)(op: (B, A) ⇒ B): B

      lista.foldRight(z)(f) => f(a, f(b, f(c, f(d, z))))

   */

  val stringList: List[String] = List("-Hola", "que", "tal")

  println("foldright: " + stringList.foldRight("-")(_ + _))
  println("foldLeft: " + stringList.foldLeft("-")(_ + _))

  val intList: List[Int] = List(2, 4, 6, 9)
  println("foldright: " + intList.foldRight(0)(_ + _))
  println("foldLeft: " + intList.foldLeft(1)(_ * _))

  /**
   * EJERCICIOO 1: FUNCIÓN QUE IMPRIMA NÚMEROS DEL 1 AL 12
   */

  for (i <- 1 to 12) {
    print(i + " ")
  }
  println()

  1.to(12).foreach(print)

  1.to(12).map(print)
  println()
  1.to(12).map(print(_))
  println()
  1.to(12).map(x => print(x))
  println()

  /**
   * EJERCICIOO 2: FUNCIÓN QUE DEVUELVA EL ÚLTIMO VALOR DE UNA LISTA
   */

  val listaInt: List[Int] = List(2, 1, 4, 5)
  val listaStg: List[String] = List("a", "n", "t", "h")

  def getLastElement[A](inputList: List[A]): A = {
    inputList.last
  }
  println("Último elemento lista Int: " + getLastElement(listaInt))
  println("Último elemento lista Str: " + getLastElement(listaStg))

}
