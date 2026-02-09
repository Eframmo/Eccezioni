package Classi;

import Eccezzioni.DatabaseException;

import java.util.ArrayList;

public class DatabaseSimulato {

    private ArrayList<String> camereOccupate;
    private boolean connessioneAttiva;

    public DatabaseSimulato() {
        this.camereOccupate = new ArrayList<>();
        this.connessioneAttiva = true;
    }

    public boolean verificaDisponibilita(String numeroCamera) throws DatabaseException{

        if (!connessioneAttiva){
            throw new DatabaseException("connessione persa");
        }

        double n = Math.random();
        if (n <= 0.05){
            throw new DatabaseException("Timeout query");
        }else {
            if (camereOccupate.contains(numeroCamera)) {
                return true; // camera disponibile
            }else{
                return false;
            }
        }
    }

    public void salvaPrenotazione(String numeroCamera, String nomeCliente) throws DatabaseException{
        if (!connessioneAttiva) {
            throw new DatabaseException("Connessione al DB persa");
        }

        double n = Math.random();
        if (n <= 0.03){
            throw new DatabaseException("Errore scrittura");
        }else {
            camereOccupate.add(numeroCamera);
        }
    }

    public void ripristinaConnessione(){
        connessioneAttiva = true;
    }
}
