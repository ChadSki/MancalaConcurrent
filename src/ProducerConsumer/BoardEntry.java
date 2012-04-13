package ProducerConsumer;

import MancalaBoard.MancalaBoard;

/**
 * User: Chad
 * Date: 4/11/12
 * Time: 2:14 PM
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
