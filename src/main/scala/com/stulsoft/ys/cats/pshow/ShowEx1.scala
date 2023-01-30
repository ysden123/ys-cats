/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.pshow

import cats.Show
import cats.syntax.show.*
import com.typesafe.scalalogging.StrictLogging

object ShowEx1 extends StrictLogging:
  private val showInt = Show.apply[Int]

  /**
   * Using default instances
   */
  private def test1(): Unit =
    logger.info("==>test1")
    val s1 = showInt.show(123)
    logger.info("s1 = {}", s1)

  /**
   * Using interface syntax
   */
  private def test2():Unit =
    logger.info("==>test2")
    val s1 = 123.show
    logger.info("s1 = {}", s1)

  private def test3():Unit =
    logger.info("==>test3")
    val s1 = 123L.show
    logger.info("s1 = {}", s1)

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()
    test2()
    test3()
