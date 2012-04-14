import ProducerConsumer.MancalaConsumer;
import ProducerConsumer.MancalaProducer;
import ProducerConsumer.MancalaQueue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        MancalaQueue queue = new MancalaQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        Future<?> producer;
        Future<?> consumerA;
        Future<?> consumerB;
        Future<?> consumerC;
        producer = executorService.submit(new MancalaProducer(queue, numSlots, ceiling, numBeads));
        consumerA = executorService.submit(new MancalaConsumer(queue, "A"));
        consumerB = executorService.submit(new MancalaConsumer(queue, "B"));
        consumerC = executorService.submit(new MancalaConsumer(queue, "C"));

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
