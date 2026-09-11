public class PasarPorValor {
    public static void main(String[] args) {
        // las clases Wrapper son inmutables, es decir siempre que cambia el valor se retorna
        // una nueva referecnia o instancia de obj
        Integer i = 10;
        test(i);
        System.out.println("valor i en main: " + i);

    }

    //static para invocar métodos sin necesidad de instanciar el obj
    public static void test(Integer i){
        System.out.println("valor de i desde test: " + i);
        i = 35;
        System.out.println("valor de i desde test: " + i);
    }
}
