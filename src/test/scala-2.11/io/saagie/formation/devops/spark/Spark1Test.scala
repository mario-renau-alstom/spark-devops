package io.saagie.formation.devops.spark

import io.saagie.formation.devops.SharedSparkContext
import org.scalatest.{FunSuite, Matchers}

class Spark1Test extends FunSuite with SharedSparkContext with Matchers {

  test("Les liens cassés") {
    val result = Spark1(rdd).process
    result shouldBe 25
  }
}
