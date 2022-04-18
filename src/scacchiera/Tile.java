package scacchiera;

import org.carrot2.shaded.guava.common.collect.ImmutableMap;
import pezzi.Piece;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe rappresentante una cella della scacchiera
 */
public abstract class Tile {
    /**
     * Coordinata della cella
     */
    private final int tileCoordinate;
    /**
     * Rappresentazione della scacchiera vuota attraverso le celle
     */
    private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();


    /**
     * Costruttore per creare una cella, che richiede come input una coordinata
     * @param tileCoordinate int - rappresenta la coordinata
     */
    protected Tile(final int tileCoordinate){
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

    /**
     * Costruzione di una scacchiera con celle vuote
     * @return ImmutableMap - una copia immutabile della scacchiera vuota
     */
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer,EmptyTile> emptyTileMap= new HashMap<>();
        for(int i=0; i<64;i++){
            emptyTileMap.put(i,new EmptyTile(i));
        }
        //return Collections.unmodifiableMap(emptyTileMap); //Se non si vuole utilizzare la libreria guava
        return  ImmutableMap.copyOf(emptyTileMap);//utilizzando la libreria guava
    }

    /**
     * Metodo per creare una cella. Prende in input un pezzo e una coordinata e restituisce una cella occupata o vuota.
     * @param tileCoordinate final int - cordinata cella
     * @param piece final Piece - pezzo da inserire
     * @return OccupiedTiele || EmptyTile - cella occupata o vuota
     */
    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate,piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }
}
