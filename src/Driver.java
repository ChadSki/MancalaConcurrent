import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ProducerConsumer.MancalaConsumer;
import ProducerConsumer.MancalaProducer;
import ProducerConsumer.MancalaQueue;

/**
 * TODO javadocs
 *
 * @author Chad Zawistowski <crz8448@rit.edu>
 */
public class Driver {
    static final int threadPoolSize = 3;

    static final int numSlots = 6;
    static final int ceiling = 4;
    static final int numBeads = 6;

    public static void main(String[] args) {
        MancalaQueue queue = new MancalaQueue(3);
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        
        Future<?> producer = executorService.submit(new MancalaProducer(queue, numSlots, ceiling, numBeads));
        
        /* We don't have any worthwhile consumers, so these fellas will simply print their name (A, B, C)
         * followed by the sequence number they received.
         */
        Future<?> consumerA = executorService.submit(new MancalaConsumer(queue, "A"));
        Future<?> consumerB = executorService.submit(new MancalaConsumer(queue, "B"));
        Future<?> consumerC = executorService.submit(new MancalaConsumer(queue, "C"));

        try {
            // Join on completion
            producer.get();
            consumerA.get();
            consumerB.get();
            consumerC.get();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(
                    "Main thread caught ExecutionException: " + e.getMessage());
        }

        executorService.shutdown();
    }
}
