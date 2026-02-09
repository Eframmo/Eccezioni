public class Medico {

    private String nome;
    private boolean occupato;

    public Medico(String nome) {
        this.nome = nome;
        this.occupato = false;
    }

    public void gestionePazienti(Paziente p, SalaOperatoria salaOperatoria) throws MedicoOccupatoException{
        double n = Math.random();

        if (n < 0.2){
            occupato = true;
            throw new MedicoOccupatoException("Medico occupato");
        }

        salaOperatoria.curaPaziente(p);
    }

    public void gestionePazienti(Paziente p, MacchinaDiagnosi macchinaDiagnosi) throws MedicoOccupatoException {
        double n = Math.random();

        if (n < 0.2){
            occupato = true;
            throw new MedicoOccupatoException("Medico occupato");
        }

        macchinaDiagnosi.eseguiDiagnosi(p);
    }
}
