ThisBuild / scalaVersion := "3.3.1"
ThisBuild / version := "0.0.2"
ThisBuild / organization := "com.stulsoft"
ThisBuild / organizationName := "stulsoft"

lazy val root = (project in file("."))
  .settings(
    name := "ys-cats",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.7",
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.10.0",

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test,

    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:postfixOps",
      "-Xfatal-warnings"/*,
      "-Ypartial-unification"*/
    )
  )