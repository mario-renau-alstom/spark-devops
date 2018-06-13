package io.saagie.formation.devops.spark

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD

/* Top 3 des familles user agents */
case class Spark3(rdd: RDD[String]) {

  def process: Array[(String, Long)] = ???
}
