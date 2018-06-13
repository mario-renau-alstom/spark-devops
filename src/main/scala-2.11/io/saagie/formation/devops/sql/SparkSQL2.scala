package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/* Répartition des codes http */
case class SparkSQL2(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Array[(Int, Long)] = {

    import sparkSession.implicits._

    val df = rdd.map(ApacheAccessLog.parse).toDF

    // En SQL
    df.createTempView("log")

    sparkSession
      .sql("select count(*) as nb, code from log where code in (404, 200) group by code")
      .map(r => (r.getAs[Int]("code"), r.getAs[Long]("nb")))
      .collect()

    // Avec l'API Dataframe
    df.where($"code" isin (200, 404)).groupBy($"code").count().orderBy("code").map(r=> (r.getInt(0), r.getLong(1))).collect()

  }
}
