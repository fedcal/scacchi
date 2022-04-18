package pezzi;

import giocatori.Alliance;
import org.carrot2.shaded.guava.common.collect.ImmutableList;
import scacchiera.Board;
import scacchiera.BoardUtils;
import scacchiera.Move;
import scacchiera.Tile;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    /**
     * Mosse candidate ad essere effettuate per il seguente pezzo
     */
    private  final static int[] CANDIDATE_MOVE_COORDINATES={-17,-15,-10,-6,6,10,15,17};
    /**
     * Costruttore di classe
     *
     * @param piecePosition final int - posizione del pezzo
     * @param pieceAllience final Alliance - fazione a cui fa riferimento il pezzo
     */
    public Knight(int piecePosition, Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    /**
     * Ovveride della funzione derivante dalla clasee Piece per definire le mosse legali del pezzo Knight
     * @param board final Board - scacchiera
     * @return
     */
    @Override
    public List<Move> calculateLegalMoves(Board board) {
        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();
        for(final int currentCandidate:CANDIDATE_MOVE_COORDINATES){
            candidateDestinationCoordinate=this.piecePosition +currentCandidate;
            if(BoardUtils.isValidaTileCoordinate(candidateDestinationCoordinate)){
                final Tile candidateDestinationTile=board.getTile(candidateDestinationCoordinate);
                if(!candidateDestinationTile.isTileOccupated()){
                    legalMoves.add(new Move());
                }else{
                    final Piece pieceDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance= pieceDestination.getPieceAllience();
                    if(this.pieceAllience!=pieceAlliance){
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

}
