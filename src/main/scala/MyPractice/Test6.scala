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

object Result6 {

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

    var horizantalRight = (0, false, c_q, r_q)
    var horizantalLeft = (0, false, c_q, r_q)
    var verticalTop = (0, false, c_q, r_q)
    var verticalBottom = (0, false, c_q, r_q)
    var diagnol1Right = (0, false, c_q, r_q)
    var diagnol1Left = (0, false, c_q, r_q)
    var diagnol2Right = (0, false, c_q, r_q)
    var diagnol2Left = (0, false, c_q, r_q)
    var count = 0
    val points = obstacles.map(r => (r(1), r(0))).filter(c=> {
      c._1 == c_q || c._2 == r_q || c._2+c._1 == c_q+r_q || c._2 - c._1 == r_q - c_q
    })
    val horizantalPoints = points.filter(_._2 == r_q)
    val verticalPoints = points.filter(_._1 == c_q)
    while (
      !(horizantalLeft._2 &&
        horizantalRight._2 &&
        verticalTop._2 &&
        verticalBottom._2 &&
        diagnol1Left._2 &&
        diagnol1Right._2 &&
        diagnol2Left._2 &&
        diagnol2Right._2
        )
    ) {

      if (!horizantalLeft._2)
        if (horizantalPoints.map(_._1 + 1).contains(horizantalLeft._3) || horizantalLeft._3 <= 1) {
          horizantalLeft = (horizantalLeft._1, true, horizantalLeft._3, horizantalLeft._4)
        }
        else {
          horizantalLeft = (horizantalLeft._1, false, horizantalLeft._3 - 1, horizantalLeft._4)
          count += 1
        }
      if (!horizantalRight._2)
        if (horizantalPoints.map(_._1 - 1).contains(horizantalRight._3) || horizantalRight._3 >= n) {
          horizantalRight = (horizantalRight._1, true, horizantalRight._3, horizantalRight._4)
        }
        else {
          horizantalRight = (horizantalRight._1, false, horizantalRight._3 + 1, horizantalRight._4)
          count += 1
        }
      if (!verticalTop._2)
        if (verticalPoints.map(_._2 - 1).contains(verticalTop._4) || verticalTop._4 >= n) {
          verticalTop = (verticalTop._1, true, verticalTop._3, verticalTop._4)
        }
        else {
          verticalTop = (verticalTop._1, false, verticalTop._3, verticalTop._4 + 1)
          count += 1
        }
      if (!verticalBottom._2)
        if (points.filter(_._1 == c_q).map(_._2 + 1).contains(verticalBottom._4) || verticalBottom._4 <= 1) {
          verticalBottom = (verticalBottom._1, true, verticalBottom._3, verticalBottom._4)
        }
        else {
          verticalBottom = (verticalBottom._1, false, verticalBottom._3, verticalBottom._4 - 1)
          count += 1
        }

      if (!diagnol1Left._2)
        if (points.exists(c => c._1 + 1 == diagnol1Left._3 && c._2 + 1 == diagnol1Left._4) || diagnol1Left._3 <= 1 || diagnol1Left._4 <= 1)
          diagnol1Left = (diagnol1Left._1, true, diagnol1Left._3, diagnol1Left._4)
        else {
          diagnol1Left = (diagnol1Left._1, false, diagnol1Left._3 - 1, diagnol1Left._4 - 1)
          count += 1
        }
      if (!diagnol1Right._2)
        if (points.exists(c => c._1 - 1 == diagnol1Right._3 && c._2 - 1 == diagnol1Right._4) || diagnol1Right._3 >= n || diagnol1Right._4 >= n)
          diagnol1Right = (diagnol1Right._1, true, diagnol1Right._3, diagnol1Right._4)
        else {
          diagnol1Right = (diagnol1Right._1, false, diagnol1Right._3 + 1, diagnol1Right._4 + 1)
          count += 1
        }
      if (!diagnol2Left._2)
        if (points.exists(c => c._1 + 1 == diagnol2Left._3 && c._2 - 1 == diagnol2Left._4) || diagnol2Left._3 <= 1 || diagnol2Left._4 >= n)
          diagnol2Left = (diagnol2Left._1, true, diagnol2Left._3, diagnol2Left._4)
        else {
          diagnol2Left = (diagnol2Left._1, false, diagnol2Left._3 - 1, diagnol2Left._4 + 1)
          count += 1
        }

      if (!diagnol2Right._2)
        if (points.exists(c => c._1 - 1 == diagnol2Right._3 && c._2 + 1 == diagnol2Right._4) || diagnol2Right._3 >= n || diagnol2Right._4 <= 1)
          diagnol2Right = (diagnol2Right._1, true, diagnol2Right._3, diagnol2Right._4)
        else {
          diagnol2Right = (diagnol2Right._1, false, diagnol2Right._3 + 1, diagnol2Right._4 - 1)
          count += 1
        }
    }

