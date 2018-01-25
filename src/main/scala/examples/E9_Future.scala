package examples


import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import scala.concurrent.duration._

object E9_Future {

  import scala.concurrent.ExecutionContext.Implicits.global

  val future: Future[Int] = Future {
    Range(1, 1000000).sum // Operation that might take some time
  }

  def loadValueFromDataBase(): Future[Int] = ???

  val futurePlus100 = future map { _ + 100 }

  val futureFlatMapped: Future[Int] = future flatMap { value =>
    loadValueFromDataBase() map { dbValue =>
      value + dbValue
    }
  }

  future.onComplete {
    case Success(number) => println(s"Result: $number")
    case Failure(e) => println("No luck this time ;-(")
  }

  val result = Await.result(futurePlus100, 10.seconds)

}
