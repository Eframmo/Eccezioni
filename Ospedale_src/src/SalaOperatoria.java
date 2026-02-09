public class SalaOperatoria {

    private int numero;
    private boolean occupata;

    public SalaOperatoria(int numero) {
        this.numero = numero;
        this.occupata = false;
    }

    public SalaOperatoria assegnaSala() throws SalaOperatoriaOccupataException{
        double n = Math.random();

        if (n < 0.3){
            occupata = true;
            throw new SalaOperatoriaOccupataException("Sala operatoria occupata");
        }else{
            occupata = false;
            return this;
        }
    }

    public void curaPaziente(Paziente p){
        double n = Math.random();

        if (n < 0.5){
            throw new ComplicanzaException("Complicanza avvenuta");
        }
        p.setDiagnosiEffettutata(true);
    }
}
