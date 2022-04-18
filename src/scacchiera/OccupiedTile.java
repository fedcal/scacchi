package scacchiera;

import pezzi.Piece;

/**
 * Classe rappresentate una scacchiera occupata
 */
public final class OccupiedTile extends Tile{
    /**
     * Pezzo rappresentante il pezzo sulla scacchiera
     */
    private final Piece pieceOnTile;

    /**
     * Costruttore della classe
     * @param tileCoordinate int - coordinata della classe
     * @param pieceOnTile Piece - pezzo della scacchiera
     */
    public OccupiedTile(final int tileCoordinate, final Piece pieceOnTile){
        super(tileCoordinate);
        this.pieceOnTile=pieceOnTile;
    }

    /**
     * Metodo per verificare se la scacchiera è occupata o meno. In questo caso restituirà sempre true
     * @return boolean - True
     */
    @Override
    public boolean isTileOccupated() {
        return true;
    }

    /**
     * Metodo per restituire il pezzo presente nella cella
     * @return Piece - il pezzo
     */
    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
}
