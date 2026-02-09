public class MacchinaDiagnosi {

    private boolean occupato;

    public MacchinaDiagnosi() {
        this.occupato = false;
    }

    public MacchinaDiagnosi assegnaMacchina() throws MacchinaOccupataException {
        double n = Math.random();

        if (n < 0.3){
            throw new MacchinaOccupataException("Macchina Occupata");
        }

        return this;
    }

    public void eseguiDiagnosi(Paziente p){
        double n = Math.random();

        if (n < 0.2){
            throw new MacchinaGuastaException("Maccchina guasta, attendere l'assistenza...");
        }

        p.setDiagnosiEffettutata(true);
    }
}
