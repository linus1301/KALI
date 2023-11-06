public class Drucker {

    /**
     * Diese Methode zeigt das aktuelle Spielbrett auf der Konsole an
     *
     * @param spielbrett spielbrett dient dazu um auf die aktuellen Daten des
     * Spielbretts zuzugreifen
     */
    
    public static void druckeBelegung(Spielbrett spielbrett) {
        //Greift auf die Felder der Spielbrett-Instanz zu 
        int[][] feld = spielbrett.feld;
        //Durchläuft alle Zeilen und Spalten 
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                //Der Wert des Feld wird ausgegeben 
                System.out.print(feld[i][j] + " ");
            }
            //Zeilenumbruch 
            System.out.println();
        }
    }

}
