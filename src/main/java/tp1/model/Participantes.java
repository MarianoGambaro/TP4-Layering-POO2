package tp1.model;

public class Participantes {

    private RegistroParticipantes registroDeParticipantes;

    //delega en la interfaz registroParticipantes, la cual debera implementar la base de datos
    public Participantes(RegistroParticipantes registroDeParticipantes){
        this.registroDeParticipantes = registroDeParticipantes;
    }

    public void nuevoParticipante(String nombre, String telefono, String region){
        var participante = new Participante(nombre,telefono,region);
        this.registroDeParticipantes.registrar(participante);
    }
}