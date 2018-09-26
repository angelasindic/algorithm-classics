package dynamic_programming

import org.scalatest._
import prop._

class CommonSubsequenceSpec extends PropSpec with TableDrivenPropertyChecks with PropertyChecks with Matchers {

  val subsequences = Table(
    ("sequence", "subsequence", "length common seq"),
    (Array[Int](1,2,3,10,20,30), Array[Int](1,2,3), 3),
    (Array[Int](1,2,3), Array[Int](1,2,3), 3),
    (Array[Int](2,7,5), Array[Int](2,5), 2),
    (Array[Int](7), Array[Int](1,2,3,4), 0),
    (Array[Int](2,7,8,3), Array[Int](5,2,8,7), 2)
  )


  property("Computed values for non-empty subsequences should be correct") {
    forAll(subsequences) { (seq_a, seq_b, result) =>
      CommonSubsequence.commonDistance(seq_a, seq_b) should be(result)
    }
  }
}
