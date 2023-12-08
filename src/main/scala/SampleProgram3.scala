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

object Result4 {

  val list = scala.collection.mutable.Seq[Int](1,2)
  scala.collection.mutable. PriorityQueue[Int]()(Ordering.by(i => i))

  case class Node(value:Int, var left:Option[Node],right: Option[Node]){
    def addLeft(node:Node) = {
      this.left = Some(node)
    }
  }

  val n = Node(1,None,None)

  n.left = Some(Node(0,None,None))

  /*
   * Complete the 'nonDivisibleSubset' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY s
   */

  def nonDivisibleSubset(k: Int, s: Array[Int]): Int = {
    // Write your code here
    var count = 0
    val map = collection.mutable.HashMap[Int, Int]()
    val set = collection.mutable.Set[Int]()
    val refinedArray = s.map(_ % k)
    val containsZeroRemainder = refinedArray.contains(0)
    val containsDoubler = refinedArray.exists(_ * 2 == k)
    val remainingItems = if (containsZeroRemainder) refinedArray.filter(i => i != 0 && i * 2 != k) else refinedArray
    if (containsDoubler) count += 1
    if (containsZeroRemainder) count += 1

    remainingItems.foldLeft(map)((m, i) => {
      if (m.contains(i)) m.put(i, m.get(i).get + 1)
      else m.put(i, 1)
      m
    })

    map.foreach(t => {
      if (!set(t._1)) {
        if (map.contains(k - t._1)) {
          if (map.get(t._1).get > map.get(k - t._1).get) {
            count += map.get(t._1).get
          }
          else {
            count += map.get(k - t._1).get
          }
        }
        else{
          count += map.get(t._1).get
        }
        set.addOne(t._1)
        set.addOne(k - t._1)
      }
    })
    count
  }

}

object Solution4 {
  def main(args: Array[String]) {


    val result = Result4.nonDivisibleSubset(4, Array(19, 10, 12, 10, 24, 25, 22))

    println(result)

  }
}
