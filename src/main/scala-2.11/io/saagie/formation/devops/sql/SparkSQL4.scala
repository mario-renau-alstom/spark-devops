package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Top 3 des plages d'IP */
case class SparkSQL4(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Array[(String, Long)] = {

    import sparkSession.implicits._
    val df = rdd.map(ApacheAccessLog.parse).toDF

    // En SQL
    df.createTempView("log")

    sparkSession
      .sql("select ipRange, count(*) as nb from log group by ipRange order by nb desc limit 3")
      .map(r => (r.getString(0), r.getLong(1)))
      .collect()
  }
}
