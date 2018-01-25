package examples

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.SECONDS

object E5_Currying {

  type Request = Any
  type Response = Any

  // Function which takes 1 argument Request and return function Response => Unit
  type LogRequestFuncCurried = Request => Response => Unit

  val logWithTimeStamp: LogRequestFuncCurried = req => {
    val begin = LocalDateTime.now()
    res => {
      val end = LocalDateTime.now()
      println("Response took " + SECONDS.between(begin, end) + " seconds")
    }
  }

}
