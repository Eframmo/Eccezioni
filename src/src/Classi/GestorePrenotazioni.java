package Classi;

import Eccezzioni.ClienteNonValidoException;
import Eccezzioni.DatabaseException;
import Eccezzioni.PrenotazioneException;

public class GestorePrenotazioni {

    private DatabaseSimulato databaseSimulato;

    public GestorePrenotazioni(DatabaseSimulato databaseSimulato) {
        this.databaseSimulato = databaseSimulato;
    }

    public void prenota(String numeroCamera, String nomeCliente) throws PrenotazioneException {

        if (nomeCliente != null || nomeCliente.equals("")){
            throw new ClienteNonValidoException("nome cliente non valido");
        }

        try {
            databaseSimulato.verificaDisponibilita(numeroCamera);
            System.out.println("prenotazione confermata");
        } catch (DatabaseException e) {
            throw new PrenotazioneException("Errore sistema: [messaggio originale]");
        }
    }
}
