package io.saagie.formation.devops.spark

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD

/* Répartition des codes http */
case class Spark2(rdd: RDD[String]) {

  def process: Array[(Integer, Long)] = ???

}
