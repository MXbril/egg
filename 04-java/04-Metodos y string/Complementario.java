import java.util.Scanner;

public class Complementario {
    
    public static void main(String[] args) {
        EliminadoEspacios();
    }

    public static void CharacterReplacement() {
        Scanner userReplacement = new Scanner(System.in);

        System.out.println("Ingrese una frase:");
        String frase = userReplacement.nextLine();

        System.out.println("Ingrese el primer carácter:");
        char firstCharacter = userReplacement.next().charAt(0);
        
        System.out.println("Ingrese el segundo carácter:");
        char secondCharacter = userReplacement.next().charAt(0);

        String modifyPhrase = frase.replace(firstCharacter, secondCharacter);
        System.out.println("La frase resultante es: " + modifyPhrase);

        userReplacement.close();
    }

    public static void EliminadoEspacios() {
        Scanner userSpace = new Scanner(System.in);

        System.out.println("Ingrese una frase con espacios en blanco al principio y al final:");
        String otraFrase = userSpace.nextLine();

        String fraseEspacios = otraFrase.trim();

        System.out.println("La frase resultante es: \"" + fraseEspacios + "\"");

        userSpace.close();
    }
}
