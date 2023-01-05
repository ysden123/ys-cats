/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.peq

import cats.Eq
import cats.syntax.eq.*
import cats.instances.option.*
import com.typesafe.scalalogging.StrictLogging

object EqEx1 extends StrictLogging:
  private val eqInt = Eq[Int]

  private def test1(): Unit =
    logger.info("==>test1")
    var r = eqInt.eqv(123, 123)
    logger.info("r = {}", r)

    r = eqInt.eqv(123, 321)
    logger.info("r = {}", r)

  /*
      r = eqInt.eqv(123, "321") // Error
  */

  private def test2(): Unit =
    logger.info("==>test12")
    var r = 123 === 123
    logger.info("r = {}", r)

    r = 123 === 321
    logger.info("r = {}", r)

    r = 123 =!= 321
    logger.info("r = {}", r)

  /*
      r = 123 === "321" // Error
  */

  private def test3(): Unit =
    logger.info("==>test3")

/*
    var r = Some(1) === None // Error
*/

    var r = (Some(1): Option[Int]) === (None: Option[Int])
    logger.info("r = {}", r)

    r = Option(1) === Option.empty[Int]
    logger.info("r = {}", r)

    r = (Some(1): Option[Int]) === (Some(3 - 2): Option[Int])
    logger.info("r = {}", r)

    r = (Some(1): Option[Int]) =!= (None: Option[Int])
    logger.info("r = {}", r)

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()
    test2()
    test3()
