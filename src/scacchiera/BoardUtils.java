package scacchiera;

public class BoardUtils {

    private BoardUtils(){
        throw new RuntimeException("Non puoi utilizzare il costruttore della classe BoardUtils");
    }
    /**
     * Metodo per verificare se una mossa è valida o meno
     * @param coordinate coordinata da verificare
     * @return boolean - vero se la coordinata della mossa è valida, falso altrimenti.
     */
    public static boolean isValidaTileCoordinate(int coordinate){
        return coordinate >=0 && coordinate<64;
    }
}
