package interfaces;

import modelo.Prestamo;
import modelo.personas.Socio;

import java.time.LocalDate;

public interface Prestable {

    Prestamo prestar(Socio persona, LocalDate fechaFinalPrestamo);
    Prestamo prestar(Socio persona, Long diasPrestamo);
    void devolver(Integer idPrestamo);

}
