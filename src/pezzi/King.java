package pezzi;

import giocatori.Alliance;
import org.carrot2.shaded.guava.common.collect.ImmutableList;
import scacchiera.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Pezzo rappresentante il re sulla scacchiera
 */
public class King extends Piece{
    /**
     * Mosse canidate per essere effettuate dal giocatore per il seguente pezzo
     */
    private final static int[] CANDIDATE_MOVE_COORDINATE={-9,-8,-7,-1,1,7,8,9};
    /**
     * Costruttore di classe
     *
     * @param piecePosition final int - posizione del pezzo
     * @param pieceAllience final Alliance - fazione a cui fa riferimento il pezzo
     */
    public King(int piecePosition, Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    /**
     * Override del metodo ereditato dalla sperclasse Piece per calcolare l'insieme delle mosse legali che il pezzo
     * può compiere
     * @param board final Board - scacchiera
     * @return Collection {@literal <Move>} - Collezione di msse
     */
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves= new ArrayList<>();
        for(final int currentCandidateOffset:CANDIDATE_MOVE_COORDINATE){
            final int candidateDestinationCoordinate=this.piecePosition+currentCandidateOffset;
            if(isFirstColumnExclusion(this.piecePosition,currentCandidateOffset)||isEightColumnExclusion(this.piecePosition,currentCandidateOffset)){
                continue;
            }
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
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    /**
     *Funzione per verificare se la posizione in cui risiede il cavallo è la pima colonna e verifica i vari offset della
     * scacchiera
     * @param currentPosition final int - posizione corrente del cavallo
     * @param candidateOffset final int - posizione candidata al mmovimento
     * @return boolean - true o false
     */
    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition]&&((candidateOffset ==-9)||(candidateOffset==-1)||(candidateOffset==7));
    }

    /**
     * Verifico se il cavallo va in una posizionescorretta nella seconda colonna
     * @param currentPosition posizione corrente del cavallo
     * @param candidateOffset posizione candidata di offset
     * @return boolean - true o false
     */
    private static boolean isEightColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGTH_COLUMN[currentPosition]&&(candidateOffset==-7 || candidateOffset==1|| candidateOffset==9);
    }
}
