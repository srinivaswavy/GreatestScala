import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result8 {

  /*
   * Complete the 'organizingContainers' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts 2D_INTEGER_ARRAY container as parameter.
   */

  def organizingContainers(container: Array[Array[Int]]): String = {
    // Write your code here
    if(container.map(_.sum).toSeq.sorted.equals(
    container.transpose.map(_.sum).toSeq.sorted))
      "Possible"
    else
      "Impossible"
  }

}

object Solution8 {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val n = StdIn.readLine.trim.toInt

      val container = Array.ofDim[Int](n, n)

      for (i <- 0 until n) {
        container(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      }

      val result = Result8.organizingContainers(container)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
