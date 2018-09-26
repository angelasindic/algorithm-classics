package dynamic_programming

import org.scalatest.{FlatSpec, Matchers}

class EditDistanceSpec extends FlatSpec with Matchers {

  "It" should "compute a distance matrix of correct size" in {
    val dist = EditDistance.distanceMatrix("hello".toCharArray, "angela".toCharArray)

    val rows = dist.length
    rows should be ("hello".length()+1)

    val d = dist.toList
    assert(d.forall(_.length == "angela".length()+1))

  }

  "It" should "compute a distance matrix" in {
    val dist = EditDistance.distanceMatrix("editing".toCharArray, "distance".toCharArray)

    val expected = Array(Array(0,1,2,3,4,5,6,7,8),
      Array(1,1,2,3,4,5,6,7,7),
    Array(2,1,2,3,4,5,6,7,8),
    Array(3,2,1,2,3,4,5,6,7),
    Array(4,3,2,2,2,3,4,5,6),
    Array(5,4,3,3,3,3,4,5,6),
    Array(6,5,4,4,4,4,3,4,5),
    Array(7,6,5,5,5,5,4,4,5))

    assert(dist.corresponds(expected){_ sameElements _})
  }




}
