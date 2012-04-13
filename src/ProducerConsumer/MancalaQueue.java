package ProducerConsumer;

import ProducerConsumer.BoardEntry;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Chad Zawistowski <crz8448@rit.edu>
 */
public class MancalaQueue extends LinkedBlockingQueue<BoardEntry> {

    protected boolean queueClosed;

    public MancalaQueue() {
        super();
        queueClosed = false;
    }

    public void close() {
        queueClosed = true;
    }

    public boolean isClosed() {
        return queueClosed;
    }

}
