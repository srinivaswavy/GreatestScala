package MyPractice

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

object Result5 {

  /*
   * Complete the 'queensAttack' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. INTEGER r_q
   *  4. INTEGER c_q
   *  5. 2D_INTEGER_ARRAY obstacles
   */

  def queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array[Array[Int]]): Int = {
    // Write your code here


    // x = r_q
    // y = c_q
    // y = x + r_q-c_q
    // y = r_q+c_q - x
    var count = 0
    val points = obstacles.map(r => (r(0), r(1)))

    val horizantalObstacleRight = (points.filter(t => t._1 == r_q && t._2 > c_q).map(_._2-1) :+ n).min - c_q
    println(s"horizantalObstacleRight - $horizantalObstacleRight")
    val horizantalObstacleLeft = c_q - (points.filter(t => t._1 == r_q && t._2 < c_q).map(_._2 +1) :+ 1).max
    println(s"horizantalObstacleLeft - $horizantalObstacleLeft")

    val verticalObstacleTop = (points.filter(t => t._2 == c_q && t._1 > r_q).map(_._2-1) :+ n).min - r_q
    println(s"verticalObstacleTop - $verticalObstacleTop")
    val verticalObstacleBottom = r_q - (points.filter(t => t._2 == c_q && t._1 < r_q).map(_._1+1) :+ 1).max
    println(s"verticalObstacleBottom - $verticalObstacleBottom")


    val diagnal1right = points.filter(t => t._2 == t._1 + r_q - c_q && c_q < t._2)
    val diagnal1rightNum =
      if (c_q > r_q)
        (diagnal1right.map(_._2-1) :+ n).min - c_q
      else
        (diagnal1right.map(_._1-1) :+ n).min - r_q
    println(s"diagnal1right - $diagnal1rightNum")


    val diagnal1left = points.filter(t => t._2 == t._1 + r_q - c_q && c_q > t._2)
    val diagnal1LeftNum =
      if (c_q > r_q)
        r_q - (diagnal1left.map(_._1+1) :+ 1).max
      else
        c_q - (diagnal1left.map(_._2+1) :+ 1).max
    println(s"diagnal1left - $diagnal1LeftNum")

    val diagnal2left = points.filter(t => t._2 == r_q + c_q - t._1 && c_q > t._2)
    var diagnal2leftNum =
      if(c_q + r_q < n+1)
        c_q - (diagnal2left.map(_._2+1) :+ 1).max
      else
         (diagnal2left.map(_._1-1) :+ n).min - r_q

    println(s"diagnal2Left - $diagnal2leftNum")



    val diagnal2right = points.filter(t => t._2 == r_q + c_q - t._1 && c_q < t._2)

    val diagnal2RightNum =
      if (c_q + r_q < n + 1)
        r_q - (diagnal2right.map(_._1+1) :+ 1).max
      else
        (diagnal2right.map(_._2-1) :+ n).min - c_q

    println(s"diagnal2Right - $diagnal2RightNum")

    val output = horizantalObstacleLeft + horizantalObstacleRight + verticalObstacleBottom + verticalObstacleTop + diagnal1rightNum + diagnal1LeftNum+ diagnal2RightNum+diagnal2leftNum

    println(output)

    output
  }

}

object Solution5 {
  def main(args: Array[String]) {


    val result = Result5.queensAttack(5, 3, 4, 3, Array(Array(5,5),Array(4,2),Array(2,3)))


  }
}
