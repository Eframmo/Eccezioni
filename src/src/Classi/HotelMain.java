package Classi;

import java.util.Random;

public class HotelMain {
    public static void main(String[] args) {

        Random ran = new Random();

        DatabaseSimulato databaseSimulato = new DatabaseSimulato();
        GestorePrenotazioni gestorePrenotazioni = new GestorePrenotazioni(databaseSimulato);
        InterfacciaHotel interfacciaHotel = new InterfacciaHotel(gestorePrenotazioni);

        for (int i = 0; i < 10; i++){
            String n = "" + ran.nextInt(100);
            interfacciaHotel.richiestaPrenotazione(n, "ciao");
        }

        interfacciaHotel.stampaStorico();
    }
}