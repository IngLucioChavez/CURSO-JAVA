package org.lucioChavez.appHerencia;

public class Profesor extends Persona {

    private String materia;

    public Profesor(){
        System.out.println("Generando constructor Profesor");
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public void saludar() {
        System.out.println("Profesor Saludando!");
    }

    @Override
    public String toString() {
        return "Profesor: " + super.toString() + materia;
    }
}
