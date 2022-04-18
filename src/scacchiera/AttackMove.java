package scacchiera;

import pezzi.Piece;

/**
 * Classe che estende la clase Move e che rappresenta la mossa per attaccare un pezzo dell'alleanza opposta
 */
public class AttackMove extends Move{
    final Piece attackedPiece;
    /**
     * Costruttore di classe
     * @param board scacchiera
     * @param movedPiece pezzo da muovere
     * @param destinationCoordinate cordinata di destinazione
     * @param attackedPiece
     */
    public AttackMove(final Board board, final Piece movedPiece, final int destinationCoordinate, Piece attackedPiece){
        super(board,movedPiece,destinationCoordinate);
        this.attackedPiece = attackedPiece;
    }
}
