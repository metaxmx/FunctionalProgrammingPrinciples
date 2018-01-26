package examples

object E90_Stream {

  def streamFromIterator[A](it: java.util.Iterator[A]): Stream[A] =
    if (it.hasNext)
      Stream.cons(it.next(), streamFromIterator(it))
    else
      Stream.empty


  val list = new java.util.LinkedList[String]()
  list.add("One")
  list.add("Two")
  list.add("Three")
  val iterator = list.iterator()

  val stream = streamFromIterator(iterator)
  println("Stream " + stream.take(5).toList)
  println("List " + stream.toList)

}
