import scala.io.Source

object fileStats extends App {

  val filename = args(0)
  def lines = Source.fromFile(filename).getLines

  def wordCounter(filename: String): Map[String, Int] = {
    lines
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
  println("line index | chars | words")
  var counter = 0
  lines.foreach {
    (x) => println(s"${counter} | ${x.length} | ${x.split("\\W").size} ")
    counter += 1
  }
}