package io.saagie.formation.devops

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, Suite}

trait SharedSparkSQLContext extends BeforeAndAfterAll { self: Suite =>
  @transient var _sc: SparkContext = _
  @transient var _rdd: RDD[String] = _
  @transient var _sqlContext: SQLContext = _

  def sc: SparkContext = _sc
  def rdd: RDD[String] = _rdd
  def sqlContext: SQLContext = _sqlContext

  override def beforeAll() {
    val conf = new SparkConf().setAppName(getClass().getName()).setMaster("local[2]")
    _sc = new SparkContext(conf)
    _rdd = sc.textFile(file(), 1)
    _sqlContext = new SQLContext(sc)
    super.beforeAll()
  }

  override def afterAll() {
    _sc.stop()
    _sc = null
    super.afterAll()
  }

  def file(): String = Thread.currentThread
    .getContextClassLoader
    .getResource(getClass.getPackage.getName.replace('.', '/') + "/../apache-access-log")
    .getFile
}
