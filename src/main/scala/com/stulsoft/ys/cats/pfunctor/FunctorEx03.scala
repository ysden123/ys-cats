/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.pfunctor

import cats.Functor
import cats.syntax.functor.*
import com.typesafe.scalalogging.StrictLogging

/**
 * Examples of the usage of the Functor.
 * See [[https://www.tobyhobson.com/posts/cats/functors/]]
 */
object FunctorEx03 extends StrictLogging:
  private case class LineItem(price: Double)

  private def withVat[F[_] : Functor](order: F[LineItem]): F[LineItem] = {
    order.map(o => LineItem(price = o.price * 1.2))
  }

  private def test1(): Unit =
    logger.info("==>test1")
    val origOrders = List(LineItem(1), LineItem(2))

    val ordersWithVat = withVat(origOrders)
    logger.info("ordersWithVat: {}", ordersWithVat)

    val optionOrder: Option[LineItem] = Some(LineItem(3))
    val optionOrderWithVat = withVat(optionOrder)
    logger.info("optionOrderWithVat: {}", optionOrderWithVat)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
  }
