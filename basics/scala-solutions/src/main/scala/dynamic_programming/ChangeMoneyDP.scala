package dynamic_programming

object ChangeMoneyDP {


  def minNumberOfCoins(money:Int, coins:List[Int]): Int =  {
    val table:Array[Int] = Array.fill(money + 1){money+1}
    table(0) = 0

    for (m <- 1 to money) {
      val min = coins.filter(x => m >= x).map(x => table(m-x)).min
      table(m) = min+1
    }
    table(money)
  }

  /**
    * Interface for the grader.
    *
    * @param args Money to be changed, integer. Uses coins 1,3,4
    */
  def main(args: Array[String]) {
    val money = scala.io.StdIn.readInt()
    val result = minNumberOfCoins(money, List(1,3,4))
    System.out.println(result)
  }
}
