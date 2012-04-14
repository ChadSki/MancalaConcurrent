package ProducerConsumer;

import MancalaBoard.MancalaBoard;

/**
 * User: Chad
 * Date: 4/11/12
 * Time: 2:11 PM
 */
public class MancalaProducer implements Runnable {

    private final MancalaQueue m_queue;

    private final int m_numSlots;
    private final int m_ceiling;
    private final int m_numBeads;

    public MancalaProducer(MancalaQueue queue,
                           int numSlots, int ceiling, int numBeads) {
        m_queue = queue;

        m_numSlots = numSlots;
        m_ceiling = ceiling;
        m_numBeads = numBeads;
    }

    public void run() {
        MancalaBoard mb = new MancalaBoard(m_numSlots, m_ceiling, m_numBeads);
        int numPermutations = 0;
        while (mb != null) {
            m_queue.offer(new BoardEntry(mb, numPermutations));
            System.out.println("Added " + Integer.toString(numPermutations));
            mb = mb.generateNext();
            numPermutations++;
        }
        m_queue.close();
        System.out.println("Permutations: " + Integer.toString(numPermutations));
    }
}
