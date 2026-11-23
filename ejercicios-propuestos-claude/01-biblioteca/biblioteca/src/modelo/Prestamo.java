package modelo;

import excepciones.*;
import modelo.interfaces.Copiable;
import modelo.interfaces.Prestable;
import modelo.materiales.Material;
import modelo.personas.Socio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Prestamo extends BaseEntity implements Copiable<Prestamo> {

    private List<Material> materiales;
    private Socio socio;
    private LocalDate fechaInicialPrestamo;
    private LocalDate fechaFinalPrestamo;
    private LocalDate fechaDevolucion;
    private Long diasPrestamo;
    private int renovaciones;

    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static int ultimoId;
    private static final int LIMITE_RENOVACIONES = 3;
    public static final long MAX_DIAS_PRESTAMO = 30;
    public static final long MAX_DIAS_EXTENSION = 3;

    public Prestamo(Socio socio, LocalDate fechaFinalPrestamo) throws ArgumentoException{

        if(fechaFinalPrestamo == null)
            throw new ArgumentoException("ERROR - la fecha en que se debe regresar el material es vacía");
        if(socio == null)
            throw new ArgumentoException("ERROR - la referencia a socio no debe estar vacía");

        long dias = ChronoUnit.DAYS.between(LocalDate.now(),fechaFinalPrestamo);
        validarDiasPrestamo(dias);

        super(++ultimoId);
        this.fechaInicialPrestamo = LocalDate.now();
        this.diasPrestamo = dias;
        this.socio = socio;
        this.fechaFinalPrestamo = fechaFinalPrestamo;
        this.materiales = new ArrayList<>();
    }

    public Prestamo(Socio socio, Long diasPrestamo) throws ArgumentoException{

        if(socio == null)
            throw new ArgumentoException("ERROR - la referencia a socio no debe estar vacía");

        validarDiasPrestamo(diasPrestamo);

        super(++ultimoId);
        this.socio = socio;
        this.fechaInicialPrestamo = LocalDate.now();
        this.fechaFinalPrestamo = fechaInicialPrestamo.plusDays(diasPrestamo);
        this.diasPrestamo = diasPrestamo;
        this.materiales = new ArrayList<>();
    }

    protected Prestamo(Prestamo otro){
        super(otro.getId());
        this.fechaFinalPrestamo = otro.fechaFinalPrestamo;
        this.fechaInicialPrestamo = otro.fechaInicialPrestamo;
        this.diasPrestamo = otro.diasPrestamo;
        this.socio = otro.socio.copiar();
        this.fechaDevolucion = otro.fechaDevolucion;
        this.renovaciones = otro.renovaciones;
        this.materiales = new ArrayList<>();

        for(Material m:otro.materiales){
            materiales.add(m.copiar());
        }
    }

    public Socio getSocio() {
        return socio.copiar();
    }

    public void addMaterial(Material material)
            throws ArgumentoException, MaterialException, LimitePrestamosException, PrestamoException{

        if( material == null)
            throw new ArgumentoException("ERROR - referencia a material nula");
        if( fechaDevolucion != null )
            throw new PrestamoException("ERROR - el préstamo ya tiene fecha de devolución asignada");
        if( materiales.contains(material))
            throw new MaterialException("ERROR - ya está en la lista de materiales");
        if(limiteAlcanzado())
            throw new LimitePrestamosException(socio);
        if( !(material instanceof Prestable) )
            throw new MaterialException("ERROR - el material referenciado no es prestable");

        materiales.add(material.copiar());

    }

    public List<Material> getMateriales() {

        List<Material> materialesCopia = new ArrayList<>();

        for(Material m:materiales){
            materialesCopia.add(m.copiar());
        }

        return materialesCopia;
    }

    public boolean limiteAlcanzado(){
        return materiales.size() >= socio.getLimitePrestamos();
    }

    public void extender(Long dias) throws PrestamoException, ArgumentoException{

        if(fechaDevolucion != null || renovaciones >= LIMITE_RENOVACIONES)
            throw new PrestamoException("ERROR - el préstamo ya tiene fecha de devolución o se ha alcanzado el número de renovaciones permitidas");
        if( dias == null || dias <= 0 || dias > MAX_DIAS_EXTENSION)
            throw new ArgumentoException("ERROR - los días indicados no son validos o el valor es mayor a los días de extensión permitidos");
        if( LocalDate.now().isAfter(fechaFinalPrestamo) )
            throw new PrestamoException("ERROR - la fecha actual es superior a la fecha del préstamo");

        fechaFinalPrestamo = fechaFinalPrestamo.plusDays(dias);
        diasPrestamo += dias;
        renovaciones++;

    }

    public void devolver(List<Material> materialesDevueltos)
            throws PrestamoException, ArgumentoException, DevolucionIncompletaException{

        if( fechaDevolucion != null )
            throw new PrestamoException("ERROR - el préstamo ya tiene fecha de devolución asignada");
        if( materialesDevueltos == null)
            throw new ArgumentoException("ERROR - los materiales a devolver son nulos");
        if( materiales.isEmpty() )
            throw new PrestamoException("ERROR - el préstamo no tiene materiales registrados para devolver");

        //mismos materiales, sin importar el orden
        boolean mismosMateriales = materialesDevueltos.size() == materiales.size() &&
                new HashSet<>(materialesDevueltos).equals(new HashSet<>(materiales));

        if( !mismosMateriales )
            throw new DevolucionIncompletaException(this);

        fechaDevolucion = LocalDate.now();

    }

    public boolean estaVencido(){
        return fechaDevolucion == null && fechaFinalPrestamo.isBefore(LocalDate.now());
    }

    private static void validarDiasPrestamo(Long diasPrestamo) throws DiasPrestamoException{
        if( diasPrestamo == null || diasPrestamo < 1 || diasPrestamo > MAX_DIAS_PRESTAMO )
            throw new DiasPrestamoException(diasPrestamo);
    }

    public void actualizarDesde(Prestamo otro){
        this.fechaFinalPrestamo = otro.fechaFinalPrestamo;
        this.fechaDevolucion = otro.fechaDevolucion;
        this.renovaciones = otro.renovaciones;
        this.diasPrestamo = otro.diasPrestamo;

        this.materiales = new ArrayList<>();
        for(Material m: otro.materiales){
            materiales.add(m.copiar());
        }
    }

    public LocalDate getFechaInicialPrestamo() {
        return fechaInicialPrestamo;
    }

    public LocalDate getFechaFinalPrestamo() {
        return fechaFinalPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Long getDiasPrestamo() {
        return diasPrestamo;
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

    @Override
    public Prestamo copiar() {
        return new Prestamo(this);
    }
}
