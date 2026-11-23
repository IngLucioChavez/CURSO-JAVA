package modelo.materiales;

import excepciones.ArgumentoException;
import excepciones.LimitePrestamosException;
import excepciones.MaterialException;
import excepciones.PrestamoException;
import modelo.interfaces.Imprimible;
import modelo.interfaces.Prestable;
import modelo.interfaces.Renovable;
import modelo.Prestamo;
import modelo.personas.Socio;

import java.time.LocalDate;

public class Libro extends Material implements Imprimible, Prestable, Renovable {

    private Integer paginas;

    public Libro(String titulo, Integer anio, Genero genero, Integer paginas) {
        super(titulo, anio, genero);
        this.paginas = paginas;
    }

    protected Libro(Libro otro){
        super(otro);
        this.paginas = otro.paginas;
    }

    @Override
    public void actualizarDesde(Material otro){
        super.actualizarDesde(otro);
        if( otro instanceof Libro libro )
            this.paginas = libro.paginas;
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
    public Prestamo prestar(Socio persona, LocalDate fechaFinalPrestamo) throws ArgumentoException, MaterialException, PrestamoException, LimitePrestamosException{

        Prestamo prestamo = new Prestamo(persona,fechaFinalPrestamo);
        prestamo.addMaterial(this);

        return prestamo;

    }

    @Override
    public Prestamo prestar(Socio persona, Long diasPrestamo) throws ArgumentoException, MaterialException, PrestamoException, LimitePrestamosException {

        Prestamo prestamo = new Prestamo(persona,diasPrestamo);
        prestamo.addMaterial(this);

        return prestamo;

    }

    @Override
    public String obtenerTipo() {
        return "Libro";
    }

    @Override
    public Material copiar() {
        return new Libro(this);
    }
}
