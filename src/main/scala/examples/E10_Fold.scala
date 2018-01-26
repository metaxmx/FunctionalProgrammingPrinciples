package examples

import scala.annotation.tailrec

object E10_Fold {

  def sum(numbers: Seq[Int]): Int = numbers.fold(0)(_ + _)

  def product(numbers: Seq[Int]): Int = numbers.fold(1)(_ * _)

  def max(numbers: Seq[Int]): Int = numbers.fold(Int.MinValue)((aggregate, next) => if (aggregate < next) next else aggregate)

  def mean(numbers: Seq[Double]): Double = {
    val (sum, count) = numbers.foldLeft((0.0, 0)) {
      case ((currentSum, currentCount), nextNumber) => (currentSum + nextNumber, currentCount + 1)
    }
    if (count == 0) Double.NaN else sum / count
  }

  def combineLines(lines: Seq[String]): String = lines.fold("")(_ + "\n" + _)

  @tailrec
  def sum(numbers: List[Int], sumSoFar: Int): Int = numbers match {
    case Nil => 0
    case head :: tail => sum(tail, sumSoFar + head)
  }

  def sumX(numbers: Seq[Int]) = {
    (0 /: numbers)(_ + _)
  }


  println(sum(Range(1, 10000).toList))

}
