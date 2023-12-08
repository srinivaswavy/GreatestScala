//import java.io._
//import java.math._
//import java.security._
//import java.text._
//import java.util._
//import java.util.concurrent._
//import java.util.function._
//import java.util.regex._
//import java.util.stream._
//import scala.collection.immutable._
////import scala.collection.mutable._
//import scala.collection.concurrent._
//import scala.concurrent._
//import scala.io._
//import scala.math._
//import scala.sys._
//import scala.util.matching._
//import scala.reflect._
//
//object Result1 {
//
//  /*
//   * Complete the 'formingMagicSquare' function below.
//   *
//   * The function is expected to return an INTEGER.
//   * The function accepts 2D_INTEGER_ARRAY s as parameter.
//   */
//
//  def formingMagicSquare(s: Array[Array[Int]]): Int = {
//    // Write your code here
//
//    val s1 =Array[Array[Int]](Array[Int](2,7,6),Array[Int](9,5,1),Array[Int](4,3,8))
//
//    val modulus = (num1:Int,num2:Int) => if (num1 > num2) num1 - num2 else num2 - num1
//
//    val magicSquares = collection.immutable.Seq(s1.transpose,s1, s1.map(_.reverse),s1.transpose.map(_.reverse),s1.reverse,s1.reverse.transpose)
//    magicSquares.map(
//      ms => ms.flatten.toSeq.zip(s.flatten.toSeq).map(c => modulus(c._1,c._2)).sum
//    ).min
//  }
//
//}
//
//object Solution {
//  def main(args: Array[String]) {
//    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
//
//    val s = Array.ofDim[Int](3, 3)
//
//    for (i <- 0 until 3) {
//      s(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
//    }
//
//    val result = Result.formingMagicSquare(s)
//
//    printWriter.println(result)
//
//    printWriter.close()
//  }
//}
