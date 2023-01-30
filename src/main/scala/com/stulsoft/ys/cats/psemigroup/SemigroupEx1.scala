/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.psemigroup

import com.typesafe.scalalogging.StrictLogging
import cats.Semigroup

/**
 * Using Semigroup for for one class type.
 */
object SemigroupEx1 extends StrictLogging:
  case class Person(fn:String, sn:String)

  given concatPerson:Semigroup[Person] = new Semigroup[Person]:
    override def combine(x: Person, y: Person): Person =
      Person(x.fn + " " + y.fn, x.sn + " " + y.sn)

  private def test1():Unit=
    logger.info("==>test1")
    val p1 = Person("fn1", "sn1")
    val p2 = Person("fn2", "sn2")

    val combined = Semigroup.combine(p1,p2)
    logger.info("{}", combined)

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()

end SemigroupEx1

