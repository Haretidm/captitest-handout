package captify.test.java;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static captify.test.java.SparseIterators.*;
import static captify.test.java.TestAssignment.*;

public class SparseIteratorsApp {
  private static void runTests(int sampleAfterNum, int sparsityMin, int sparsityMax, int approximateExtent) {
    final List<Iterator<BigInteger>> iterators =
      Arrays.asList(
        iteratorSparse(2),
        iteratorSparse(3),
        iteratorSparse(5)
      );

    final long mergeStartedAt = System.currentTimeMillis();

    final Iterator<BigInteger> mergedIterator =
      mergeIterators(iterators);

    final Iterator<BigInteger> numbers =
      sampleAfter(mergedIterator, sampleAfterNum, 10);

    final long mergeFinishedAt = System.currentTimeMillis();
    final long mergeMillis = mergeFinishedAt - mergeStartedAt;

    System.out.println("sampled merged iterator after " + sampleAfterNum + " in " + mergeMillis + " millis:");
    numbers.forEachRemaining(System.out::println);

    final long approximatesStartedAt = System.currentTimeMillis();
    final Map<Integer, Future<Double>> approximatesRes =
      approximatesFor(sparsityMin, sparsityMax, approximateExtent);
    final long approximatesFinishedAt = System.currentTimeMillis();
    final long approximatesMillis = approximatesFinishedAt - approximatesStartedAt;
    final int cores = Runtime.getRuntime().availableProcessors();

    System.out.println("approximate sparsities in " + approximatesMillis + " millis by " + approximateExtent + " elems with " + cores + " cores:");
    approximatesRes.entrySet().forEach(e -> {
      final Future<Double> future = e.getValue();
      String futureAsString;
      if (!future.isDone()) {
        futureAsString = "<incomplete>";
      } else {
        try {
          futureAsString = String.valueOf(future.get());
        } catch (InterruptedException e1) {
          futureAsString = "<interrupted on get()>";
        } catch (ExecutionException e1) {
          futureAsString = e1.getCause().getMessage();
        }
      }
      System.out.println(e.getKey() + " -> " + futureAsString);
    });
  }


  public static void main(String[] args) {
    //  simple less loaded tests
    runTests(1000000, 2, 8, 1000000);

    //  more intensive tests with just a bit of exceptions (should run in under 15 minutes)
    runTests(10000000, 0, 24, 10000000);
  }
}
