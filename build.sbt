import sbt.Keys._

name := "spark-devops"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.1" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.1" % "provided"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

libraryDependencies += "net.sf.uadetector" % "uadetector-resources" % "2014.10"

concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)

fork := true

run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))
