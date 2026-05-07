package tp3.model;

public interface RegistroInscripciones {
    void registrarInscripcion(Inscripcion inscripcion);
}

//jdeps -verbose:package -p tp3.persistencia -p tp3.model -p tp3.vista target\classes