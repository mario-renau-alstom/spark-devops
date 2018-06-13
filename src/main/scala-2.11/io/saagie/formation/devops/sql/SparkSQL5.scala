package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Statistiques sur la taille des requêtes */
case class SparkSQL5(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: (Long, Long, Double, Long) = ???

}
