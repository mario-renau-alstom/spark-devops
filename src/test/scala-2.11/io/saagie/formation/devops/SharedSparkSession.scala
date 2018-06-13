package io.saagie.formation.devops

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, Suite}

trait SharedSparkSession extends BeforeAndAfterAll { self: Suite =>
  @transient var _sc: SparkContext = _
  @transient var _rdd: RDD[String] = _
  @transient var _sparkSession: SparkSession = _

  def sc: SparkContext = _sc
  def rdd: RDD[String] = _rdd
  def sparkSession: SparkSession = _sparkSession

  override def beforeAll() {
    val conf = new SparkConf().setAppName(getClass.getName).setMaster("local[2]")
    _sc = new SparkContext(conf)
    _rdd = sc.textFile(file(), 1)
    _sparkSession =  SparkSession.builder.getOrCreate()
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
