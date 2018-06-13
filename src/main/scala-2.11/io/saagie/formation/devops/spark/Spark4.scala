package io.saagie.formation.devops.spark

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD

/* Top 3 des plages d'IP */
case class Spark4(rdd: RDD[String]) {
  def process: Array[(String, Long)] = ???
}
