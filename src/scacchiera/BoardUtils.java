package scacchiera;

/**
 * Classe contenente delle utils per la scacchiera
 */
public class BoardUtils {

    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla prima colonna.
     */
    public static boolean[] FIRST_COLUMN=null;
    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla seconda colonna.
     */
    public static boolean[] SECOND_COLUMN=null;
    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla settima colonna.
     */
    public static final boolean[] SEVENTH_COLUMN = null;
    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla ottava colonna.
     */
    public static final boolean[] EIGTH_COLUMN = null;

    /**
     * Costruttore privato della classe che lancia un'ecezzione in runtime se dovesse essere utilizzato in maniera scorretta
     */
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
