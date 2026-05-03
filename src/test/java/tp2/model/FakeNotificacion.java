package tp2.model;

import java.util.ArrayList;
import java.util.List;

public class FakeNotificacion implements Notificacion{
    private int cantidadEnviados;
    private List<String> ultimoDestinatario;

    public FakeNotificacion(){
        this.ultimoDestinatario = new ArrayList<>();
    }

    @Override
    public void enviarEmail(String email, String textoDelEmail) {
        cantidadEnviados ++;
        ultimoDestinatario.add(email);
    }

    public int cantidadEnviados(){
        return cantidadEnviados;
    }

    public List<String> UltimoDestinatario(){
        return ultimoDestinatario;
    }

    //metodo para verificar si la lista contiene el email de un participante que cumpla años
    public boolean contieneA(String email){
        return ultimoDestinatario.contains(email);
    }
}
