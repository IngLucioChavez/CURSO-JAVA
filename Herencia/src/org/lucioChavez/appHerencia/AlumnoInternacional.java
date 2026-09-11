package org.lucioChavez.appHerencia;

public class AlumnoInternacional extends Alumno{

    private String pais;
    private int notaIngles;

    public AlumnoInternacional(){
        System.out.println("Generando constructor AlumnoInternacional");
    }

    public int getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(int notaIngles) {
        this.notaIngles = notaIngles;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void saludar() {
        System.out.println("Alumno internacional saludando");
    }
}
