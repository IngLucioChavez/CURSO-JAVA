package modelo.materiales;

import interfaces.Imprimible;
import interfaces.Prestable;
import interfaces.Renovable;
import modelo.Prestamo;
import modelo.personas.Socio;

import java.time.LocalDate;

public class Libro extends Material implements Imprimible, Prestable, Renovable {

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

        if(Prestamo.limiteAlcanzado(persona))
            return null;

        Prestamo prestamo = new Prestamo(persona,fechaFinalPrestamo);
        prestamo.addMaterial(this);

        return prestamo;

    }

    @Override
    public Prestamo prestar(Socio persona, Long diasPrestamo) {

        if(Prestamo.limiteAlcanzado(persona))
            return null;

        Prestamo prestamo = new Prestamo(persona,diasPrestamo);
        prestamo.addMaterial(this);

        return prestamo;

    }

    @Override
    public String obtenerTipo() {
        return "Libro";
    }
}
