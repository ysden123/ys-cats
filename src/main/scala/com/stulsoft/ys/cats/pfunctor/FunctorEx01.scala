/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.pfunctor

import cats.instances.list._
import cats.Functor
import com.typesafe.scalalogging.StrictLogging

object FunctorEx01 extends StrictLogging:
  /**
   * map using Functor
   */
  private def test1(): Unit =
    logger.info("==>test1")
    val l = List(1, 2, 3, 4, 5)
    val mapResult = Functor[List].map(l)(_ * 2)
    logger.info("original list: {}", l)
    logger.info("map result   : {}", mapResult)

  private def test2(): Unit =
    println("==>test2")
    val l = Seq(Some(1), None, Some(2), Some(3))
//    l.map(_.map(_ * 2)) // Without Functor
    val mapResult = Functor[Seq].compose[Option].map(l)(_ * 2)
    logger.info("original list: {}", l)
    logger.info("map result   : {}", mapResult)

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()
    test2()
