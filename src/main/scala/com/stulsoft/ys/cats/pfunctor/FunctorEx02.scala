/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.pfunctor

import cats.Functor
import cats.instances.list._
import cats.instances.option._

import com.typesafe.scalalogging.StrictLogging

/**
 * Examples of the usage of the Functor.
 * See [[https://www.tobyhobson.com/posts/cats/functors/]]
 */
object FunctorEx02 extends StrictLogging:
  private case class LineItem(price: Double)

  private def withVat1(orders: List[LineItem]): List[LineItem] =
    orders.map(item => LineItem(item.price * 1.2))

  private def withVat1(maybeOrder: Option[LineItem]): Option[LineItem] =
    maybeOrder.map(item => LineItem(item.price * 1.2))

  //  private def withVat1(eventualOrder: Future[LineItem]) = eventualOrder.map()

  private def test1(): Unit =
    println("==>test1")
    val origOrders = List(LineItem(1), LineItem(2))

    val ordersWithVat = withVat1(origOrders)
    logger.info("ordersWithVat: {}", ordersWithVat)

    val optionOrder:Option[LineItem] = Some(LineItem(3))
    val optionOrderWithVat = withVat1(optionOrder)
    logger.info("optionOrderWithVat: {}", optionOrderWithVat)

  private def withVat[F[_]](order: F[LineItem])(using ev:Functor[F]):F[LineItem]=
    Functor[F].map(order)(o => LineItem(price=o.price * 1.2))

  private def test2():Unit=
    logger.info("==>test2")
    val origOrders = List(LineItem(1), LineItem(2))

    val ordersWithVat = withVat(origOrders)
    logger.info("ordersWithVat: {}", ordersWithVat)

    val optionOrder:Option[LineItem] = Some(LineItem(3))
    val optionOrderWithVat = withVat(optionOrder)
    logger.info("optionOrderWithVat: {}", optionOrderWithVat)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
    test2()
  }
