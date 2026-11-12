package modelo;

import modelo.materiales.Material;
import modelo.personas.Socio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Prestamo extends BaseEntity{

    private List<Material> materiales;
    private Socio socio;
    private LocalDate fechaInicialPrestamo;
    private LocalDate fechaFinalPrestamo;
    private LocalDate fechaDevolucion;
    private Long diasPrestamo;
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static Integer ultimoId;

    public Prestamo(Socio socio, LocalDate fechaFinalPrestamo){
        super(++ultimoId);
        this.socio = socio;
        this.fechaInicialPrestamo = LocalDate.now();
        this.fechaFinalPrestamo = fechaFinalPrestamo;
        this.diasPrestamo = ChronoUnit.DAYS.between(fechaInicialPrestamo,fechaFinalPrestamo);
        this.materiales = new ArrayList<>();
    }

    public Prestamo(Socio socio, Long diasPrestamo){
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

    public Prestamo addMaterial(Material material){
        materiales.add(material);
        return this;
    }

    public List<Material> getMateriales() {
        return List.copyOf(materiales);
    }

    @Override
    public String toString(){

        StringBuilder texto = new StringBuilder();
        texto.append(String.format("=== Prestamo (%s) ===\n\n",super.getId()));
        texto.append("=== DATOS SOCIO ===\n");
        texto.append(socio.toString()).append("\n");
        texto.append("=== DATOS PRESTAMO ===\n");
        texto.append(String.format("ESTATUS: %s",fechaFinalPrestamo != null ? "DEVUELTO" : "PRESTADO"));
        texto.append(String.format("Fecha Registro Préstamo: %s\n",fechaInicialPrestamo));
        texto.append(String.format("Fecha Final de Préstamo: %s\n",fechaFinalPrestamo));
        texto.append(String.format("Días de Préstamo: %s\n",diasPrestamo));
        if( fechaFinalPrestamo != null ){
            texto.append(String.format("Fecha de Devolución: %s\n",fechaDevolucion));
        }

        AtomicInteger item = new AtomicInteger(1);
        materiales.forEach(material->{
            texto.append(String.format("material %s: %s",item.getAndIncrement(),material));
        });

        return texto.toString();

    }

}
