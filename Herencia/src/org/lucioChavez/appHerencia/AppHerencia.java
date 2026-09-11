package org.lucioChavez.appHerencia;

public class AppHerencia {
    public static void main(String[] args) {

        System.out.println("------Alumno-------------------");
        Alumno alumno = new Alumno("Lucio","Chavez");
        alumno.setGrupo("A");
        alumno.setMatricula("123456");

        // declaración como clase padre
        // instanciación como clase hija
        System.out.println("------Profesor-------------------");
        Profesor profesor = new Profesor();
        profesor.setNombre("Alberto");
        profesor.setApellidos("Ramos");
        // cast a clase hija
        profesor.setMateria("Matemáticas");

        System.out.println("------AlumnoInternacional-------------------");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();
        alumnoInt.setNombre("Jennifer");
        alumnoInt.setApellidos("Wednesday");
        alumnoInt.setGrupo("W");
        alumnoInt.setPais("Boston");
        alumnoInt.setNotaIngles(10);

        System.out.println("-------IMPRESION-------");
        System.out.println(profesor);
        System.out.println(alumno);
        System.out.println("alumnoInt = " + alumnoInt + "\n");

        Class clase = alumnoInt.getClass();
        while(clase.getSuperclass() != null){
            String hijo = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println("hijo: " + hijo + ",\npadre: " + padre + "\n");
            clase = clase.getSuperclass();
        }

        saludar(alumno);
        saludar(profesor);
        saludar(alumnoInt);

    }

    public static void saludar(Persona persona){
        persona.saludar();
    }

}
