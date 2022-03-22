import scala.io.Source

object fileStats extends App {

  val filename = args(0)

  def wordCounter(filename: String): Map[String, Int] = {
    Source.fromFile(filename)
      .getLines()
      .flatMap(line => line.split("\\W"))
      .toSeq
      .groupBy(identity)
      .map(t => (t._1, t._2.length))
  }

  // print words occurrences
  wordCounter(filename).foreach({
    case (word -> count) => println((s"Word '$word' occurs $count times."))
  })

  // print lines data
  val myLines = Source.fromFile(filename).getLines
  println("line index | chars | words")
  var counter = 0
  myLines.foreach {
    (x) =>
      println(s"${counter} | ${x.length} | ${x.split(" ").size} ")
      counter += 1
  }
}