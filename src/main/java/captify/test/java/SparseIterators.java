package captify.test.java;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Boring utilities to generate your test data.
 */
public class SparseIterators {
  /**
   * Uninteresting iterator which continually increments from one.
   */
  public static Iterator<BigInteger> iteratorFromOne() {
    return new Iterator<BigInteger>() {
      private BigInteger nextVal = BigInteger.ONE;
      @Override public boolean hasNext() {
        return true;
      }

      @Override public BigInteger next() {
        final BigInteger result = nextVal;
        nextVal = nextVal.add(BigInteger.ONE);
        return result;
      }
    };
  }

  /**
   * Generates `sparse` sequence which on average has larger skips with larger sparsity values.
   * @param sparsity greater or equal than 2
   */
  public static Iterator<BigInteger> iteratorSparse(int sparsity) {
    if (sparsity == 1) {
      throw new IllegalArgumentException("sparsity of 1 is not supported");
    }
    return Stream.generate(iteratorFromOne()::next)
      .filter(num -> num.bitCount() % sparsity == 0)
      .iterator();
  }

}
