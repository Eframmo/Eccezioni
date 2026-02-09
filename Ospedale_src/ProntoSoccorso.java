import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ProntoSoccorso {

    private ArrayList<String> log;
    private ArrayList<Paziente> pazienti;
    private Medico medico;
    private SalaOperatoria salaOperatoria;
    private MacchinaDiagnosi macchinaDiagnosi;

    public ProntoSoccorso(Medico medico, SalaOperatoria salaOperatoria, MacchinaDiagnosi macchinaDiagnosi) {
        this.pazienti = new ArrayList<>();
        this.medico = medico;
        this.salaOperatoria = salaOperatoria;
        this.log = new ArrayList<>();
        this.macchinaDiagnosi = macchinaDiagnosi;
    }

    public void arrivoPazienti(Paziente p){
        pazienti.add(p);
    }

    public void gestisciPazienti(){
        do {
            for (int i = 0; i < pazienti.size(); i++) { // Curiamo prima quelli Gialli e Rossi
                if (pazienti.get(i).getCodiceGravita().equals("Rosso") || pazienti.get(i).getCodiceGravita().equals("Giallo")) {
                    try {
                        medico.gestionePazienti(pazienti.get(i), salaOperatoria.assegnaSala());
                        log.add("Paziente curato con successo");
                        pazienti.remove(i);
                    } catch (MedicoOccupatoException | SalaOperatoriaOccupataException | ComplicanzaException  e) {
                        log.add(e.getMessage());
                    }
                }
            }

            for (int i = 0; i < pazienti.size(); i++){
                try {
                    medico.gestionePazienti(pazienti.get(i), macchinaDiagnosi.assegnaMacchina());
                    log.add("Paziente curato con successo");
                    pazienti.remove(i);
                } catch (MedicoOccupatoException | MacchinaGuastaException | MacchinaOccupataException e) {
                    log.add(e.getMessage());
                }
            }

        } while (!pazienti.isEmpty());

    }

    public void simulaGiorno(){
        System.out.println("inzio giorno con " + pazienti.size() +" pazienti");
        for (int i = 0; i < pazienti.size(); i++){
            gestisciPazienti();
        }

        System.out.println("Fine giornata");
    }

    public void stampa(){
        System.out.println(log);
        System.out.println("Numero di log: " + log.size());

        System.out.println("Numero di pazienti curati: " + Collections.frequency(log, "Paziente curato con successo"));
    }
}
