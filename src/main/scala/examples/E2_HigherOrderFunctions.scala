package examples

object E2_HigherOrderFunctions {

  // General Function composition
  def compose[A, B, C](fun: A => B, nextFun: B => C): A => C = {
    a => nextFun(fun(a))
  }

  // Apply given function to generic collection of values
  def forEach[A](values: TraversableOnce[A], consume: A => Unit): Unit = values.foreach(consume)

}
