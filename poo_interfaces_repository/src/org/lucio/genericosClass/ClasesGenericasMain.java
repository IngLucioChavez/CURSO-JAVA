package org.lucio.genericosClass;

public class ClasesGenericasMain {

    static void main() {

        Camion transporteCaballos = new Camion(5);
        transporteCaballos.addObjeto(new Animal("peregrino","caballo"));
        transporteCaballos.addObjeto(new Animal("veloz","caballo"));
        transporteCaballos.addObjeto(new Animal("trueno","caballo"));
        transporteCaballos.addObjeto(new Animal("laila","caballo"));
        transporteCaballos.addObjeto(new Animal("dodi","caballo"));

        for(Object a:transporteCaballos){
            Animal an = (Animal) a;
            System.out.println("Nombre Caballo: " + an.getNombre() + " Tipo: " + an.getTipo());
        }

        Camion transporteMAquinaria = new Camion(3);
        transporteMAquinaria.addObjeto(new Maquinaria("tractor"));
        transporteMAquinaria.addObjeto(new Maquinaria("grua"));
        transporteMAquinaria.addObjeto(new Maquinaria("perforadora"));

        for(Object m: transporteMAquinaria){
            Maquinaria ma = (Maquinaria) m;
            System.out.println("tipo maquinaria: " + ma.getTipo());
        }

        Camion transporteAutos = new Camion(3);
        transporteAutos.addObjeto(new Automovil("mazda"));
        transporteAutos.addObjeto(new Automovil("chevrolet"));
        transporteAutos.addObjeto(new Automovil("toyota"));

        for(Object a: transporteAutos){
            Automovil au = (Automovil) a;
            System.out.println("marca auto: " + au.getMarca());
        }

    }

}
