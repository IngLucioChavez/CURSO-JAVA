public class WrapperBoolean {
    public static void main(String[] args) {

        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        Boolean uno = true;
        Boolean dos = true;

        System.out.println(uno == dos); //con Boolean no se compara por instancia sino x valor

        boolean primitivo = uno.booleanValue(); //de obj Wrapper a primitivo

    }
}
