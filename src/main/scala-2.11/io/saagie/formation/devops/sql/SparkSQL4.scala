package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Top 3 des plages d'IP */
case class SparkSQL4(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Array[(String, Long)] = ???
}
