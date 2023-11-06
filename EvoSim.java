//importiert den Scanner

import java.util.Scanner;

public class EvoSim {

    public static void main(String[] args) {
        //Anzahl der Reihen 
        int reihen = 5;
        int spalten = 5;
//Anlegen eines neuen Scanners
        Scanner input = new Scanner(System.in);
//Textausgabe
        System.out.println("Für wie viele Jahre soll die Simulation berechnet werden?");
        //Benutzereingabe für Anzahl der Jahre
        int jahre = input.nextInt();
//Erstelle eine neue Instanz der Spielbrett Klasse
        Spielbrett spielbrett = new Spielbrett(reihen, spalten);
//Textausgabe
        System.out.println("Geben Sie die Anfangsbelegung ein. !!! 0 für nichts. 1 für Wesen!!!");
        //Verschachtelte for-Schleife durchläuft alle Zellen des 2D-Arrays
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < spalten; j++) {
                //Benutzereingabe für die Belegung der Felder
                int belegung = input.nextInt();
                //Belegung des Spielbretts wird festgelegt
                spielbrett.setZustand(i, j, belegung);
                //Gibt die aktuelle Belegung des Spielbretts aus 
                Drucker.druckeBelegung(spielbrett);
            }
        }
//Führt die Simulation für die vom Benutzer angegebenen Jahre durch 
        for (int aktuellesJahr = 0; aktuellesJahr < jahre; aktuellesJahr++) {
            System.out.println("");
            System.out.println("Jahr " + (aktuellesJahr + 1));
            System.out.println("");
            spielbrett.aktualisiereSimulation();
            Drucker.druckeBelegung(spielbrett);

        }
        input.close();
    }
}
