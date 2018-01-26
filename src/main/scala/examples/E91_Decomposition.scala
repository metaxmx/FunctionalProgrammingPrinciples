package examples

object E91_Decomposition extends App {

  case class Person(firstName: String, lastName: Option[String], age: Option[Int], deceased: Boolean)

//  val personList: List[Person] = ???
//
//  personList match {
//    case Person(_, _, Some(age), _) :: Nil if age > 18 => // Do Something
//    case _ =>
//  }

  val regex = "^start ([0-9]+) end$".r

  val string = "start 1337 end"

  string match {
    case regex(num) => println(s"Number: $num")
    case _ => println("Not matched")
  }

  object LegalAgePerson {

    def unapply(arg: Person): Option[Int] = arg.age.filter(_ >= 18)

  }

  val ursula = Person("Ursula", Some("TestPerson"), Some(88), false)
  val klaus = Person("Klaus", None, Some(5), false)
  val erwin = Person("Erwin", None, None, true)

  Seq(ursula, klaus, erwin).foreach {
    case person @ LegalAgePerson(age) => println(s"${person.firstName} has age $age")
    case person => println(s"${person.firstName} is not of legal age")

  }


}
