package dynamic_programming

object CommonSubsequence {

  def distanceMatrix(a: Array[Int], b: Array[Int]):Array[Array[Int]] = {
    val rows = a.length+1
    val cols = b.length+1

    val dist = Array.fill[Int](rows,cols){0}

    for (j <-1 until cols) {
      for (i <-1 until rows) {
        val insertion = dist(i)(j -1)
        val deletion = dist(i-1)(j)
        val _match = dist(i-1)(j-1) +1
        val mismatch = dist(i-1)(j-1)

        if (a(i-1).equals(b(j-1)))
          dist(i)(j) = Math.max(Math.max(insertion, deletion), _match)
        else dist(i)(j) = Math.max(Math.max(insertion,deletion),mismatch)
      }
    }
    dist
  }

  def commonDistance(a:Array[Int], b:Array[Int]):Int = {
    distanceMatrix(a, b)(a.length)(b.length)
  }

  private def printDist(dist:Array[Array[Int]]): Unit = {
    val rows = dist.length
    val cols = dist(0).length

    for (i <- 0 until rows){
      println(' ')
      for(j <- 0 until cols){
        print(dist(i)(j) +",")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    val seq_a = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val m = scala.io.StdIn.readInt()
    val seq_b = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val result = commonDistance(seq_a,seq_b)
    System.out.println(result)
  }

}
