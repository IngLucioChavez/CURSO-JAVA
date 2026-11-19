import modelo.Ciudad;
import modelo.Vuelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vuelo> vuelos = new ArrayList<>();

        vuelos.add(new Vuelo("AAL 933", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(5, 39), 62, Ciudad.NEW_YORK));
        vuelos.add(new Vuelo("LAT 755", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(4, 45), 47, Ciudad.SAO_PAULO));
        vuelos.add(new Vuelo("SKU 621", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 30), LocalTime.of(16, 0), 52, Ciudad.RIO_DE_JANEIRO));
        vuelos.add(new Vuelo("DAL 147", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(13, 22), 59, Ciudad.ATLANTA));
        vuelos.add(new Vuelo("AVA 241", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(14, 5), 25, Ciudad.BOGOTA));
        vuelos.add(new Vuelo("AMX 10", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(5, 20), 29, Ciudad.MEXICO_CITY));
        vuelos.add(new Vuelo("IBE 6833", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 30), LocalTime.of(8, 45), 55, Ciudad.LONDRES));
        vuelos.add(new Vuelo("LAT 2479", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(7, 41), 51, Ciudad.FRANKFURT));
        vuelos.add(new Vuelo("SKU 803", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 30), LocalTime.of(10, 35), 48, Ciudad.LIMA));
        vuelos.add(new Vuelo("LAT 533", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(9, 14), 59, Ciudad.LOS_ANGELES));
        vuelos.add(new Vuelo("LAT 1447", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(8, 33), 31, Ciudad.GUAYAQUIL));
        vuelos.add(new Vuelo("CMP 111", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(15, 15), 29, Ciudad.PANAMA_CITY));
        vuelos.add(new Vuelo("LAT 705", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 30), LocalTime.of(8, 14), 47, Ciudad.MADRID));
        vuelos.add(new Vuelo("AAL 957", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(22, 53), 60, Ciudad.MIAMI));
        vuelos.add(new Vuelo("ARG 5091", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(9, 57), 32, Ciudad.BUENOS_AIRES));
        vuelos.add(new Vuelo("LAT 1283", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 31), LocalTime.of(4, 0), 35, Ciudad.CANCUN));
        vuelos.add(new Vuelo("LAT 579", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(7, 45), 61, Ciudad.BARCELONA));
        vuelos.add(new Vuelo("AAL 945", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 30), LocalTime.of(7, 12), 58, Ciudad.DALLAS_FORT_WORTH));
        vuelos.add(new Vuelo("LAT 501", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 29), LocalTime.of(18, 29), 49, Ciudad.PARIS));
        vuelos.add(new Vuelo("LAT 405", Ciudad.SANTIAGO, LocalDate.of(2021, 8, 30), LocalTime.of(15, 45), 39, Ciudad.MONTEVIDEO));

        vuelos.sort(null); //- ordenando DEFAULT ASC
        System.out.println("====================listado de vuelo");
        vuelos.forEach(System.out::println);
        System.out.println("ultimo vuelo en llegar: \n%s".formatted(vuelos.getLast()));
        System.out.println("vuelo con menor número de pasajeros: \n%s".formatted(
                Collections.min(vuelos,(a,b) -> a.getNumeroPasajeros().compareTo(b.getNumeroPasajeros())))
        );

    }
}
