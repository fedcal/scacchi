package pezzi;

import giocatori.Alliance;
import org.carrot2.shaded.guava.common.collect.ImmutableList;
import scacchiera.Board;
import scacchiera.BoardUtils;
import scacchiera.Move;
import scacchiera.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe raffigurante il cavallo
 */
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
     * @return List{@literal<Move>} - lista di mosse lecite
     */
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for(final int currentCandidateOffset:CANDIDATE_MOVE_COORDINATES){
            final int candidateDestinationCoordinate=this.piecePosition +currentCandidateOffset;
            if(BoardUtils.isValidaTileCoordinate(candidateDestinationCoordinate)){
                if(isFirstColumnExclusion(this.piecePosition, currentCandidateOffset)||isSecondColumnExclusion(this.piecePosition, currentCandidateOffset)||isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset)||isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)){
                    continue;
                }
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

    /**
     *Funzione per verificare se la posizione in cui risiede il cavallo è la pima colonna e verifica i vari offset della
     * scacchiera
     * @param currentPosition final int - posizione corrente del cavallo
     * @param candidateOffset final int - posizione candidata al mmovimento
     * @return boolean - true o false
     */
    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition]&&((candidateOffset ==-17)||(candidateOffset==-10)||(candidateOffset==6)|| (candidateOffset==15));
    }

    /**
     * Verifico se il cavallo va in una posizionescorretta nella seconda colonna
     * @param currentPosition posizione corrente del cavallo
     * @param candidateOffset posizione candidata di offset
     * @return boolean - true o false
     */
    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.SECOND_COLUMN[currentPosition]&&(candidateOffset==-10 || candidateOffset==6);
    }

    /**
     * Verifico se il cavallo va in una posizione scorretta nella settima colonna
     * @param currentPosition posizione corrente del cavallo
     * @param candidateOffset posizione candidata di offset
     * @return boolean - true o false
     */
    private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.SEVENTH_COLUMN[currentPosition]&&(candidateOffset==-6 || candidateOffset==10);
    }

    /**
     * Verifico se il cavallo va in una posizione scorretta nell'ootava colonna
     * @param currentPosition posizione corrente del cavallo
     * @param candidateOffset posizione candidata di offset
     * @return boolean - true o false
     */
    private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGTH_COLUMN[candidateOffset]&&(candidateOffset==-15||candidateOffset==-6||candidateOffset==10||candidateOffset==17);
    }
}
