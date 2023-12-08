package MyPractice

object Test2 extends App {


  /*

  Choose i and j, where i < j, such that nums[i] < nums[j] and remove the pairs.

  Input: nums = [1,3,4,9,10,10,10,11,11,12]

  // 1 - 2
  // 3- 1
  // 4 - 1
  // 9 - 1
  // 10 - 3
  11 - 1
  12 - 1
  14 - 1



  Output: 0

  Input: nums = [2,3,6,9]
  Output: 0

  Input: nums = [1,1,2]
  Output: 1



  */

  var args1: Seq[Int] = Seq(1, 3, 4, 9, 10, 10, 10, 11, 11, 12, 13)
/* Using recursion
  work(1, args1)

  def work(i: Int, arr: Seq[Int]): Unit = {

    print(s"${arr.size} -  ")
    arr.foreach(p =>print(s"$p, "))
    println(s" -- $i")

    if (i >= arr.size)
      println(arr.size)
    else {
      if (arr(0) < arr(i)) {
        work(if(i>1) i-1 else i, arr.zipWithIndex.filter(_._2 != i).map(_._1).tail)
      }
      else
        work(i + 1, arr)
    }

  }

 */

  /* Stack approach

  var stack = scala.collection.mutable.Stack[Int]()

  var i = 0
  while(i < args1.size)
    {
      if(stack.isEmpty || args1(i) == stack.head)
        stack.push(args1(i))
      else{
        stack.pop()
      }
      i+=1
    }
  println(stack.size)


 */

  /* Loop approach
  var i = 0
  var j = 1

    while (i < args1.size && j < args1.size) {
      //j = i+1
      if (args1(i) < args1(j)) {
        args1.update(i,-1);
        args1.update(j,-1)

        if(i+1 == j) {
          i += 2
          j += 1
        }
        else {
          while (i < args1.size && args1(i) == -1)
            i += 1
        }
      }
      j+=1
    }
    println(args1.count(_!= -1))

*/

}