    println(count)
    count
  }

}

object Solution6 {
  def main(args: Array[String]) {


    val result = Result6.queensAttack(5, 3, 4, 3, Array(Array(5, 5), Array(4, 2), Array(2, 3)))
    //val result = Result6.queensAttack(1, 0, 1, 1, Array())

    Result6.queensAttack(100, 100, 54, 30, Array(
      Array(48, 36),
      Array(38, 46),
      Array(60, 24),
      Array(70, 14),
      Array(54, 36),
      Array(54, 24),
      Array(60, 30),
      Array(48, 30),
      Array(71, 50),
      Array(14, 97),
      Array(47, 31),
      Array(29, 68),
      Array(90, 10),
      Array(36, 85),
      Array(63, 24),
      Array(32, 13),
      Array(64, 57),
      Array(45, 57),
      Array(86, 19),
      Array(43, 86),
      Array(68, 72),
      Array(29, 25),
      Array(48, 59),
      Array(38, 78),
      Array(45, 16),
      Array(40, 92),
      Array(76, 85),
      Array(40, 10),
      Array(65, 16),
      Array(71, 18),
      Array(90, 40),
      Array(65, 45),
      Array(10, 37),
      Array(19, 82),
      Array(42, 56),
      Array(46, 60),
      Array(94, 14),
      Array(34, 36),
      Array(95, 49),
      Array(78, 67),
      Array(86, 23),
      Array(28, 12),
      Array(95, 57),
      Array(38, 19),
      Array(61, 49),
      Array(67, 42),
      Array(28, 25),
      Array(38, 28),
      Array(91, 20),
      Array(90, 86),
      Array(81, 19),
      Array(18, 43),
      Array(29, 69),
      Array(36, 20),
      Array(72, 75),
      Array(39, 50),
      Array(17, 92),
      Array(48, 25),
      Array(20, 79),
      Array(82, 57),
      Array(58, 50),
      Array(94, 70),
      Array(17, 19),
      Array(73, 20),
      Array(45, 12),
      Array(19, 89),
      Array(45, 12),
      Array(59, 74),
      Array(63, 71),
      Array(32, 23),
      Array(67, 85),
      Array(24, 25),
      Array(18, 61),
      Array(97, 50),
      Array(70, 37),
      Array(30, 10),
      Array(39, 90),
      Array(75, 58),
      Array(58, 34),
      Array(47, 62),
      Array(28, 28),
      Array(79, 34),
      Array(73, 80),
      Array(93, 36),
      Array(25, 45),
      Array(48, 75),
      Array(42, 13),
      Array(18, 69),
      Array(35, 21),
      Array(18, 87),
      Array(57, 19),
      Array(26, 92),
      Array(94, 34),
      Array(84, 48),
      Array(61, 95),
      Array(62, 89),
      Array(59, 74),
      Array(50, 40),
      Array(36, 37),
      Array(95, 62)))

  }
}
