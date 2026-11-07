package modelo.personas;

import java.util.ArrayList;
import java.util.List;

abstract class Persona {

    private String nombres;
    private String ap;
    private String am;
    private Integer edad;
    private List<String> numerosTelefonicos;
    private List<String> direcciones;

    public Persona(String nombres, String ap, String am, Integer edad) {
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

}
