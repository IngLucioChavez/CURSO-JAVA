package modelo.interfaces;

import excepciones.*;
import modelo.Prestamo;
import modelo.personas.Socio;

import java.time.LocalDate;

public interface Prestable {

    Prestamo prestar(Socio persona, LocalDate fechaFinalPrestamo) throws BibliotecaException;
    Prestamo prestar(Socio persona, Long diasPrestamo) throws BibliotecaException;

}
