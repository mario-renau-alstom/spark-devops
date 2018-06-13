package io.saagie.formation.devops.spark

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD

/* Top 3 des familles user agents */
case class Spark3(rdd: RDD[String]) {

  def process: Array[(String, Long)] = {
    rdd.map(ApacheAccessLog.parse)
      .map(a => (a.agentFamily, 1L))
      .reduceByKey(_ + _)
      .top(3)(Ordering.by[(String, Long), Long] (_._2))
  }
}
