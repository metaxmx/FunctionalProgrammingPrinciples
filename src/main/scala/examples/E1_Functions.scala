package examples

object E1_Functions {

  // Function as Type
  type Fun = String => Boolean

  // Function as value
  val print: String => Unit = println

  // Function as parameter
  def printValues(values: Seq[Int], printNumber: Int => Unit): Unit =
    values.foreach(printNumber)

}
