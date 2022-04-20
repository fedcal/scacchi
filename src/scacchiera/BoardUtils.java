package scacchiera;

/**
 * Classe contenente delle utils per la scacchiera
 */
public class BoardUtils {

    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla prima colonna.
     */
    public static boolean[] FIRST_COLUMN=initColumn(0);
    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla seconda colonna.
     */
    public static boolean[] SECOND_COLUMN=initColumn(1);
    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla settima colonna.
     */
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    /**
     * Array di valori boolean di dimensione uguale a 64. Tutti i campi sono impostati a fasle tranne quelli corrispondenti
     * alla ottava colonna.
     */
    public static final boolean[] EIGTH_COLUMN = initColumn(7);
    /**
     * Vettore per indicare la seconda riga della scacchiera, utile per la gestione della prima mossa dei pedoni neri
     */
    public static final boolean[] SECOND_ROW=null;
    /**
     * Vettore per indicare la seconda riga della scacchiera, utile per la gestione della prima mossa dei pedoni bianchi
     */
    public static final boolean[] SEVENTH_ROW=null;
    /**
     * Numero di celle
     */
    public static final int NUM_TIELS=64;
    /**
     * numero di celle per riga
     */
    public static final int NUM_TILES_PER_ROW=8;

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
    public static boolean isValidaTileCoordinate(final int coordinate){
        return coordinate >=0 && coordinate<NUM_TIELS;
    }

    /**
     * Metodo per inizializzare automaticamente i parametri di classe
     * @param columnNumber int - numero di colonna
     * @return boolean[] - vettore di valori di tipo boolean
     */
    private static boolean[] initColumn(int columnNumber) {
        final boolean[] column = new boolean[NUM_TIELS];
        do{
            column[columnNumber]= true;
            columnNumber+=NUM_TILES_PER_ROW;
        }while(columnNumber<NUM_TIELS);
        return column;
    }
}
