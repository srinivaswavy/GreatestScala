ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "TestScala",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )

