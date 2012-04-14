package ProducerConsumer;

import MancalaBoard.MancalaBoard;

/**
 * TODO javadocs
 *
 * @author Chad Zawistowski <crz8448@rit.edu>
 */
public class BoardEntry {

    private final MancalaBoard m_board;
    private final int m_numInSequence;

    public BoardEntry(MancalaBoard board, int numInSequence) {
        m_board = board;
        m_numInSequence = numInSequence;
    }

    public MancalaBoard getBoard() {
        return m_board;
    }

    public int getNumInSequence() {
        return m_numInSequence;
    }
}
