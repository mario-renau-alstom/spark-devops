package io.saagie.formation.devops.sql

import io.saagie.formation.devops.SharedSparkSession
import org.scalatest.{FunSuite, Matchers}

class SparkSQL2Test extends FunSuite with SharedSparkSession with Matchers {

  test("Répartition des codes http") {
    val result = SparkSQL2(rdd, sparkSession).process
    result shouldBe (Array((200, 6067), (404, 35)))
  }
}
