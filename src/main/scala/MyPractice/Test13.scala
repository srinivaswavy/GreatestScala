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

object Result13 {

  /*
   * Complete the 'surfaceArea' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY A as parameter.
   */

  def surfaceArea(A: Array[Array[Int]]): Int = {
    // Write your code here

    val topandBottom = A.flatten.size * 2

    var count = 0
    var i = 0
    var j = 0
    val rows = A.size
    val columns = A(0).size

    while (i < A.size) {
      while (j < A(i).size) {
        (i,j) match {
          case (0,0) =>
          case (0,columns-1) =>
          case (rows-1,0) =>
          case (rows-1,columns-1) =>
        }
      }
    }

  }
  trait Position
  case object Corner extends Position
  case object Side extends Position
  case object Middle extends Position

  def calculateArea(position: Position,height:Int,i:Int,j:Int) ={
    if(position == Corner)
  }

}

object Solution13 {
  def main(args: Array[String]) {

    val result = Result13.surfaceArea(Array())

    println(result)

  }
}
