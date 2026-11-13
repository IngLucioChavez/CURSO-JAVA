package modelo;

import modelo.materiales.Material;
import modelo.personas.Socio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Prestamo extends BaseEntity {

    private List<Material> materiales;
    private Socio socio;
    private LocalDate fechaInicialPrestamo;
    private LocalDate fechaFinalPrestamo;
    private LocalDate fechaDevolucion;
    private Long diasPrestamo;
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static int ultimoId;
    private int renovaciones;
    private static final int LIMITE_RENOVACIONES = 3;
    public static final long MAX_DIAS_PRESTAMO = 30;
    public static final long MAX_DIAS_EXTENSION = 3;

    public Prestamo(Socio socio, LocalDate fechaFinalPrestamo){

        if(fechaFinalPrestamo == null)
            throw new IllegalArgumentException("ERROR - la fecha en que se debe regresar el material es vacía");
        if(socio == null)
            throw new IllegalArgumentException("ERROR - la referencia a socio no debe estar vacía");

        long dias = ChronoUnit.DAYS.between(LocalDate.now(),fechaFinalPrestamo);
        validarDiasPrestamo(dias);

        super(++ultimoId);
        this.fechaInicialPrestamo = LocalDate.now();
        this.diasPrestamo = dias;
        this.socio = socio;
        this.fechaFinalPrestamo = fechaFinalPrestamo;
        this.materiales = new ArrayList<>();
    }

    public Prestamo(Socio socio, Long diasPrestamo){

        if(socio == null)
            throw new IllegalArgumentException("ERROR - la referencia a socio no debe estar vacía");

        validarDiasPrestamo(diasPrestamo);

        super(++ultimoId);
        this.socio = socio;
        this.fechaInicialPrestamo = LocalDate.now();
        this.fechaFinalPrestamo = fechaInicialPrestamo.plusDays(diasPrestamo);
        this.diasPrestamo = diasPrestamo;
        this.materiales = new ArrayList<>();
    }

    public Socio getSocio() {
        return socio;
    }

    public boolean addMaterial(Material material){

        if(material == null || fechaDevolucion != null || materiales.contains(material))
            return false;
        if(limiteAlcanzado(socio))
            return false;

        materiales.add(material);
        socio.addNumeroPrestamos();
        return true;

    }

    public List<Material> getMateriales() {
        return List.copyOf(materiales);
    }

    public static boolean limiteAlcanzado(Socio socio){
        return socio.getPrestamosRegistrados() >= socio.getLimitePrestamos();
    }

    public boolean extender(Long dias){

        if(fechaDevolucion != null || renovaciones >= LIMITE_RENOVACIONES)
            return false;
        if( dias == null || dias <= 0 || dias > MAX_DIAS_EXTENSION)
            return false;
        if( LocalDate.now().isAfter(fechaFinalPrestamo) )
            return false;

        fechaFinalPrestamo = fechaFinalPrestamo.plusDays(dias);
        diasPrestamo += dias;
        renovaciones++;
        return true;

    }

    public boolean devolver(List<Material> materialesDevueltos){

        if( fechaDevolucion != null || materialesDevueltos == null)
            return false;
        if( materiales.isEmpty() )
            return false;

        //mismos materiales, sin importar el orden
        boolean mismosMateriales = materialesDevueltos.size() == materiales.size() &&
                new HashSet<>(materialesDevueltos).equals(new HashSet<>(materiales));

        if( !mismosMateriales )
            return false;

        fechaDevolucion = LocalDate.now();
        socio.disNumeroPrestamos(materiales.size());

        return true;

    }

    public boolean estaVencido(){
        return fechaDevolucion == null && fechaFinalPrestamo.isBefore(LocalDate.now());
    }

    private static void validarDiasPrestamo(Long diasPrestamo){
        if( diasPrestamo == null || diasPrestamo < 1 || diasPrestamo > MAX_DIAS_PRESTAMO )
            throw new IllegalArgumentException("los días de prestamo deben estar entre 1 y " + MAX_DIAS_PRESTAMO);
    }

    @Override
    public String toString(){

        StringBuilder texto = new StringBuilder();
        texto.append(String.format("=== Prestamo (%s) ===\n\n",super.getId()));
        texto.append("=== DATOS SOCIO ===\n");
        texto.append(socio.toString()).append("\n");
        texto.append("=== DATOS PRESTAMO ===\n");
        texto.append(String.format("ESTATUS: %s\n",fechaDevolucion != null ? "DEVUELTO" : "PRESTADO"));
        texto.append(String.format("Fecha Registro Préstamo: %s\n",fechaInicialPrestamo.format(formato)));
        texto.append(String.format("Fecha Final de Préstamo: %s\n",fechaFinalPrestamo.format(formato)));
        texto.append(String.format("Días de Préstamo: %s\n",diasPrestamo));
        if( fechaDevolucion != null ){
            texto.append(String.format("Fecha de Devolución: %s\n",fechaDevolucion.format(formato)));
        }

        AtomicInteger item = new AtomicInteger(1);
        materiales.forEach(material->{
            texto.append(String.format("material %s: %s",item.getAndIncrement(),material));
        });

        return texto.toString();

    }

}
