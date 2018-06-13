package io.saagie.formation.devops.sql

import io.saagie.formation.devops.SharedSparkSession
import org.scalatest.{FunSuite, Matchers}

class SparkSQL3Test extends FunSuite with SharedSparkSession with Matchers {

  test("Top 3 des familles user agents") {
    val result = SparkSQL3(rdd, sparkSession).process
    result shouldBe (Array(("IE", 2269), ("Firefox", 1601), ("Chrome", 1509)))
  }
}
