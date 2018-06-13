package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Top 3 des familles user agents */
case class SparkSQL3(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Array[(String, Long)] = {

    import sparkSession.implicits._
    val df = rdd.map(ApacheAccessLog.parse).toDF

    // En SQL
    df.createTempView("log")

    sparkSession
      .sql("select agentFamily, count(*) as nb from log group by agentFamily order by nb desc limit 3")
      .map(r => (r.getString(0), r.getLong(1)))
      .collect()

    // Avec l'API Dataframe

    df.groupBy($"agentFamily")
      .count()
      .orderBy($"count".desc)
      .limit(3)
      .map(r => (r.getString(0), r.getLong(1)))
      .collect()

  }
}
