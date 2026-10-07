import mamiferos.*;

class Main{

    public static void main(String[] args) {

        Lobo lobo = new Lobo.Builder()
                .nombrePropio("Laila")
                .formaComunicarse("aullido")
                .build();

        Perro perro = new Perro.Builder()
                .nombrePropio("Dodi")
                .formaComunicarse("ladrido")
                .build();

        Leon leon = new Leon.Builder()
                .nombrePropio("Mufasa")
                .formaComunicarse("rugido")
                .build();

        Tigre tigre = new Tigre.Builder()
                .nombrePropio("Shirkan")
                .formaComunicarse("rugido")
                .build();

        Guepardo guepardo = new Guepardo.Builder()
                .nombrePropio("baguira")
                .formaComunicarse("rugido")
                .build();

        System.out.println(String.format("%s \n%s",lobo,lobo.comunicarse()));
        System.out.println(String.format("%s \n%s",perro,perro.comunicarse()));
        System.out.println(String.format("%s \n%s",leon,leon.comunicarse()));
        System.out.println(String.format("%s \n%s",tigre,tigre.comunicarse()));
        System.out.println(String.format("%s \n%s",guepardo,guepardo.comunicarse()));

    }

}