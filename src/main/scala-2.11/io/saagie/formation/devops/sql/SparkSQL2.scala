package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Répartition des codes http */
case class SparkSQL2(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Array[(Int, Long)] = ???
}
