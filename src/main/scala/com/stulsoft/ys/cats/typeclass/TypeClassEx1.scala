/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.typeclass

import com.typesafe.scalalogging.StrictLogging

object TypeClassEx1 extends StrictLogging:
  trait Area[A]:
    def area(a: A): Double

  /*
    Type class instances
  */
  case class Rectangle(width: Double, length: Double)

  case class Circle(radius: Double)

  private object AreaInstances:
    given rectangleArea: Area[Rectangle] = new Area[Rectangle] {
      override def area(a: Rectangle): Double = a.width * a.length
    }

    given circleArea: Area[Circle] = new Area[Circle] {
      override def area(a: Circle): Double = Math.PI * (a.radius * a.radius)
    }

  /*
    Interface objects
  */
  object ShapeArea:
    def areaOf[A](a:A)(using shape:Area[A]): Double = shape.area(a)

  def main(args: Array[String]): Unit =
    val rectangle = Rectangle(10, 20)
    val circle = Circle(10)

    import AreaInstances.given

    // Using default instances
    logger.info("Using default instances")
    logger.info("rectangle area={}", rectangleArea.area(rectangle))
    logger.info("circle area={}", circleArea.area(circle))

    // Using interface syntax
    logger.info("Using interface syntax")
    logger.info("rectangle area={}", ShapeArea.areaOf(rectangle))
    logger.info("circle area={}", ShapeArea.areaOf(circle))


    logger.info("==>main")
end TypeClassEx1

