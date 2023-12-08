package MyPractice

object Solution4 {

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

    var diagnals:Seq[Seq[Int]] = Seq()

    var reachedEndOfDiagnal = false

    var reverse = true

    addDiagnals(0,0,Seq()).foreach(d => {
      if(reverse)
        print(d.reverse.mkString(","))
      else
        print(d.mkString(","))

      reverse = !reverse

      print(",")
    })

    def addDiagnals(i:Int, j:Int,diagnalsAccumalator:Seq[Seq[Int]]): Seq[Seq[Int]] = {

      if (i == matrix.size - 1 && j == matrix.size - 1) {
        diagnalsAccumalator :+ Seq(matrix(i)(j))
      }
      else {

        var diagnal: Seq[Int] = Seq()
        var a = i
        var b = j

        while (!reachedEndOfDiagnal && b >= 0) {
          diagnal = diagnal :+ matrix(a)(b)
          a += 1
          b -= 1
        }

        while (reachedEndOfDiagnal && a <= matrix.size - 1) {
          diagnal = diagnal :+ matrix(a)(b)
          a += 1
          b -= 1
        }

        if (a == matrix.size && b == -1)
          reachedEndOfDiagnal = true

        if (!reachedEndOfDiagnal)
          addDiagnals(0, j + 1, diagnalsAccumalator :+ diagnal)
        else
          addDiagnals(i + 1, matrix.size - 1, diagnalsAccumalator :+ diagnal)

      }
    }

  }
}
