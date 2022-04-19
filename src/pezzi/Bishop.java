package pezzi;

import giocatori.Alliance;
import org.carrot2.shaded.guava.common.collect.ImmutableList;
import scacchiera.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe Bishop rappresentante il pezzo dell'alfiere sulla scacchiera
 */
public class Bishop extends Piece{
    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES ={-9,-7,7,9};
    /**
     * Costruttore di classe
     *
     * @param piecePosition final int - posizione del pezzo
     * @param pieceAllience final Alliance - fazione a cui fa riferimento il pezzo
     */
    public Bishop(int piecePosition, Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    /**
     * Funzione per calcolare le mosse legali del corrente pezzo.
     * @param board final Board - scacchiera
     * @return Collection{@literal <Move>} - collezione di mosse legali del pezzo
     */
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves= new ArrayList<>();
        for(final int candidateCoordinateOffset:CANDIDATE_MOVE_VECTOR_COORDINATES){
            int candidateDestinationCoordinate=this.piecePosition;
            while(BoardUtils.isValidaTileCoordinate(candidateDestinationCoordinate)){
                if(isFirstColumnEsclusion(candidateDestinationCoordinate,candidateCoordinateOffset)||isEightColumnEsclusion(candidateDestinationCoordinate,candidateCoordinateOffset)){
                    break;
                }
                candidateDestinationCoordinate+=candidateCoordinateOffset;
                if(BoardUtils.isValidaTileCoordinate(candidateDestinationCoordinate)){
                    final Tile candidateDestinationTile=board.getTile(candidateDestinationCoordinate);
                    if(!candidateDestinationTile.isTileOccupated()){
                        legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
                    }else{
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance= pieceAtDestination.getPieceAllience();
                        if(this.pieceAllience!=pieceAlliance){
                            legalMoves.add(new AttackMove(board,this,candidateDestinationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    private boolean isFirstColumnEsclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition]&&(candidateOffset==-9||candidateOffset==7);
    }
    private boolean isEightColumnEsclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGTH_COLUMN[currentPosition]&&(candidateOffset==-7||candidateOffset==9);
    }
}
