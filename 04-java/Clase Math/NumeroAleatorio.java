public class NumeroAleatorio {
    public static void main(String[] args) {
        double numAleatorio = Math.random();
        int numEscalado = (int) Math.floor(numAleatorio * 355) + 1;

        System.out.println("El número aleatorio es " + numEscalado);
    }
}

