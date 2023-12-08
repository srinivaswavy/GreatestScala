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
import scala.util.control.Breaks.{break, breakable}

object Result12 {

  /*
   * Complete the 'gridSearch' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING_ARRAY G
   *  2. STRING_ARRAY P
   */

  def gridSearch(G: Array[String], P: Array[String]): String = {
    // Write your code here
    var i = 0
    var out = "NO"
    breakable {
      while (i < G.size) {
        var index = G(i).indexOf(P(0))
        var slicedString = G(i)
        while (index >= 0) {

          if (G.slice(i, i + P.size).map(_.slice(index, index + P(0).size)).toSeq.equals(P.toSeq)) {
            out = "YES"
            break
          }
          index = G(i).indexOfSlice(P(0), index + 1)
        }
        i += 1
      }
    }
    out
  }

}

object Solution12 {
  def main(args: Array[String]) {
    val G = Array(
      "111111111111111",
      "111111111111111",
      "111111111111111",
      "111111011111111",
      "111111111111111",
      "111111111111111",
      "101010101010101")
    val P = Array(
      "11111",
      "11111",
      "11111",
      "11110")
    val result = Result12.gridSearch(G, P)
    println(result)
  }
}
