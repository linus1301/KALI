public class Spielbrett {

    int[][] feld;
    private int reihen;
    private int spalten;

    /**
     * Der Konstruktor erstellt ein neues Objekt der Klasse Spielbrett
     *
     * @param reihen Anzahl der Reihen des Spielbretts
     * @param spalten Anzahl der Spalten des Spielbretts
     */
    public Spielbrett(int reihen, int spalten) {
        this.reihen = reihen;
        this.spalten = spalten;
        // Ein 2D-Array wird erstellt um das Spielbrett zu speichern. Es hat "reihen"-Reihen
        // und "spalten"-Spalten. Jedes Feld wird zu Beginn mit 0 initialisiert
        feld = new int[reihen][spalten];
    }

    /**
     * Diese Methode speichert die vom Nutzer eingegebene Belegung an der
     * Koordinate x,y
     *
     * @param x x Koordinaten auf dem Spielbrett
     * @param y y Koordinate auf dem Spielbrett
     * @param belegung Die eingebene Belegung des Benutzers
     */
    public void setZustand(int x, int y, int belegung) {
        feld[x][y] = belegung;
    }

    /**
     * Diese Methode zählt die Anzahl der Nachbarn eines Feldes
     *
     * @param x x-Koordinate des Felds
     * @param y y-Koordinate des Felds
     * @return gibt die Anzahl der Nachbarn zurück
     */
    private int zaehleNachbarn(int x, int y) {
        //Variable zum erfassen der Anzahl der Nachbarn 
        int nachbarn = 0;
        //Liste der Richtungen/Verschiebungen vom aktuellen Feld aus um die umliegenden Felder zu prüfen 
        int[][] richtungen = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        //durchläuft alle möglichen Richtungen im 2D-Array richtungen um die Nachbarn des aktuellen Felds zu zählen
        for (int[] richtung : richtungen) {
            //richtung[0] ist die Verschiebung in der Reihe, richtung[1] die Verschiebung in der Spalte 
            int neueReihe = x + richtung[0];
            int neueSpalte = y + richtung[1];
            //Es wird überprüft ob die neuen Koordinaten innerhalb des Spielfelds liegen
            if (neueReihe >= 0 && neueReihe < reihen && neueSpalte >= 0 && neueSpalte < spalten) {
                //Wenn das neue Feld einen Wert von 1 hat so wie 1 zu nachbarn hinzugefügt, ansonsten 0 
                nachbarn += feld[neueReihe][neueSpalte];
            }
        }
        //gibt den Wert von nachbarn zurück 
        return nachbarn;

    }

    /**
     * Diese Methode aktualisiert das Spielbrett basierend auf den Regeln für
     * die Simulation
     */
    public void aktualisiereSimulation() {
        //neues temporäres Feld wird erstellt um die Aktualisierung vorzunehmen 
        int[][] neuesFeld = new int[reihen][spalten];
        //Verschachtelte for-Schleife durchläuft jedes Feld des Spielbretts
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < spalten; j++) {
                //Die Methode "zaehleNachbarn" wird aufgerufen um die Anzahl der Nachbarn für das aktuelle Feld zu ermitteln 
                int nachbarn = zaehleNachbarn(i, j);
                //Wenn der Wert des aktuellen Feldes 1 beträgt 
                if (feld[i][j] == 1) {
                    //Wenn das Feld 2 oder 3 Nachbarn hat, so überlebt das Feld 
                    if (nachbarn == 2 || nachbarn == 3) {
                        neuesFeld[i][j] = 1;
                        //Wenn nicht, so stirbt es 
                    } else {
                        neuesFeld[i][j] = 0;
                    }
                    //Wenn der Wert des aktuellen Feldes 0 beträgt 
                } else {
                    //Wenn die Anzahl der Nachbarn des Feldes genau 3 beträgt 
                    if (nachbarn == 3) {
                        //ein neues Wesen entsteht 
                        neuesFeld[i][j] = 1;
                        //Wenn die Anzahl der Nachbarn des Feldes nicht genau 3 beträgt 
                    } else {
                        //Das Feld bleibt leer bzw auf 0
                        neuesFeld[i][j] = 0;
                    }
                }
            }
        }
        //das temporäre Feld wird als aktuelles Spielbrett übernommen 
        feld = neuesFeld;
    }
}
