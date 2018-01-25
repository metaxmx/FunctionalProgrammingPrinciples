package examples

object E8_ForComprehension {

  case class Person(lastName: String, firstName: Option[String], deceased: Boolean)

  def loadPerson(): Option[Person] = ???

  def getCreditCardNumber(firstName: String, lastName: String): Option[String] = ???

  def creditCardValid(cardNumber: String): Boolean = ???

  val creditReport: Option[String] = for {
    person <- loadPerson() if !person.deceased
    firstName <- person.firstName
    fullName = s"$firstName ${person.lastName}"
    creditCardNumber <- getCreditCardNumber(firstName, person.lastName) if creditCardValid(creditCardNumber)
  } yield {
    s"Credit report for $fullName: Card number $creditCardNumber valid"
  }

}
