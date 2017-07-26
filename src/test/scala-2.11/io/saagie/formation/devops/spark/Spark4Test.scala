package io.saagie.formation.devops.spark

import io.saagie.formation.devops.SharedSparkContext
import org.scalatest.{FunSuite, Matchers}

class Spark4Test extends FunSuite with SharedSparkContext with Matchers {

  test("Top 3 des plages d'IP") {
    val result = Spark4(rdd).process
    result shouldBe (Array(("140.x.x.x", 165), ("84.x.x.x", 163), ("48.x.x.x", 157)))
  }
}
