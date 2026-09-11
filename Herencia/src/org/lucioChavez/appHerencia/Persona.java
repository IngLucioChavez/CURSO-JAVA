package org.lucioChavez.appHerencia;

public class Persona {

    private String nombre;
    private String apellidos;
    private String sexo;
    private String direccion;

    public Persona(){
        System.out.println("Generando constructor Persona");
    }
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellidos = apellido;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void saludar(){
        System.out.println("hola!");
    }

    @Override
    public String toString() {

        StringBuilder detallePersona = new StringBuilder();

        if( !(nombre == null || nombre.isEmpty()) )
            detallePersona.append(nombre).append(" ");
        if( !(apellidos == null || apellidos.isEmpty()) )
            detallePersona.append(apellidos).append(" ");
        if( !(sexo == null || sexo.isEmpty()) )
            detallePersona.append(sexo).append(" ");
        if( !(direccion == null || direccion.isEmpty()) )
            detallePersona.append(direccion).append(" ");

        return detallePersona.toString();
    }
}
