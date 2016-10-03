package captify.test.scala

import scala.util.Try

import captify.test.scala.SparseIterators._
import captify.test.scala.TestAssignment._

object SparseIteratorsApp extends App {

  def runTests(sampleAfterNum: Int, sparsityMin: Int, sparsityMax: Int, approximateExtent: Int): Unit = {
    val iterators: Seq[Iterator[BigInt]] =
      Seq(
        iteratorSparse(2),
        iteratorSparse(3),
        iteratorSparse(5)
      )

    val mergeStartedAt: Long = System.currentTimeMillis()

    val mergedIterator: Iterator[BigInt] =
      mergeIterators(iterators)


    val numbers: Iterator[BigInt] =
      sampleAfter(mergedIterator, sampleAfterNum, 10)

    val mergeFinishedAt: Long = System.currentTimeMillis()
    val mergeMillis: Long = mergeFinishedAt - mergeStartedAt

    println(s"sampled merged iterator after $sampleAfterNum in $mergeMillis millis:\n" + numbers.mkString("\n"))

    val approximatesStartedAt: Long = System.currentTimeMillis()
    val approximatesRes: Seq[(Int, Try[Double])] = approximatesFor(sparsityMin, sparsityMax, approximateExtent)
    val approximatesFinishedAt: Long = System.currentTimeMillis()
    val approximatesMillis: Long = approximatesFinishedAt - approximatesStartedAt
    val cores: Int = Runtime.getRuntime.availableProcessors()

    println(s"approximate sparsities in $approximatesMillis millis by $approximateExtent elems with $cores cores:\n" + approximatesRes.mkString("\n"))

  }

  //  simple less loaded tests
  runTests(1000000, 2, 8, 1000000)

  //  more intensive tests with just a bit of exceptions (should run in under 15 minutes)
  runTests(10000000, 0, 24, 10000000)

}
