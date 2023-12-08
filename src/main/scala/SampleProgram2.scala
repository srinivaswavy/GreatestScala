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

object Result3 {

  /*
   * Complete the 'extraLongFactorials' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  def extraLongFactorials(n: Int) {
    // Write your code here
     println(factorial(n,1))


  }

  def factorial(n:Int,fact:BigInt) :BigInt = {
    if(n==1) {
      fact
    }
    else
    factorial(n-1,fact *n)

  }

}

object Solution3 {
  def main(args: Array[String]) {
    //val n = StdIn.readLine.trim.toInt

    Result3.extraLongFactorials(100)
  }
}
