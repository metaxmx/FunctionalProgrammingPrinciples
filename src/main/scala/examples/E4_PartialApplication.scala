package examples

object E4_PartialApplication {

  def sum(x: Int, y: Int): Int = x + y

  def sum5(y: Int): Int = sum(5, y)

  val sum99: Int => Int = sum(99, _)

}
