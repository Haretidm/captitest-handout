package captify.test.java;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static captify.test.java.SparseIterators.*;

public class TestAssignment {
  /**
   * Generate a contiguous sub-sample from given sequence.
   *
   * Iterator provided should be immediately thrown away after calling this method,
   * so don't worry about any side-effects.
   *
   * @param iterator to be sampled
   * @param after the index of first element to be included, zero-based
   * @param sampleSize quantity of elements returned
   * @return sampleAfter(iteratorFromOne, 1, 2) should be same as to Seq[BigInt](2,3,4).toIterator
   */
  public static Iterator<BigInteger> sampleAfter(Iterator<BigInteger> iterator, int after, int sampleSize) {
    throw new java.lang.UnsupportedOperationException("please implement this method");
  }

  /**
   * Get value by index from given iterator.
   *
   * Iterator provided should be immediately thrown away after calling this method,
   * so don't worry about any side-effects.
   *
   * @param iterator to get value from
   * @param position zero-based
   * @return value at given position
   */
  public static BigInteger valueAt(Iterator<BigInteger> iterator, int position) {
    throw new java.lang.UnsupportedOperationException("please implement this method");
  }

  /**
   * Produce an iterator which generates values from given subset of input iterators.
   *
   * The iterator returned should conform to following properties:
   * * if incoming sequences are sorted ascending then output iterator is also sorted ascending
   * * duplicates are allowed:
   *   * if there're occurrences of the same value across multiple iterators - respective number of dupes are present in merged version
   *   * if there're any dupes present in one of input iterators - respective number of dupes are present in merged version
   *
   * @param iterators to be merged
   * @return Iterator with all elements and ascending sorting retained
   */
  public static Iterator<BigInteger> mergeIterators(List<Iterator<BigInteger>> iterators) {
    throw new java.lang.UnsupportedOperationException("please implement this method");
  }

  /**
   * How much elements, on average, are included in sparse stream from the general sequence
   *
   * @param sparsity to analyze
   * @param extent number of sequence elements to analyze
   * @return approximately 0.5 for sparsity=2, 0.33 for sparsity=3, and so on
   */
  public static double approximateSparsity(int sparsity, int extent) {
    return extent / valueAt(iteratorSparse(sparsity), extent - 1).doubleValue();
  }

  /**
   * Approximate actual for given range of sparsity values.
   *
   * As approximation is potentially long-running task, try to run calls to approximateSparsity() in parallel.
   * Also, as such calls may end up in exception for some tricky sparsity values,
   * actual estimation should be kept in Future.
   *
   * For example, calling this with sparsityMin=2, sparsityMax=4, extent=1000 should:
   * - incur three calls to approximateSparsity for three respective values of sparsity and extent of 1000
   * - return Map(2 -> Future(0.5), 3 -> Future(0.33), 4 -> Future(0.25)) (values given are approximates)
   *
   * Future here is used to hold exceptions if such occur - along successful completions.
   * Upon this method termination, all futures in the returned Map MUST be completed.
   *
   * Extra plus is to return a map which lists it key-value pairs in ascending order.
   *
   * @param sparsityMin non-negative value, inclusive for the range evaluated
   * @param sparsityMax non-negative value, inclusive for the range evaluated
   * @param extent this affects precision and time spent
   *
   * @return Map from Sparsity to Future[Approximation]
   */
  public static Map<Integer, Future<Double>> approximatesFor(int sparsityMin, int sparsityMax, int extent) {
    throw new java.lang.UnsupportedOperationException("please implement this method");
  }

}
