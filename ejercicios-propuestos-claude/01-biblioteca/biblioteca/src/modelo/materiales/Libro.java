package modelo.materiales;

import interfaces.Imprimible;
import interfaces.Prestable;
import modelo.Prestamo;
import modelo.personas.Socio;

import java.time.LocalDate;

public class Libro extends Material implements Imprimible, Prestable {

    private Integer paginas;

    public Libro(String titulo, Integer anio, Genero genero, Integer paginas) {
        super(titulo, anio, genero);
        this.paginas = paginas;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder();
        texto.append(String.format("Tipo: %s\n",this.obtenerTipo()));
        texto.append(String.format("paginas: %s\n",paginas));
        texto.append(super.toString());

        return texto.toString();
    }

    @Override
    public Prestamo prestar(Socio persona, LocalDate fechaFinalPrestamo) {
        return new Prestamo(persona,fechaFinalPrestamo);
    }

    @Override
    public Prestamo prestar(Socio persona, Long diasPrestamo) {
        return new Prestamo(persona,diasPrestamo);
    }

    @Override
    public void devolver(Integer idPrestamo) {

    }

    @Override
    public String obtenerTipo() {
        return "Libro";
    }
}
