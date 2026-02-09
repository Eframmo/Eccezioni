package Eccezzioni;

public class ClienteNonValidoException extends PrenotazioneException{

    public ClienteNonValidoException(String msg) {
        super(msg);
    }
}
