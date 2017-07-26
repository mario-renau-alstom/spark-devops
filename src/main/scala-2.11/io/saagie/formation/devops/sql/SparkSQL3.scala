package io.saagie.formation.devops.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

/* Top 3 des familles user agents */
case class SparkSQL3(rdd: RDD[String] , sqlContext: SQLContext) {

  def process: Array[(String, Long)] = {
   ???
  }
}
