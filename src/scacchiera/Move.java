package scacchiera;

import pezzi.Piece;

/**
 * Classe astratta rappresentante la mossa. Da questa classe derivano le classi MajjorMove e AttackMove
 */
public abstract class Move {
    /**
     * Scacchiera
     */
    final Board board;
    /**
     * Pezzo da muovere
     */
    final Piece movedPiece;
    /**
     * coordinata da muovere
     */
    final int destinationCoordinate;

    /**
     * Costruttore della classe astratta
     * @param board scacchiera
     * @param movedPiece pezzo da muovere
     * @param destinationCoordinate coordinata destinazione
     */
    public Move(final Board board, final Piece movedPiece, final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }
}
