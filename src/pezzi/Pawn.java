package pezzi;

import giocatori.Alliance;
import org.carrot2.shaded.guava.common.collect.ImmutableList;
import scacchiera.Board;
import scacchiera.BoardUtils;
import scacchiera.MajorMove;
import scacchiera.Move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe Pawn per rappresentare il pedone sulla scacchiera
 */
public class Pawn extends Piece{
    /**
     * Attributo per indicare la mossa candidata ad essere effettuata
     */
    private final static int[] CANDIDATE_MOVE_COORDINATE={8,16,7,9};
    /**
     * Costruttore di classe
     *
     * @param piecePosition final int - posizione del pezzo
     * @param pieceAllience final Alliance - fazione a cui fa riferimento il pezzo
     */
    public Pawn(final int piecePosition, final Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    /**
     * Metodo per calcolare le mosse legali del Pedone
     * @param board final Board - scacchiera
     * @return Collection {@literal <Move>} - Collezione di mosse
     */
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves=new ArrayList<>();
        for(final int currentCandidateOffset:CANDIDATE_MOVE_COORDINATE){
            final int candidateDestinationCoordinate=this.piecePosition+(this.pieceAllience.getDirection()*currentCandidateOffset);
            if(!BoardUtils.isValidaTileCoordinate(candidateDestinationCoordinate)){
                continue;
            }
            if(currentCandidateOffset==8 && !board.getTile(candidateDestinationCoordinate).isTileOccupated()){
                legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
            }else if(currentCandidateOffset==16 && this.isFirstMove() && (BoardUtils.SECOND_ROW[this.piecePosition]&& this.getPieceAllience().isBlack())||(BoardUtils.SEVENTH_ROW[this.piecePosition]&&this.getPieceAllience().isWhite())){
                final int behindCandidateDestinationCoordinate = this.piecePosition +(this.pieceAllience.getDirection()*8);
                if(!board.getTile(behindCandidateDestinationCoordinate).isTileOccupated()&& !board.getTile(candidateDestinationCoordinate).isTileOccupated()){
                    legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
                }
            }else if(currentCandidateOffset==7&&!((BoardUtils.EIGTH_COLUMN[this.piecePosition]&& this.pieceAllience.isWhite()) || (BoardUtils.FIRST_COLUMN[this.piecePosition]&& this.pieceAllience.isBlack()))){
                if(board.getTile(candidateDestinationCoordinate).isTileOccupated()){
                    final Piece pieceOnCandidate=board.getTile(candidateDestinationCoordinate).getPiece();
                    if(this.pieceAllience!=pieceOnCandidate.getPieceAllience()){
                        legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
                    }
                }

            }else if(currentCandidateOffset==9 && !((BoardUtils.FIRST_COLUMN[this.piecePosition]&& this.pieceAllience.isWhite()) || (BoardUtils.EIGTH_COLUMN[this.piecePosition]&& this.pieceAllience.isBlack()))){
                if(board.getTile(candidateDestinationCoordinate).isTileOccupated()){
                    final Piece pieceOnCandidate=board.getTile(candidateDestinationCoordinate).getPiece();
                    if(this.pieceAllience!=pieceOnCandidate.getPieceAllience()){
                        legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
}
