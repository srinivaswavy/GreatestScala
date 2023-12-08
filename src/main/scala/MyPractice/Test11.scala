import java.io._
import java.math._
import java.security._
import java.text._
//import java.util._
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

object Result11 {

  /*
   * Complete the 'timeInWords' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER h
   *  2. INTEGER m
   */

  def timeInWords(h: Int, m: Int): String = {
    // Write your code here

    val num = 10
    val specialCases = Set(0, 15, 30, 45)

    if (specialCases.contains(m)) {
      m match {
        case 0 => s"${numberToWords(h)} o' clock"
        case 15 => s"quarter past ${numberToWords(h)}"
        case 30 => s"half past ${numberToWords(h)}"
        case 45 => s"quarter to ${numberToWords(nextHour(h))}"
        case _ => ""
      }
    } else {
      if (m > 30) {
        s"${numberToWords(60 - m)} ${singularAndPlural(m)} to ${numberToWords(nextHour(h))}"
      } else {
        s"${numberToWords(m)} ${singularAndPlural(m)} past ${numberToWords(h)}"
      }
    }


  }

  def singularAndPlural(m: Int) = if (m == 1) "minute" else "minutes"

  def nextHour(h: Int) = if (h == 12) 1 else h + 1

  def numberToWords(num: Int) = {
    num match {
      case 0 => ""
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 14 => "fourteen"
      case 15 => "fifteen"
      case 16 => "sixteen"
      case 17 => "seventeen"
      case 18 => "eighteen"
      case 19 => "nineteen"
      case 20 => "twenty"
      case 21 => "twenty one"
      case 22 => "twenty two"
      case 23 => "twenty three"
      case 24 => "twenty four"
      case 25 => "twenty five"
      case 26 => "twenty six"
      case 27 => "twenty seven"
      case 28 => "twenty eight"
      case 29 => "twenty nine"
      case 30 => "thirty"
      case 31 => "thirty one"
      case 32 => "thirty two"
      case 33 => "thirty three"
      case 34 => "thirty four"
      case 35 => "thirty five"
      case 36 => "thirty six"
      case 37 => "thirty seven"
      case 38 => "thirty eight"
      case 39 => "thirty nine"
      case 40 => "forty"
      case 41 => "forty one"
      case 42 => "forty two"
      case 43 => "forty three"
      case 44 => "forty four"
      case 45 => "forty five"
      case 46 => "forty six"
      case 47 => "forty seven"
      case 48 => "forty eight"
      case 49 => "forty nine"
      case 50 => "fifty"
      case 51 => "fifty one"
      case 52 => "fifty two"
      case 53 => "fifty three"
      case 54 => "fifty four"
      case 55 => "fifty five"
      case 56 => "fifty six"
      case 57 => "fifty seven"
      case 58 => "fifty eight"
      case 59 => "fifty nine"
      case 60 => "sixty"
      case _ => ""
    }
  }

}

object Solution11 {
  def main(args: Array[String]) {


    //val result = Result11.timeInWords(2, 2)
    val result = Result11.timeInWords(12, 0)
    println(result)

  }
}
