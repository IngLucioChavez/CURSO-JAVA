package org.lucioChavez.appHerencia;

public class Alumno extends Persona {

    private String grupo;
    private String matricula;

    public Alumno(){
        System.out.println("Generando constructor Alumno");
    }
    public Alumno(String nombre, String apellidos){
        super(nombre,apellidos);
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void saludar() {
        System.out.println("Alumno saludando");
    }

    @Override
    public String toString() {
        return "Alumno: " + super.toString() + grupo + " " + matricula;
    }
}
