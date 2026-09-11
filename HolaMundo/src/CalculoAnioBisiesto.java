public class CalculoAnioBisiesto {
    public static void main(String[] args) {

        int anio = 2023;

        // si el año es divisible entre 400 es bisiesto
        // o
        // si el año es divisible entre 4 y el anio no es divisble entre 100 es bisiesto
        if( anio % 400 == 0 || ( (anio % 4 == 0) && (anio % 100 != 0) ) ){
            System.out.printf("bisiesto");
        } else {
            System.out.printf("no bisiesto");
        }

        int mes = 1;

        switch(anio){
            case 1: //Enero
            case 3: //Marzo
            case 5: //Mayo
            case 7: //Julio
            case 8: //Agosto
            case 10: //Octubre
            case 12: //Diciembre
                System.out.println("dias 31");
                break;
            case 4: //Abril
            case 6: //Junio
            case 9: //Septiembre
            case 11: //Noviembre
                System.out.println("dias 30");
                break;
            case 2: //Febrero
                System.out.println("puede ser 28 o 29");
                break;
            default:
                System.out.println("mes no conocido");
                break;
        }

    }
}
