package MyPractice

object Solution {

  /*
  [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9 ,10,11,12]
      [13,14,15,16]
  ]



  */

  def main(args: Array[String]) {

    val matrix = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16))

    var direction = 1 //up
    var reachedLongestDiagnal = false

    var i = 0
    var j = 0


    while (!(i == matrix.size - 1 && j == matrix.size - 1)) {

      if (matrix.size % 2 == 1 && i == 0 && j == matrix.size - 1)
        reachedLongestDiagnal = true

      if (matrix.size % 2 == 0 && j == 0 && i == matrix.size - 1)
        reachedLongestDiagnal = true

      println(matrix(i)(j))

      if (!reachedLongestDiagnal && (i == 0 && direction == 1) || (j == 0 && direction == 0)) {
        direction = 1 - direction
        if (matrix.size % 2 == 1) {
          if (i == 0)
            j += 1
          else
            i += 1
        }
        else {
          if (j == matrix.size - 1)
            i += 1
          else
            j += 1
        }
      }
      else if (reachedLongestDiagnal && (i == matrix.size - 1 && direction == 0) || (j == matrix.size - 1 && direction == 1)) {
        direction = 1 - direction
        if (matrix.size % 2 == 1) {
          if (j == matrix.size - 1)
            i += 1
          else
            j += 1
        } else {
          if (i == 0)
            j += 1
          else
            i += 1
        }
      }
      else {
        if (direction == 0) {
          i += 1
          j -= 1
        }
        else {
          j += 1
          i -= 1
        }
      }

      println(s"direction  - $direction")
      println(s"i - $i")
      println(s"j - $j")
    }

    println(matrix(matrix.size - 1)(matrix.size - 1))
  }
}
