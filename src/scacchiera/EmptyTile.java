package scacchiera;

import pezzi.Piece;

/**
 * Classe rappresentante una cella vuota
 */
public  final class EmptyTile extends Tile{
    /**
     * Costruttore classe EmptyTile
     * @param coordinate
     */
    public EmptyTile(int coordinate){
        super(coordinate);
    }

    /**
     * Metodo per verificare se la cella è occupata o meno. In questo caso restituisce sempre false, in quanto una
     * cella vuota non è mai occupata
     * @return boolean - False
     */
    @Override
    public boolean isTileOccupated() {
        return false;
    }

    /**
     * Restituisce il pezzo presente nella cella. In questo caso essendo vuota restituisce il valore null
     * @return null
     */
    @Override
    public Piece getPiece() {
        return null;
    }
}
