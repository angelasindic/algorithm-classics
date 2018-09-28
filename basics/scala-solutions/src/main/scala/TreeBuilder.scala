import scala.collection.mutable

object GeneralTree {

  class Node[A](val key: A, var children: List[Node[A]]) {

    def addChild(child: Node[A]): Unit = {
      children = child :: children
    }
  }

  /**
    * To slow for the grader.
    * @param node
    * @tparam A
    * @return
    */
  def heightUsingRecursion[A](node: Node[A]): Int = {
    1 + node.children.foldLeft(0)((h, c) => h max height(c))
  }


  /**
    * To slow for the grader.
    */
  def height[A](node: Node[A]): Int = {
    val queue = mutable.ListBuffer((node, 1))
    var maxDepth = 1
    while (queue.nonEmpty) {
      val (n, d) = queue.remove(0)
      maxDepth = d
      n.children.foreach(c => queue.append((c, d + 1)))
    }
    maxDepth
  }
}


object TreeBuilder {

  import GeneralTree._

  def buildTree(numberOfNodes:Int, parents:List[Int]): Node[Int] = {

    val nodes = Array.tabulate(numberOfNodes)(k => new Node[Int](k, List.empty))
    val parentsWithIndex = parents.zipWithIndex

    parentsWithIndex.foreach(p => {
      if(p._1 != -1)
        nodes(p._1).addChild(nodes(p._2))
    })
    nodes(parentsWithIndex.find(p => p._1 == -1).get._2)
  }


  def main(args: Array[String]): Unit = {
    val numberOfNodes = scala.io.StdIn.readInt()
    val parents = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val result = buildTree(numberOfNodes, parents.toList)
    println(height(result))
  }
}
