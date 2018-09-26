package dynamic_programming

object MoneyChangeRec {


  def countChange(money: Int, coins: List[Int], loop:List[Int], acc:List[List[Int]]): List[List[Int]] = {

    if(money < 0 || coins.isEmpty)
      acc
    else if(money == 0 && loop.nonEmpty) {
      loop::acc
    }
    else {
      countChange(money - coins.head, coins,coins.head::loop,acc) ++ countChange(money, coins.tail,loop,acc)
    }
  }

  def main(args: Array[String]) {
    val money = scala.io.StdIn.readInt()
    val result = countChange(money, List(1,3,4), List.empty, List.empty)
    val min = result.min(Ordering.by((_:List[Int]).length)).length
    System.out.println(min)
  }
}
