import java.util.Scanner;

public class ConcatenandoCadenas {
    
    public static void main(String[] args) {
        Scanner concatUser = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String name = concatUser.nextLine();

        System.out.println("Ingrese su apellido: ");
        String lastName = concatUser.nextLine();

        String fullName = name.concat(" ").concat(lastName);
        System.out.println("El nombre completo es: " + fullName);

        concatUser.close();
    }
}
