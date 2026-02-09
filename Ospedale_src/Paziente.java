public class Paziente {

    private String nome;
    private String codiceGravita;
    private boolean diagnosiEffettutata;

    public Paziente(String nome, String codiceGravita) {
        this.nome = nome;
        this.codiceGravita = codiceGravita;
        this.diagnosiEffettutata = false;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodiceGravita(String codiceGravita) {
        this.codiceGravita = codiceGravita;
    }

    public void setDiagnosiEffettutata(boolean diagnosiEffettutata) {
        this.diagnosiEffettutata = diagnosiEffettutata;
    }

    public String getNome() {
        return nome;
    }

    public String getCodiceGravita() {
        return codiceGravita;
    }

    public boolean isDiagnosiEffettutata() {
        return diagnosiEffettutata;
    }
}
