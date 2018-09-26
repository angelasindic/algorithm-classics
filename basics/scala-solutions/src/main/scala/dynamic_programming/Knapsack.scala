package dynamic_programming

/**
  * Knapsack without repetitions.
  */
object Knapsack {

  def optimalWeight(capacity:Int, numberOfItems: Int, weights:List[Int]):Int = {

    //numberOfItems+1: num of rows
    //capacity+1: num of cols
    val values = Array.fill[Int](numberOfItems+1,capacity+1){0}
    for (i <-1 to numberOfItems){
      for(w <- 1 to capacity) {
        values(i)(w) = values(i-1)(w)
        val w_i = weights(i-1)
        if (w_i <= w ){
          val nextValue = values(i-1)(w - w_i) + w_i
          if (values(i)(w) < nextValue) {
            values(i)(w) = nextValue
          }

        }
      }
    }
    values(numberOfItems)(capacity)
  }

  /**
    * The first line of the input contains the capacity W of a knapsack and the number n of bars
    * of gold. The next line contains n integers w 0 , w 1 , . . . , w n−1 defining the weights of the bars of gold
    *
    * @param args
    */
  def main(args: Array[String]) {
    val firstLine = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val capacity = firstLine.head
    val numberOfBars = firstLine.last
    val weights = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    if (numberOfBars != weights.length)
      throw new IllegalArgumentException()
    println(optimalWeight(capacity, numberOfBars, weights))
  }

}
