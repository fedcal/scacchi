package scacchiera;

import pezzi.Piece;

/**
 * Classe rappresentante una cella della scacchiera
 */
public abstract class Tile {
    /**
     * Coordinata della cella
     */
    private int tileCoordinate;

    /**
     * Costruttore per creare una cella, che richiede come input una coordinata
     * @param tileCoordinate int - rappresenta la coordinata
     */
    public Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }

    /**
     * Metodo per verificare se una cella è occupata o meno
     * @return boolean - se la scacchiera è occupata o meno
     */
    public abstract boolean isTileOccupated();

    /**
     * Metodo per recuperare un pezzo della cella
     * @return Piece - Pezzo
     */
    public abstract Piece getPiece();
}
