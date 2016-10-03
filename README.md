This simple project requires sbt, JDK 8 and scala 2.10.

There are two alternative and mostly identical tasks, one of which is in Java and other in Scala.

In both versions there is one file to be edited, either
    src/main/java/captify/test/java/TestAssignment.java 
or 
    src/main/scala/captify/test/scala/TestAssignment.scala

The methods to fill are documented and throw placeholder exceptions. 

Also, looking at the test harness could clarify the assignments a bit more, so see
    src/main/java/captify/test/java/SparseIteratorsApp.java
or 
    src/main/scala/captify/test/scala/TestAssignment.scala

To run this you just issue `sbt run` in the project root and then choose accordingly to run respective harness.
This of course presumes you've installed all the requirements mentioned above.

General requirements for this are:
 * initialize a local git repo with initial commit containing original code
 * doing separate commit(s) for initial version and follow-up polishings is recommended
 * including one representative output of your local run(s) is required
 * all tests are expected to run successfully - so most of exceptions thrown should be reported, not propagated
 * try to show reasonably functional style - avoid side-effects and mutable state, as long as it does not impair performance
 * adding some unit-tests or several other test harnesses is recommended, but not required
 * harness takes 5 minutes on my 4-core machine (Intel Core i7-3537U CPU @ 2.00GHz) - comparable delay is perfectly fine, so please do not over-optimize
 * algorithm sketches and general ideas to optimize are welcome but not required

Time required to complete this should generally be under 4 hours, with some simple test cases added.
In case you spend more time (to add some recommended or otherwise interesting stuff) please commit a bit more often - so that your actual track record is visible.
