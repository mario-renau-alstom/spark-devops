package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

/* Les liens cassés */
case class SparkSQL1(rdd: RDD[String] , sparkSession: SparkSession) {

  def process: Long = {

    val apacheAccessLog: RDD[ApacheAccessLog] = rdd.map(ApacheAccessLog.parse)
    val df: DataFrame = sparkSession.createDataFrame(apacheAccessLog)

    import sparkSession.implicits._

    // En SQL
    df.createTempView("log")

    sparkSession
      .sql("select count(distinct(referer)) as nbReferer from log where code = 404")
      .map(r => r.getAs[Long]("nbReferer"))
      .first()

    // Avec l'API Dataframe

    df.where($"code" === 404)
      .select($"referer")
      .distinct()
      .count()

  }
}
