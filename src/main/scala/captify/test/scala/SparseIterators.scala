package captify.test.scala

/**
 * Boring utilities to generate your test data.
 */
object SparseIterators {
  /**
   * Uninteresting iterator which continually increments from one.
   */
  def iteratorFromOne: Iterator[BigInt] =
    new Iterator[BigInt] {
      private var nextVal: BigInt = BigInt(1)
      override def hasNext: Boolean = true
      override def next(): BigInt = {
        val result: BigInt = nextVal
        nextVal = nextVal + 1
        result
      }
    }

  /**
   * Generates `sparse` sequence which on average has larger skips with larger sparsity values.
   * @param sparsity greater or equal than 2
   */
  def iteratorSparse(sparsity: Int = 2): Iterator[BigInt] = {
    require(sparsity != 1, "sparsity of 1 is not supported")
    iteratorFromOne.filter{ num =>
      num.bitCount % sparsity == 0
    }
  }

}
