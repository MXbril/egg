import java.util.Scanner;

public class BuscarElemento {
    public static void main(String[] args) {
        Scanner userBusca = new Scanner(System.in);

        int[] numero1 = {10, 15, 20};

        System.out.println("Ingrese el número que esta buscando:");
        int buscandoNumero = userBusca.nextInt();

        boolean encontrar = false;
        for (int numero : numero1) {
            if (numero == buscandoNumero) {
                encontrar = true;
                break;
            }
        }

        if (encontrar) {
            System.out.println("El número " +buscandoNumero+ " se encuentra en el array.");
        } else {
            System.out.println("El número " +buscandoNumero+ " no se encuentra en el array.");
        }

        userBusca.close();
    }
}
