public class UnionDeDosArreglos {
    public static void main(String[] args) {

        int[] a = new int[12];
        int[] b = new int[12];
        int[] c = new int[24];

        //lenar arreglos
        for(int i=0; i<a.length; i++){
            a[i] = i+1;
        }
        for(int i=0; i<b.length; i++){
            b[i] = (i+1)*5;
        }
        //copiando de 3 en 3 de a y b al arreglo c
        for(int i=0,aux=0; i < a.length; i += 3 ){
            c[aux++] = a[i];
            c[aux++] = a[i+1];
            c[aux++] = a[i+2];
            c[aux++] = b[i];
            c[aux++] = b[i+1];
            c[aux++] = b[i+2];
        }

        int i = 0;
        for(int e: c){
            System.out.println("e[" + i++ + "] = " + e);
        }


    }
}
