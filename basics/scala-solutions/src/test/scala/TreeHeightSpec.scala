import org.scalatest.{FlatSpec, Matchers}

class TreeHeightSpec extends FlatSpec with Matchers {

  "It" should "compute the height of the tree" in {
    val numberOfNodes = 5
    val inputString = "4 -1 4 1 1"
    val parents = inputString.split(" ").map(_.toInt)
    val tree = TreeBuilder.buildTree(numberOfNodes, parents.toList)
    val result = GeneralTree.height(tree)
    result  should be (3)
  }

}
