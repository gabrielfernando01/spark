package com.everis.curso.scala

object FunctionalProgramming extends App {

  /**
   * Exercise 1.-
   * Function that receives another function and a list, and returns another list
   * with the result of applying the given function to each of the elements of the list
  */

  // Definition of the function that applies a function to each element of a list
  def aplica_funcion_lista(function: Int => Int, lista: List[Int]): List[Int] = {
    lista.map(function)
  }

  def cuadrado(n: Int): Int = n * n

  println(aplica_funcion_lista(cuadrado, List(1, 2, 3, 4)))

  /**
   * Exercise 2.-
   * Create a function that applies a discount to a price and another that applies IVA to a price.
   * The third function receives a Map collection with the prices and percentages of a
   * shopping cart, and one of the previous functions, and uses the passed function to apply
   * discounts or IVA to the products in the cart, and returns the final price of the cart.
   */

  // Applies a discount to a price based on a percentage.
  def apply_discount(price: Int, discount: Int): Int = {
    price - ((price * discount) / 100)
  }

  // Applies IVA to a price based on a percentage.
  def apply_IVA(price: Int, percentage: Int): Int = {
    price + ((price * percentage) / 100)
  }

  // Calculates the total price of a basket by applying a function to each item
  // @param basket: A Map where keys are prices and values are percentages (discount or VAT)
  // @param function: A function that takes a price and percentage and returns a new price
  // @return: The total price after applying the function to all items
  def price_basket(basket: Map[Int, Int], function: (Int, Int) => Int): Int = {
    // Helper recursive function with an accumulator
    def recurse(items: List[(Int, Int)], acc: Int): Int = items match {
      case Nil => acc
      case (price, percentage) :: tail => recurse(tail, acc + function(price, percentage))
    }

    recurse(basket.toList, 0)
  }

  val basket = Map(1000 -> 20, 500 -> 10, 100 -> 1)
  println("The purchase price after applying discounts is: " + price_basket(basket, apply_discount))
  println("The purchase price after applying VAT is: " + price_basket(basket, apply_IVA))

  /**
   * Exercise 3.-
   * Write a function that receives another Boolean function and a list, and returns another list
   * with the elements of the list that return True when the Boolean function is applied to them.
   */

  // First solution
  // We define the function that verifies if a number is even
  def filterList[A](function: A => Boolean, list: List[A]): List[A] = {
    list.filter(function)
  }

  // We define the function that verifies if a number is even.
  def even(n: Int): Boolean = {
    n % 2 == 0
  }

  // Usage example
  val list = List(1, 2, 3, 4, 5, 6)
  val result = filterList(even, list)
  println(result) // Print: List(2, 4, 6)

  // Second solution
  // We define the function that verifies if a number is even.
  def par(n: Int): Boolean = {
    n % 2 == 0
  }

  // Usage example
  val lista = List(1, 2, 3, 4, 5, 6)
  val resultado = lista.filter(par)
  println(result) // Print: List(2, 4, 6)

  /**
   * Exercise 4.-
   * Write a function that receives a sentence and returns a dictionary with the words it contains
   * and their length.
   */

  // Function that converts a sentence into a dictionary (Map) of words and their lengths
  def lengthWords(sentence: String): Map[String, Int] = {
    val words = sentence.split(" ") // Divide the sentence into words
    val lengths = words.map(_.length) // Calculate the length of each word
    words.zip(lengths).toMap // Combines words and their lengths into a Map
  }

  println(lengthWords("I love Scala"))

  /**
   * Exercise 5.-
   * Write a function that receives a dictionary with the subjects and grades of a student and
   * returns another dictionary with the subjects in capital letters and the grades (grade encoding)
   * corresponding to the grades.
   */

  // First solution
  // Define the grade encoding function
  def encodeGrade(grade: Int): String = {
    if (grade < 0 || grade > 100) "Invalid" // Handle invalid grades
    else grade match {
      case g if g >= 90 => "A"
      case g if g >= 80 => "B"
      case g if g >= 70 => "C"
      case g if g >= 60 => "D"
      case _ => "F"
    }
  }

  // Function to transform the dictionary of subject and grades
  def transformGrades(grades: Map[String, Int]): Map[String, String] = {
    grades.map { case (subject, grade) => (subject.toUpperCase, encodeGrade(grade))
    }
  }

  val studentGrades = Map("Math" -> 95, "Science" -> 82, "History" -> 65, "Art" -> 50, "Physics" -> 101)
  val transformed = transformGrades(studentGrades)
  println(transformed)

  // Second solution
  // Function to determine the grade based on the score
  def grade(score: Double): String = {
    if (score < 5) {
      "SS"
    } else if (score < 7) {
      "AP"
    } else if (score < 9) {
      "NT"
    } else if (score < 10) {
      "SB"
    } else {
      "MH"
    }
  }

  // Function to apply the grade function to a map of subjects and scores
  def applyGrade(scores: Map[String, Double]): Map[String, String] = {
    scores.map { case (subject, score) =>
      subject.toUpperCase -> grade(score)
    }
  }

  // Example usage
  val dicc = applyGrade(Map(
    "Mathematics" -> 6.5,
    "Physics" -> 5,
    "Chemistry" -> 3.4,
    "Economic" -> 8.2,
    "History" -> 9.7,
    "Programming" -> 10
  ))

  // Print the result
  println(dicc)

}