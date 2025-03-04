public class ConcatenandoElementos {
    public static void main(String[] args) {
        String[] elementArray = {"Hola", "mundo", "esto", "es", "Java."};

        // String concatenado = "";
        // for (int i = 0; i < elementArray.length; i++) {
        //     concatenado += elementArray[i];
        //     if (i < elementArray.length - 1) {
        //         concatenado += " ";
        //     }
        // }
        String resultado = String.join(" ", elementArray);
        System.out.println("Cadena concatenada: " +resultado);
    }
}
