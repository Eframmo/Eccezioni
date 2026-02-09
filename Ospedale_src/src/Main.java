import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Medico medico = new Medico("Efra figo");
        SalaOperatoria salaOperatoria = new SalaOperatoria(1);
        MacchinaDiagnosi macchinaDiagnosi = new MacchinaDiagnosi();
        ProntoSoccorso prontoSoccorso = new ProntoSoccorso(medico, salaOperatoria, macchinaDiagnosi);

        String[] codici = {"Rosso", "Giallo", "Verde"};

        for (int i = 0; i < 20; i++){
            prontoSoccorso.arrivoPazienti(new Paziente("Paziente ", codici[new Random().nextInt(3)]));
        }

        prontoSoccorso.simulaGiorno();
        prontoSoccorso.stampa();
    }
}