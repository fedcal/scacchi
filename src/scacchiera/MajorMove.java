package scacchiera;

import pezzi.Piece;

/**
 * Classe che rappresenta la mossa per far avanzare il pezzo. Estende la classe Move
 */
public final class MajorMove extends Move{
    /**
     * Costruttore di classe che richiama quello della super classe per effettuare la mossa
     * @param board scacchiera
     * @param movedPiece pezzo da muovere
     * @param destinationCoordinate coordinata di destinazione
     */
    public MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinate){
        super(board, movedPiece,destinationCoordinate);
    }
}
