package io.saagie.formation.devops.spark

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD

/* Les liens cassés */
case class Spark1(rdd: RDD[String]) {

  def process: Long =  {

    rdd.map(ApacheAccessLog.parse)
      .filter(_.code == 404)
      .map(_.referer)
      .distinct()
      .count()
  }

}
