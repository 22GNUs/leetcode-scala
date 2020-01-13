package common.scala

/**
  * @author wangxinhua
  * @since 1.0
  */
object Test707Helper extends App {

  def genTest(v: String, a: String, b: String): String = {
    def trim(s: String) = s.substring(1, s.length - 1)
    val l1              = a.split(",").map(trim)
    val l2              = b.split(",").map(trim).map(_.toInt)
    l1.zip(l2)
      .map {
        case (x, y) => {
          s"$v.$x($y);"
        }
      }
      .mkString("\n")
  }

  println(
    genTest(
      "l",
      "\"addAtHead\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"addAtHead\",\"addAtHead\",\"get\",\"addAtHead\",\"get\",\"get\",\"addAtTail\"",
      "[7],[7],[9],[8],[6],[0],[5],[0],[2],[5],[4]"
    )
  )

}
