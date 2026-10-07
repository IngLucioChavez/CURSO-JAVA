import Mamiferos.*;

class Main{

    public static void main(String[] args) {

        Lobo lobo = new Lobo();
        lobo.setNombrePropio("laila");
        lobo.setFormaComunicarse("aullido");
        lobo.setNumeroCamada(1);
        System.out.println(lobo.comer());
        System.out.println(lobo.correr());

        Perro perro = new Perro();
        perro.setNombrePropio("Dodi");
        perro.setColor("blanco");
        perro.setFormaComunicarse("ladrido");
        System.out.println(perro.comer());
        System.out.println(perro.comunicarse());

        Leon leon = new Leon();
        leon.setNombrePropio("Mufasa");
        leon.setFormaComunicarse("Rugido");
        leon.setPeso(100.34f);
        System.out.println(leon.comunicarse());
        System.out.println(leon.dormir());

        Tigre tigre = new Tigre();
        tigre.setNombrePropio("Shircan");
        tigre.setPeso(300.5f);
        tigre.setFormaComunicarse("Rugido");
        System.out.println(tigre.comunicarse());
        System.out.println(tigre.correr());

        Guepardo guepardo = new Guepardo();
        guepardo.setNombrePropio("Moungli");
        guepardo.setFormaComunicarse("Rugido");
        guepardo.setHabitat("Sabana");
        System.out.println(guepardo.comunicarse());
        System.out.println(guepardo.dormir());

        System.out.println(lobo);
        System.out.println(perro);
        System.out.println(leon);
        System.out.println(tigre);
        System.out.println(guepardo);


    }

}