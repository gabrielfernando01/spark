package com.everis.curso.scala

object ScalaLauncher extends App {

  //Hello world

  /*
    Hello world
    How are you?
   */

  /**
   * Basics concepts
   */

  val z: Int = 3
  var y: Int = 6                        // Not recommended

  val cincoInt: Int = 5
  val cincoByte: Byte = 5
  val cincoLong: Long = 5
  val cincoShort: Short = 5
  val cincoFloat: Float = 5.0f          // Float: precision 7
  val cincoDouble: Double = 5.0         // Double: precision 15
  val cincoString: String = "5"

  println("This is the variable: " + cincoInt)

  val formatString: String = "La temperatura máxima de hoy será de %d y la mínima de %d"
  println(String.format(formatString, 40, 27))

  val miSecuencia: Seq[String] = Seq("Hi", "how", "are", "you")
  val miSecuenciaDos: Seq[Any] = Seq("Hello", "how", "are", "you", 67, true)
  val miLista = List("My", "name", ,"is", "Pablo", 27)

  println(miSecuencia(0))
  println(miLista(0))

  // Seq(<List>, <Vector>, <ArrayBuffer>): ordered collection of elements that may contain duplicate values.
  val seqInt: Seq[Int] = Seq(2, 4, 5, 6, 7, 2, 7, 10)
  val seqInt2 = Seq(3, 6)
  println("The third value is: " + seqInt(2))
  println("The maximum value is: " + seqInt.max)
  println("The minimum value is:" + seqInt.min)
  println("The first value is: " + seqInt.head)
  println("The last values is: " + seqInt.last)
  println("Returns all elements of the sequence except the first: " + seqInt.tail)
  println("Returns the first n elements of the sequence: " + seqInt.take(5))
  println(seqInt.contains(7))
  println(seqInt.drop(3))
  println(seqInt.intersect(seqInt2))
  println(seqInt.distinct)
  println(seqInt.filter( _ > 4))
  println("Returns a new sequence sorted in ascending order: " + seqInt.sorted)
  println("Reverses the order of the elements in the sequence: " + seqInt.reverse)
  println("Groups the elements of the sequence according to a key function: " + seqInt.groupBy(_ % 2 == 0))

  // zip: Combine two sequences into corresponding pairs
  val seq1 = Seq(4, 1, 5)
  val seq2 = Seq("a", "x", "z")
  println(seq1.zip(seq2))

  // flatten: Flattens a sequence of sequences into a single sequences
  val seq3 = Seq(Seq(3, 1), Seq(8, 0))
  println(seq3)
  
  // partition: Divide the sequence into two groups according to a condition.
  val seq4 = Seq(3, 7, 2, 9, 4)
  println(seq.partition(_ > 5)) 
  
  println("Checks if at least one element meets a condition: " + seq4.exists(_ > 5))
  println("Checks if all elements meet a condition: " + seq4.forall(_ > 5))

  /**
   * Transformations: map, flatMap, collect
   */
  // The map function applies a transformation to each element of a collection and returns a new collection with the results.
  val number = List(1, 2, 3, 4, 5)
  val multiple = number.map(x => x * 7)
  println(multiple)

  // flatMap: applies a function to each element in a collection and "flattens" the results
  val words = List("Hello", "world")
  // Convert each word to a list of characters and flatten the results
  val characters = words.flatMap(word => word.toList)
  println(characters)

  val lists = List(1, 2, 3)
  // Generate a list of pairs for each number
  val pares = lists.flatMap(n => List(n, n * 2))
  println(pares)  // For each number n, a list List(n, n*2) is generated, and flatMap flattens them into a single list.

  // collect applies a partial function (defined with case) to the elements of a collection that match the specified patterns
  // and returns a new collection with the results.
  val mix = List(1, "Two", 3, "Four", 5)
  // Just process the integers and duplicate them
  val onlyIntegers = mix.collect {
    case n: Int => n * 2
  }
  print(onlyIntegers)

  val numbers = List(-3, -2, 10, -5, 7)
  // Filter and transform only positive numbers
  val positive = numbers.collect {
    case n if n > 0 => n * 10
  }
  println(positive)

  /**
   * Filtered
   */
  // filter retains elements in a collection that meet a given condition and discards those that do not.
  val numeros = List(1, 2, 4, 5, 6)
  val pares = numeros.filter(x => x % 2 == 0)
  println(pares)

  // filterNot is the opposite of filter: it retains elements that do not meet the condition.
  val impares = numeros.filterNot(x => x % 2 == 0)
  println(impares)

  /**
   * FUNCIÓN MAP & FOREACH
   */
  // Applies a function to each element of the sequence and returns a new sequence with the results.
  println(seqInt.map(x => x + 3))
  println(seqInt.map(_ + 5))

  seqInt.map(x => println(x))
  seqInt.foreach(x => println(x))

  println(seqInt.foreach(x => x + 1))
  println(seqInt.foreach(_ + 8))

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
