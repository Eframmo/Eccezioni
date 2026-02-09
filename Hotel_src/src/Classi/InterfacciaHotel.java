package Classi;

import Eccezzioni.CameraOccupataException;
import Eccezzioni.ClienteNonValidoException;
import Eccezzioni.PrenotazioneException;

import java.util.ArrayList;

public class InterfacciaHotel {

    private GestorePrenotazioni gestorePrenotazioni;
    private ArrayList<String> storico;

    public InterfacciaHotel(GestorePrenotazioni gestorePrenotazioni) {
        this.gestorePrenotazioni = gestorePrenotazioni;
        this.storico = new ArrayList<>();
    }

    public void richiestaPrenotazione(String camera, String cliente){

        try {
            gestorePrenotazioni.prenota(camera, cliente);
            System.out.println("Richiesta processata per camera " + camera);
        } catch (CameraOccupataException e) {
            storico.add("Camera["+camera+"] non disponibile");
        }catch (ClienteNonValidoException e){
            storico.add("dati cliente non validi");
        }catch (PrenotazioneException e){
            storico.add("Errore di sistema, riprova piu tardi");
        }
    }

    public void stampaStorico(){
        System.out.println(storico);
    }
}
