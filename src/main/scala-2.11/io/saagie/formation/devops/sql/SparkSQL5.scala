package io.saagie.formation.devops.sql

import io.saagie.formation.devops.ApacheAccessLog
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

/* Statistiques sur la taille des requêtes */
case class SparkSQL5(rdd: RDD[String] , sqlContext: SQLContext) {

  def process: (Long, Long, Double, Long) = {

    val df = sqlContext.createDataFrame(rdd.map(ApacheAccessLog.parse))

    /*df.selectExpr("count(*)", "min(size)", "avg(size)", "max(size)")
      .map(r=> (r.getLong(0),r.getLong(1), r.getDouble(2), r.getLong(3)))
      .first()*/

    df.registerTempTable("log")
    sqlContext.sql("select count(*), min(size), avg(size), max(size) from log")
      .map(r=> (r.getLong(0), r.getLong(1), r.getDouble(2), r.getLong(3)))
      .first()


  }
}
