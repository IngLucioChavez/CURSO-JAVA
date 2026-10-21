package org.luciochavez.poointerfaces.imprenta.modelo;

public interface Imprimible {

    // esta forma es redundate para final static
    //final static String HOLA = "hola desde la constante estatica de la interfaz Imprimible";
    String HOLA = "hola desde la constante estatica de la interfaz Imprimible";

    String imprimir();
    /*
    * // si se deja de esta manera todas las clases que implementen
    * // está interfaz deberán implementar el metodo que se especifica
    * String imprimir_v2();
    *
    * // desde Java 8+ existen los métodos default que definen una definición
    * // por default para que las clases que implementen la interfaz no deban declarar el
    * // metodo forzosamente
    * // con @Override se puede sobreescribir el metodo y rediseñando la implementación
    * // por default
    * */
    default String imprimir_v2(){
        return "valor por defecto para imprimir v2";
    }

    /*
    * los metodos estaticos son pertenencientes a la interfaz/clase
    * que se puede ejecutar o llamar en cualquier momento referenciando la interfaz/clase
    * */
    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }



}
