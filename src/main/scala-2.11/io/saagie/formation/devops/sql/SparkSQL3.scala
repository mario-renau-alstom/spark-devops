package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Top 3 des familles user agents */
case class SparkSQL3(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Array[(String, Long)] = ???
}
