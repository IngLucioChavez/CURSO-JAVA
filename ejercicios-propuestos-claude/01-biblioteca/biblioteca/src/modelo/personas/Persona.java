package modelo.personas;

import modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Persona extends BaseEntity {

    private String nombres;
    private String ap;
    private String am;
    private Integer edad;
    private List<String> numerosTelefonicos;
    private List<String> direcciones;
    private static int ultimoId;

    public Persona(String nombres, String ap, String am, Integer edad) {
        super(++ultimoId);
        this.nombres = nombres;
        this.ap = ap;
        this.am = am;
        this.edad = edad;
        this.numerosTelefonicos = new ArrayList<>();
        this.direcciones = new ArrayList<>();
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Persona addTelefono(String telefono){
        numerosTelefonicos.add(telefono);
        return this;
    }

    public Persona addDireccion(String direccion){
        direcciones.add(direccion);
        return this;
    }

    public List<String> getTelefonos(){
        return List.copyOf(numerosTelefonicos);
    }

    public List<String> getDirecciones(){
        return List.copyOf(direcciones);
    }

    @Override
    public String toString() {

        StringBuilder text = new StringBuilder();
        text.append(String.format("Persona(%s)\n",getId()));
        text.append(String.format("nombre(s): %s\n",nombres));
        text.append(String.format("ap: %s\n",ap));
        text.append(String.format("am: %s\n",am));
        text.append(String.format("edad: %s\n",edad));

        text.append("Números telefónicos: \n");
        AtomicInteger item = new AtomicInteger(1);
        numerosTelefonicos.forEach(num->{
            text.append(String.format("Número Telefónico %s: %s\n",item.getAndIncrement(),num));
        });


        text.append("Direcciones: \n");
        item.set(1);
        direcciones.forEach(dir->{
            text.append(String.format("Dirección %s: %s\n",item.getAndIncrement(),dir));
        });

        return text.toString();
    }
}
