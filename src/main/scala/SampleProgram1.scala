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
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result extends App{

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {
    // Write your code here

    val rankedUnique2 = collection.mutable.ListBuffer[Int](ranked(0))
    var index =1
    while(index < ranked.size)
      {
        if(ranked(index) != ranked(index -1))
          rankedUnique2 += ranked(index)

        index+=1
      }

    val map = collection.mutable.HashMap[Int,Int]()

     player.map(p => {
       if(map.contains(p)) map.get(p).get

       else {
         val place = findPlace(p, 0, rankedUnique2.size - 1, rankedUnique2.toSeq)
         map.put(p, place)
         place
       }
     })

  }


  def findPlace (i: Int, start:Int, end:Int , sortedRanks: collection.immutable.Seq[Int]):Int = {
    val centreIndex = (start + end) / 2
    val centre = sortedRanks(centreIndex)
    if(end < start)
      if( start >= sortedRanks.size -1 && i < sortedRanks.last)
        sortedRanks.size +1
      else
        start + 1
    else if (i == centre)
      centreIndex +1
    else if(i > centre)
      findPlace(i,start,centreIndex-1,sortedRanks)
    else
      findPlace(i,centreIndex+1,end,sortedRanks)
  }

  climbingLeaderboard(Array(100,90,90,80,75,60),Array(50,65,77,90,102)).foreach(println)

  climbingLeaderboard(Array(100,100,50,40,40,20,10),Array(5,25,50,120)).foreach(println)

}



