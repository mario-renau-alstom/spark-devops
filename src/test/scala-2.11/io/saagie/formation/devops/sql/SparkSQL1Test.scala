package io.saagie.formation.devops.sql

import io.saagie.formation.devops.SharedSparkSQLContext
import org.scalatest.{FunSuite, Matchers}

class SparkSQL1Test extends FunSuite with SharedSparkSQLContext with Matchers {

  test("Les liens cassés") {
    val result = SparkSQL1(rdd, sqlContext).process
    result shouldBe 25

  }
}
