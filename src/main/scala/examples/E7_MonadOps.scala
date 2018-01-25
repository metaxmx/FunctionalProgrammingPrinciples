package examples

object E7_MonadOps {

  trait ExampleMonad[+A] {

    // Transform value of type A to type B
    def map[B](f: A => B): ExampleMonad[B]

    // Transform value of type A to type Monad[B]
    def flatMap[B](f: A => ExampleMonad[B]): ExampleMonad[B]

    // Filter Monad values by predicate
    def filter(p: A => Boolean): ExampleMonad[A]

  }

}
