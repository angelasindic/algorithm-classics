package dynamic_programming

object EditDistance {

  def distanceMatrix(a: Array[Char], b: Array[Char]):Array[Array[Int]] = {
    val rows = a.length+1
    val cols = b.length+1
    val dist = Array.tabulate[Int](rows,cols)((i,j) => {
      if (i == 0) j
      else if (j == 0) i
      else 0
    })

    for (j <-1 until cols) {
      for (i <-1 until rows) {
        val insertion = dist(i)(j -1) + 1
        val deletion = dist(i-1)(j) + 1
        val _match = dist(i-1)(j-1)
        val mismatch = _match + 1
        if (a(i-1).equals(b(j-1)))
          dist(i)(j) = Math.min(Math.min(insertion, deletion), _match)
        else dist(i)(j) = Math.min(Math.min(insertion,deletion),mismatch)
      }
    }
    dist
  }

  def editDistance(a:String, b:String):Int = {
    val dist = distanceMatrix(a.trim().toCharArray, b.trim().toCharArray)
    dist(a.length())(b.length())
  }

  /**
    * Interface for the grader, computes edit distance of two strings
    * @param args two strings per line
    */
  def main(args: Array[String]): Unit = {
    val a = scala.io.StdIn.readLine()
    val b = scala.io.StdIn.readLine()
    val result = editDistance(a,b)
    System.out.println(result)
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

}
