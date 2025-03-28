package com.everis.curso.scala

object FunctionalProgramming extends App {

  /*
   * Exercise 1.-
   * Function that receives another function and a list, and returns another list
   * with the result of applying the given function to each of the elements of the list
  */

  // Definition of the function that applies a function to each element of a list
  def aplica_funcion_lista(funcion: Int => Int, lista: List[Int]): List[Int] = {
    lista.map(funcion)
  }

  def cuadrado(n: Int): Int = n * n

  println(aplica_funcion_lista(cuadrado, List(1, 2, 3, 4)))

  /*
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

  /*
   * Exercise 3.-
   * Write a function that receives another Boolean function and a list, and returns another list
   * with the elements of the list that return True when the Boolean function is applied to them.
   */



  /*
   * Exercise 4.-
   * Write a function that receives a sentence and returns a dictionary with the words it contains
   * and their length.
   */



  /*
   * Exercise 5.-
   * Write a function that receives a dictionary with the subjects and grades of a student and
   * returns another dictionary with the subjects in capital letters and the grades corresponding
   * to the grades.
   */




  /*
   * Exercise 6.-
   * Build a function that allows you to search for properties based on a given budget.
   * The function will receive a list of properties and a price as input, and will return
   * another list of properties whose price is less than or equal to the given price. Properties
   * in the returned list must add a new pair to each dictionary with the property price, where
   * the price of a property is calculated using the following formula based on the zone:
   *
   * Zone A: price = (meters x 1000 + rooms x 5000 + garage x 15000) x (1 - age / 100)
   * Zone B: price = (meters x 1000 + rooms x 5000 + garage x 15000) x (1 - age / 100) x 1.5
   *
   * floors = [{'year': 2000, 'meters': 100, 'rooms': 3, 'garage': True, 'zone': 'A'},
   * {'year': 2012, 'meters': 60, 'rooms': 2, 'garage': True, 'zone': 'B'},
   * {'year': 1980, 'meters': 120, 'rooms': 4, 'garage': False, 'zone': 'A'},
   * {'year': 2005, 'meters': 75, 'rooms': 3, 'garage': True, 'zone': 'B'},
   * {'year': 2015, 'meters': 90, 'rooms': 2, 'garage': False, 'zone': 'A'}]
   */



}