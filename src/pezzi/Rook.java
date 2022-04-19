package pezzi;

import giocatori.Alliance;
import org.carrot2.shaded.guava.common.collect.ImmutableList;
import scacchiera.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe rappresentante la torre nella scacchiera
 */
public class Rook extends Piece{
    /**
     * Distanze che il pezzo può percorrere per spostarsi da una posizione ad un'altra
     */
    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES ={-8,-1,1,8};
    /**
     * Costruttore di classe
     *
     * @param piecePosition final int - posizione del pezzo
     * @param pieceAllience final Alliance - fazione a cui fa riferimento il pezzo
     */
    public Rook(int piecePosition, Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    /**
     * Funzione per calcolare la lista di mosse legali per il seguente pezzo
     * @param board final Board - scacchiera
     * @return Collection {@literal <Move>} - collezione di movimenti
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

    /**
     * Funzione per verificare le condizioni per il calcolo delle mosse legali del pezzo sulla scacchiera
     * @param currentPosition Posizione corrente del pezzo
     * @param candidateOffset Quantità di celle da spostare
     * @return bollean - True o False
     */
    private boolean isFirstColumnEsclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition]&&(candidateOffset==-1);
    }

    /**
     * Funzione per verificare le condizioni per il calcolo delle mosse legali del pezzo sulla scacchiera
     * @param currentPosition Posizione corrente del pezzo
     * @param candidateOffset Quantità di celle da spostare
     * @return bollean - True o False
     */
    private boolean isEightColumnEsclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGTH_COLUMN[currentPosition]&&(candidateOffset==1);
    }
}
