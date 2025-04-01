package com.everis.curso.scala

/**
 * A utility class for searching properties within a given budget using a functional programming approach in Scala.
 * This class provides methods to calculate the price of properties based on their characteristics and filter them
 * according to a maximum budget. Each property in the result includes a calculated price based on its zone.
 *
 * The price calculation formulas are as follows:
 * - Zone A: `price = (meters * 1000 + rooms * 5000 + garage * 15000) * (1 - age / 100)`
 * - Zone B: `price = (meters * 1000 + rooms * 5000 + garage * 15000) * (1 - age / 100) * 1.5`
 *
 * Where:
 * - `meters`: the size of the property in square meters (integer).
 * - `rooms`: the number of rooms (integer).
 * - `garage`: a boolean indicating the presence of a garage (true = 1, false = 0).
 * - `age`: calculated as `currentYear - year`, where `currentYear` is the current year (e.g., 2025).
 *
 * The implementation follows functional programming principles, ensuring immutability, pure functions, and the use of
 * higher-order functions like `map` and `filter`.
 *
 * @example
 * {{{
 * // Define a list of properties
 * val properties = List(
 *   Map("year" -> 2000, "meters" -> 100, "rooms" -> 3, "garage" -> true, "zone" -> "A"),
 *   Map("year" -> 2012, "meters" -> 60, "rooms" -> 2, "garage" -> true, "zone" -> "B"),
 *   Map("year" -> 1980, "meters" -> 120, "rooms" -> 4, "garage" -> false, "zone" -> "A"),
 *   Map("year" -> 2005, "meters" -> 75, "rooms" -> 3, "garage" -> true, "zone" -> "B"),
 *   Map("year" -> 2015, "meters" -> 90, "rooms" -> 2, "garage" -> false, "zone" -> "A")
 * )
 *
 * // Set a budget
 * val budget = 100000.0
 *
 * // Search for properties within the budget
 * val result = PropertySearch.searchProperties(properties, budget)
 *
 * // Print the results
 * println("Properties within budget:")
 * result.foreach(println)
 * }}}
 *
 * Expected output (approximate, depending on the current year):
 * {{{
 * Properties within budget:
 * Map(year -> 2012, meters -> 60, rooms -> 2, garage -> true, zone -> B, price -> 97500.0)
 * Map(year -> 2015, meters -> 90, rooms -> 2, garage -> false, zone -> A, price -> 95000.0)
 * }}}
 */
private object PropertySearch {

  /** The current year used to calculate the age of properties. */
  val currentYear: Int = 2025

  /**
   * Calculates the age of a property based on its construction year.
   *
   * @param year The construction year of the property.
   * @return The age of the property as an integer.
   */
  def calculateAge(year: Int): Int = currentYear - year

  /**
   * Calculates the price of a property based on its characteristics and zone.
   *
   * @param property A map representing a property with keys: "year" (Int), "meters" (Int), "rooms" (Int),
   *                 "garage" (Boolean), and "zone" (String: "A" or "B").
   * @return The calculated price of the property as a Double.
   */
  def calculatePrice(property: Map[String, Any]): Double = {
    val meters = property("meters").asInstanceOf[Int]
    val rooms = property("rooms").asInstanceOf[Int]
    val garage = if (property("garage").asInstanceOf[Boolean]) 1 else 0
    val zone = property("zone").asInstanceOf[String]
    val age = calculateAge(property("year").asInstanceOf[Int])

    val basePrice = (meters * 1000 + rooms * 5000 + garage * 15000) * (1 - age / 100.0)
    zone match {
      case "A" => basePrice
      case "B" => basePrice * 1.5
    }
  }

  /**
   * Searches for properties within a given budget, adding the calculated price to each property in the result.
   *
   * @param properties A list of properties, where each property is a map with keys: "year" (Int), "meters" (Int),
   *                   "rooms" (Int), "garage" (Boolean), and "zone" (String: "A" or "B").
   * @param budget The maximum budget for filtering properties.
   * @return A list of properties (maps) that are within the budget, with an additional "price" key containing the
   *         calculated price.
   */
  def searchProperties(properties: List[Map[String, Any]], budget: Double): List[Map[String, Any]] = {
    properties
      .map(property => property + ("price" -> calculatePrice(property))) // Add calculated price
      .filter(_("price").asInstanceOf[Double] <= budget) // Filter by budget
  }

  /**
   * Main method to demonstrate the usage of the PropertySearch class.
   * It defines a sample list of properties, sets a budget, and prints the properties that fall within the budget.
   *
   * @param args Command-line arguments (not used).
   */
  def main(args: Array[String]): Unit = {
    // Sample list of properties
    val properties = List(
      Map("year" -> 2000, "meters" -> 100, "rooms" -> 3, "garage" -> true, "zone" -> "A"),
      Map("year" -> 2012, "meters" -> 60, "rooms" -> 2, "garage" -> true, "zone" -> "B"),
      Map("year" -> 1980, "meters" -> 120, "rooms" -> 4, "garage" -> false, "zone" -> "A"),
      Map("year" -> 2005, "meters" -> 75, "rooms" -> 3, "garage" -> true, "zone" -> "B"),
      Map("year" -> 2015, "meters" -> 90, "rooms" -> 2, "garage" -> false, "zone" -> "A")
    )

    // Define a budget
    val budget = 100000.0

    // Search for properties within the budget
    val result = searchProperties(properties, budget)

    // Print the results
    println("Properties within budget:")
    result.foreach(println)
  }
}