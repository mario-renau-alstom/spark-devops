package io.saagie.formation.devops.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

/* Top 3 des plages d'IP */
case class SparkSQL4(rdd: RDD[String] , sqlContext: SQLContext) {

  def process: Array[(String, Long)] = {
    ???
  }
}
