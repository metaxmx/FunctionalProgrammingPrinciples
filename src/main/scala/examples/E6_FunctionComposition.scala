package examples

object E6_FunctionComposition {

  case class Person(firstName: String, lastName: String, age: Option[Int])

  def loadPersons(): Seq[Person] = ???

  def hasAge(predicate: Int => Boolean)(person: Person): Boolean = person.age.exists(predicate)

  def legalAge(age: Int): Boolean = age >= 18

  def named(firstName: String)(person: Person): Boolean = person.firstName == firstName

  val namedCharles: Person => Boolean = named("Charles")

  def fullName(person: Person): String = s"${person.firstName} ${person.lastName}"

  val nameRegisterForAdultCharles =
    loadPersons()
      .filter(hasAge(legalAge))
      .filter(namedCharles)
      .map(fullName)
      .mkString("Name Register: ", ", ", "")

}
