package pezzi;

import giocatori.Alliance;
import scacchiera.Board;
import scacchiera.Move;

import java.util.Collection;

/**
 * Classe per identificare i pezzi all'interno della scacchiera.
 */
public abstract class Piece {
    /**
     * Indica la posizione del pezzo
     */
    protected final int piecePosition;
    /**
     * Indica a quale fazione fa riferimento il pezzo (bianco/nero)
     */
    protected final Alliance pieceAllience;

    /**
     * Costruttore di classe
     * @param piecePosition final int - posizione del pezzo
     * @param pieceAllience final Alliance - fazione a cui fa riferimento il pezzo
     */
    public Piece(final int piecePosition, final Alliance pieceAllience){
        this.piecePosition=piecePosition;
        this.pieceAllience=pieceAllience;
    }

    /**
     * Lista delle mosse possibili che il pezzo può fare
     * @param board final Board - scacchiera
     * @return List {@literal <Move>} - lista delle mosse
     */
    public abstract Collection<Move> calculateLegalMoves(final Board board);

    /**
     * Restituisce la posizione di un pezzo
     * @return int
     */
    public int getPiecePosition() {
        return this.piecePosition;
    }

    /**
     * Restituisc la fazione a cui fa parte il pezzo
     * @return Alliance
     */
    public Alliance getPieceAllience() {
        return this.pieceAllience;
    }
}
