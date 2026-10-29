package org.lucio.genericosClass;

public class ClasesGenericasMain {

    static void main() {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.addObjeto(new Animal("peregrino","caballo"));
        transporteCaballos.addObjeto(new Animal("veloz","caballo"));
        transporteCaballos.addObjeto(new Animal("trueno","caballo"));
        transporteCaballos.addObjeto(new Animal("laila","caballo"));
        transporteCaballos.addObjeto(new Animal("dodi","caballo"));

        verContenidoCamion(transporteCaballos);

        Camion<Maquinaria> transporteMAquinaria = new Camion<>(3);
        transporteMAquinaria.addObjeto(new Maquinaria("tractor"));
        transporteMAquinaria.addObjeto(new Maquinaria("grua"));
        transporteMAquinaria.addObjeto(new Maquinaria("perforadora"));

        verContenidoCamion(transporteMAquinaria);

        Camion<Automovil> transporteAutos = new Camion<>(3);
        transporteAutos.addObjeto(new Automovil("mazda"));
        transporteAutos.addObjeto(new Automovil("chevrolet"));
        transporteAutos.addObjeto(new Automovil("toyota"));

        verContenidoCamion(transporteAutos);

    }

    public static <T> void verContenidoCamion(Camion<T> camion){

        for(T a:camion){

            if(a instanceof Animal)
                System.out.println("Nombre Caballo: " + ((Animal)a).getNombre() + " Tipo: " + ((Animal)a).getTipo());
            if(a instanceof Maquinaria)
                System.out.println("tipo maquinaria: " + ((Maquinaria)a).getTipo());
            if(a instanceof Automovil)
                System.out.println("marca auto: " + ((Automovil)a).getMarca());

        }

    }

}
