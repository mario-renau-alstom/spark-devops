package io.saagie.formation.devops.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

/* Les liens cassés */
case class SparkSQL1(rdd: RDD[String] , sqlContext: SQLContext) {

  def process: Long = {
    ???
  }
}
