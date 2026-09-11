package ejemploAutos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrdenarObjetos {
    public static void main(String[] args) {

        AutoBuilder auto1 = new AutoBuilder.Builder()
                .color(Color.AZUL)
                .marca("MAZDA")
                .tipo(TipoAuto.FURGON)
                .motor(new Motor(10d,TipoMotor.BENCINA))
                .propietario(new Persona("Lucio","Chavez"))
                .rueda(new Rueda(10d,10,"MICHELIN"))
                .rueda(new Rueda(10d,10,"MICHELIN"))
                .rueda(new Rueda(10d,10,"MICHELIN"))
                .rueda(new Rueda(10d,10,"MICHELIN"))
                .rueda(new Rueda(10d,10,"MICHELIN"))
                //rueda() contiene validación para admitir hasta 5 llantas
                .rueda(new Rueda(10d,10,"MICHELIN"))
                .estanque(new Estanque(400))
                .build();

        Rueda[] ruedas = new Rueda[10];
        for(int i=0; i<ruedas.length; i++){
            ruedas[i] = new Rueda(10D,10,"CONTITECH");
        }
        AutoBuilder auto2 = new AutoBuilder.Builder()
                .color(Color.NEGRO)
                .marca("TOTOYA")
                .tipo(TipoAuto.CONVERTIBLE)
                .motor(new Motor(10d,TipoMotor.BENCINA))
                .propietario(new Persona("Juan","Dudu"))
                .ruedas(ruedas) //arreglo de ruedas que se mande
                .build();

        AutoBuilder auto3 = new AutoBuilder.Builder()
                .color(Color.ROJO)
                .marca("Ferrari")
                .tipo(TipoAuto.COUPE)
                .build();

        //System.out.println("auto1 = " + auto1);
        //System.out.println("\nauto2 = " + auto2);
        //System.out.println("\nauto3 = " + auto3);

        AutoBuilder[] autos = new AutoBuilder[3];
        autos[0] = auto1;
        autos[1] = auto2;
        autos[2] = auto3;

        Arrays.sort(autos); //forma asc
        Arrays.sort(autos, Collections.reverseOrder()); //forma desc

        for (AutoBuilder auto : autos) {
            System.out.println("autos[i] = " + auto);
        }

    }
}
