package examples

import java.time.{DayOfWeek, ZoneOffset}

import scala.util.{Failure, Try, Success}

object E3_PureFunctions {

  import java.time.LocalDateTime

  var lastCheckedMillis: Long = _

  def nonPureDateMillis(): Long = {
    // Side Effect: Read global state
    val now = LocalDateTime.now()
    // Side Effect: Throw Exception
    if (now.getDayOfWeek == DayOfWeek.MONDAY) throw new IllegalStateException("Mondays not allowed")
    val millis = now.toInstant(ZoneOffset.UTC).toEpochMilli
    // Side Effect: Change global state
    lastCheckedMillis = millis
    millis
  }

  def pureDateMillis(now: LocalDateTime): Try[Long] = {
    now.getDayOfWeek match {
      case DayOfWeek.MONDAY => Failure(new IllegalStateException("Mondays not allowed"))
      case _ => Success(now.toInstant(ZoneOffset.UTC).toEpochMilli)
    }
  }

}
