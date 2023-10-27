import org.apache.spark.sql.SparkSession
object SparkHelloWorld {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder()
      .appName("SparkHelloWorld")
      .master("local[*]") // Use a local Spark cluster for demonstration
      .getOrCreate()

    // Create a DataFrame with some sample data
    val data = Seq("Hello", "World", "Spark")
    import spark.implicits._
    val df = data.toDF("message")

    // Perform a transformation (e.g., uppercase the message)
    val transformedDF = df.selectExpr("upper(message) as message")

    // Show the result
    transformedDF.show()

    // Stop the SparkSession
    spark.stop()
  }
}