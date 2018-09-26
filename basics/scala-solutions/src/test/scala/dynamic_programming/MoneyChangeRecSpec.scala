package dynamic_programming

import org.scalatest.{FlatSpec, Matchers}

class MoneyChangeRecSpec extends FlatSpec with Matchers {

    "It" should "add two numbers" in {
      val result = MoneyChangeRec.countChange(8, List(4,2,1), List.empty, List.empty)


      println("============= result ==================")
      result.foreach(println(_))
      println("minimum" + result.min(Ordering.by((_:List[Int]).length)).length)
      result.length  should be (1)

    }
}
