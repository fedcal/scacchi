package pezzi;

import giocatori.Alliance;

/**
 * Classe per identificare i pezzi all'interno della scacchiera.
 */
public class Piece {
    private final int piecePosition;
    private final Alliance pieceAllience;

    Piece(final int piecePosition, final Alliance pieceAllience){
        this.piecePosition=piecePosition;
        this.pieceAllience=pieceAllience;
    }
}
