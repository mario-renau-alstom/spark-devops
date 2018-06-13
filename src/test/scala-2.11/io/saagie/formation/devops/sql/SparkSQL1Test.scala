package io.saagie.formation.devops.sql

import io.saagie.formation.devops.SharedSparkSession
import org.scalatest.{FunSuite, Matchers}

class SparkSQL1Test extends FunSuite with SharedSparkSession with Matchers {

  test("Les liens cassés") {
    val result = SparkSQL1(rdd, sparkSession).process
    result shouldBe 25

  }
}
