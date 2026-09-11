package org.lucioChavez.appFacturas;

/*import org.lucioChavez.appFacturas.modelo.Cliente;
import org.lucioChavez.appFacturas.modelo.Factura;
import org.lucioChavez.appFacturas.modelo.ItemFactura;
import org.lucioChavez.appFacturas.modelo.Producto;*/
import org.lucioChavez.appFacturas.modelo.*;

import java.util.Scanner;

public class AppFactura {
    public static void main(String[] args) {

        /*Cliente cliente = new Cliente();
        cliente.setNombre("Lucio Chavez");
        cliente.setRfc("CAGL931003");
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese Descripción Factura: ");
        String descripcionFactura = entrada.nextLine(); //obtiene texto con espacios en blanco
        Factura factura = new Factura(descripcionFactura,cliente);

        Producto producto;

        for(int i=0; i<1; i++){

            producto = new Producto();
            System.out.print("\nIngrese nombre para Producto No." + producto.getCodigo() + ": ");

            producto.setNombre(entrada.nextLine());
            System.out.print("Ingrese precio para Producto No." + producto.getCodigo() + ": ");

            producto.setPrecio(entrada.nextFloat());
            System.out.print("Ingrese cantidad para Producto No." + producto.getCodigo() + ": ");

            factura.addItemFactura(new ItemFactura(entrada.nextInt(),producto));

            entrada.nextLine(); // para evitar errores con nextLine()

        }

        System.out.println(factura);*/

        System.out.println("this.sumar(int...) = " + sumar(1,2,3,4,5,6,7,8,9,10));
        System.out.println("this.sumar(int...) = " + sumar(1.5f,2,3,4,5,6,7,8,9,10));

    }
    // todos los valores pasados deben ser enteros
    public static int sumar(int... params){

        int suma = 0;
        for(int num: params){
            suma += num;
        }
        return suma;

    }

    public static float sumar(float n, int... params){

        float suma = n;
        for(int num: params){
            suma += num;
        }
        return suma;

    }

}
