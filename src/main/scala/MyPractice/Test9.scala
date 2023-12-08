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
//import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result9 {

  /*
   * Complete the 'encryption' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def encryption(s: String): String = {
    // Write your code here
    val str = s.replace(" ", "")
    var rows = Math.floor(Math.sqrt(str.size)).toInt
    var coulmns = Math.ceil(Math.sqrt(str.size)).toInt

    if (rows * coulmns < str.size) {
      if (rows < coulmns)
        rows = rows + 1
      else if (coulmns < rows)
        coulmns = coulmns + 1
    }


    var matrix: Seq[Seq[Char]] = Seq()

    var i = 0
    while (i < rows) {
      matrix = matrix :+ fillString( str.slice(i * coulmns, i * coulmns + coulmns),coulmns ).toSeq
      i += 1
    }

    val out = matrix.transpose.map(_.mkString("").trim).mkString(" ")
    println(out)
    out

  }

  def fillString(str: String, n: Int) = if (str.size < n) str + (1 to n - str.size).foldLeft("")((s, _) => s.concat(" ")) else str
}

object Solution9 {
  def main(args: Array[String]) {
    //    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = "feedthedog"

    //val s = "chillout"

    val result = Result9.encryption(s)


  }
}
