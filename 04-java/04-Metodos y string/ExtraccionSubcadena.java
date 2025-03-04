import java.util.Scanner;

public class ExtraccionSubcadena {
    
    public static void main(String[] args) {
        Scanner userSubcadena = new Scanner(System.in);

        System.out.println("Ingrese una frase:");
        String frase = userSubcadena.nextLine();

        System.out.println("Ingrse el índice inicial:");
        int initialIndex = userSubcadena.nextInt();

        System.out.println("Ingrse el índice final:");
        int endIndex = userSubcadena.nextInt();

        if (initialIndex >= 0 && endIndex <= frase.length() && initialIndex < endIndex) {
            String subcadena = frase.substring(initialIndex, endIndex);
            System.out.println("La subcadena resultante es: " + subcadena);
        } else {
            System.out.println("Los índices ingresados no son válidos.");
        }
        
        userSubcadena.close();
    }
}
