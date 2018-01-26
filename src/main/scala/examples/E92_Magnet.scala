package examples

import scala.language.implicitConversions

object E92_Magnet {

  class Overload {

    def foo(param: FooParam): Unit = ???

  }

  sealed trait FooParam
  case class FooParamInt(int: Int) extends FooParam
  case class FooParamIntList(int: Seq[Int]) extends FooParam
  case class FooParamIntFun(fn: Int => Unit) extends FooParam
  case class FooParamString(str: String) extends FooParam
  case class FooParamStringList(str: Seq[String]) extends FooParam
  case class FooParamStringFun(fn: String => Unit) extends FooParam

  val overload = new Overload

  object FooParam {

    implicit def paramFromInt(int: Int): FooParam = FooParamInt(int)

    implicit def paramFromIntList(int: Seq[Int]): FooParam = FooParamIntList(int)

    implicit def paramFromIntFun(int: Int => Unit): FooParam = FooParamIntFun(int)

    implicit def paramFromStr(str: String): FooParam = FooParamString(str)

    implicit def paramFromStrList(str: Seq[String]): FooParam = FooParamStringList(str)

    implicit def paramFromStrFun(str: String => Unit): FooParam = FooParamStringFun(str)

  }

  overload.foo(13)

  overload.foo("Test")

  overload.foo(Seq(4, 5, 6))

  val strFun: String => Unit = println

  overload.foo(strFun)


}
