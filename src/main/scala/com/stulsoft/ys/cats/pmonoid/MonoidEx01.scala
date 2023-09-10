/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ys.cats.pmonoid

import cats.{Monoid, Semigroup}
import com.typesafe.scalalogging.StrictLogging

object MonoidEx01 extends StrictLogging:
  private case class WithoutMonoid(n: Int)

  private given mySemigroup: Semigroup[WithoutMonoid] = (x: WithoutMonoid, y: WithoutMonoid) => WithoutMonoid(x.n + y.n)

  private given myMonoid: Monoid[WithoutMonoid] = new Monoid[WithoutMonoid] {
    override def empty: WithoutMonoid = WithoutMonoid(0)

    override def combine(x: WithoutMonoid, y: WithoutMonoid): WithoutMonoid = WithoutMonoid(x.n + y.n)
  }

  private def combineAll[A](collection: Seq[A])(using ev: Monoid[A]): A =
    logger.info("==>combineAll")
    val monoid = Monoid[A]
    collection.foldLeft(monoid.empty)(monoid.combine)

  def main(args: Array[String]): Unit =
    logger.info("==>main")

    val s1 = 1 :: 2 :: 3 :: Nil
    val r1 = combineAll(s1)
    logger.info(s"s1: $s1, r1=$r1")

    val s2 = "one" :: "two" :: "three" :: Nil
    val r2 = combineAll(s2)
    logger.info(s"s2: $s2, r2=$r2")

    val s3 = WithoutMonoid(1) :: WithoutMonoid(2) :: WithoutMonoid(3) :: Nil
    val r3 = combineAll(s3)
    logger.info(s"s3: $s3, r3=$r3")