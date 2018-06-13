package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

/* Les liens cassés */
case class SparkSQL1(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Long = ???
}
