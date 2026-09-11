package ejemploAutos;

public class AutoConObjetos {
    public static void main(String[] args) {

        Auto auto1 = new Auto(Color.NEGRO,"Mazda",TipoAuto.HATCHBACK);
        Auto auto2 = new Auto(Color.AZUL,"TOTOYA",TipoAuto.FURGON);
        Persona persona = new Persona("Lucio","Chavez");
        Motor motor = new Motor(2.0,TipoMotor.BENCINA);
        Estanque estanque = new Estanque(10);

        auto1.addRueda(new Rueda(100,100,"continental"))
            .addRueda(new Rueda(100,100,"continental"))
            .addRueda(new Rueda(100,100,"continental"))
            .addRueda(new Rueda(100,100,"continental"));

        auto1.setMotor(motor);
        auto1.setEstanque(estanque);
        auto1.setPropietario(persona);

        persona = new Persona("Lupita","Garcia");
        motor = new Motor(15d,TipoMotor.DIESEL);
        estanque = new Estanque(50);

        for(int i = 0; i < Auto.LIMITE_RUEDAS; i++){
            auto2.addRueda(new Rueda(5.2,10,"MICHELIN"));
        }

        auto2.setMotor(motor);
        auto2.setEstanque(estanque);
        auto2.setPropietario(persona);

        System.out.println("auto1 = " + auto1);
        System.out.println("auto2 = " + auto2);

        System.out.println("\nRuedas auto1");
        for(Rueda rueda: auto1.getRuedas()){
            System.out.println(rueda);
        }
        System.out.println("Ruedas auto2");
        for(Rueda rueda: auto2.getRuedas()){
            System.out.println(rueda);
        }

    }
}
