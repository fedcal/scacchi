package giocatori;

/**
 * Classe enum rappresentante l'alleanza negli scacchi, ovvero i colori dei pezzi delle due fazioni Nero/Bianco
 */
public enum Alliance {
    /**
     * Rappresenta l'alleanza bianca
     */
    WHITE{
        /**
         * Ovveride della funzione base della classe enum Alliance
         * @return int - -1 per indicare il pedone dell'alleanza bianca
         */
        @Override
        public int getDirection(){
            return -1;
        }

        /**
         * Implementazione del metodo astratto per l'alleanza bianca
         * @return boolean - true
         */
        @Override
        public boolean isWhite() {
            return true;
        }

        /**
         * Implementazione del metodo astratto per l'alleanza bianca
         * @return boolean - false
         */
        @Override
        public boolean isBlack() {
            return false;
        }
    },
    /**
     * Rappresenta l'alleaza nera
     */
    BLACK{
        /**
         * Ovveride della funzione base della classe enum Alliance
         * @return int - 1 per indicare il pedone dell'alleanza nera
         */
        @Override
        public int getDirection(){
            return 1;
        }

        /**
         * Implementazione del metodo astratto per l'alleanza nera
         * @return boolean - false
         */
        @Override
        public boolean isWhite() {
            return false;
        }

        /**
         * Implementazione del metodo astratto per l'alleanza bianca
         * @return boolean - true
         */
        @Override
        public boolean isBlack() {
            return true;
        }
    };

    /**
     * Questo metodo serve per ottenere la direzione delle due alleanze, utile per la gestione del movimento del pedone
     * @return int - indica la direzione 1: alleanza nera -1:alleanza bianca
     */
    public abstract int getDirection();

    /**
     * Metodo astratto per verificare se il pezzo è dell'alleanza bianca
     * @return boolean - true o false
     */
    public abstract boolean isWhite();

    /**
     * Metodo astratto per verificare se il pezzo è dell'alleanza nera
     * @return boolean - true o false
     */
    public abstract boolean isBlack();
}
