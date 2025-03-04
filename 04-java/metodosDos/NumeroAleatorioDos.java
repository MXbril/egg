public class NumeroAleatorioDos {
    public static void main(String[] args) {
        int numero = numeroAleatorio();
        System.out.println("El número aleatorio generado es: " +numero);
    }

    public static int numeroAleatorio() {
        return (int) Math.floor(Math.random() * 355) +1;
    }
}
