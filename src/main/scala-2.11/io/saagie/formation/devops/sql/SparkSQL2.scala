package io.saagie.formation.devops.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

/* Répartition des codes http */
case class SparkSQL2(rdd: RDD[String] , sqlContext: SQLContext) {

  def process: Array[(Int, Long)] =  {
    ???
  }

}
