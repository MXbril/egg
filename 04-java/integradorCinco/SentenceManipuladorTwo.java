import java.util.Arrays;
import java.util.Scanner;

public class SentenceManipuladorTwo {
    private static String sentence = "";

    public static void main(String[] args) {
        Scanner userSc = new Scanner(System.in);
        int option = -1;

        while (option != 9) {
            showMenu();
            try {
                option = Integer.parseInt(userSc.nextLine());

                switch (option) {
                    case 1:
                        if (sentence.isEmpty()) {
                            System.out.print("Ingrese la nueva oración: ");
                            sentence = userSc.nextLine();
                        } else {
                            sentence = "";
                            System.out.println("Oración borrada.");
                        }
                        break;
                    case 2:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            System.out.println("Cantidad de caracteres: " + sentence.length());
                        }
                        break;
                    case 3:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            String[] words = sentence.split("\\s+");
                            System.out.println("Cantidad de palabras: " + (sentence.isEmpty() ? 0 : words.length));
                        }
                        break;
                    case 4:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            String[] words = sentence.split("\\s+");
                            Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
                            System.out.println("Palabras ordenadas alfabéticamente: " + String.join(", ", words));
                        }
                        break;
                    case 5:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            System.out.print("Ingrese un número: ");
                            try {
                                int number = Integer.parseInt(userSc.nextLine());
                                String[] words = sentence.split("\\s+");
                                if (number < 1 || number > words.length) {
                                    System.out.println("Número inválido. Intente nuevamente.");
                                } else {
                                    System.out.println("Palabra en la posición " + number + ": " + words[number - 1]);
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                            }
                        }
                        break;
                    case 6:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            System.out.print("Ingrese una palabra para buscar: ");
                            String word = userSc.nextLine();
                            String[] words = sentence.split("\\s+");
                            boolean found = false;
                            for (int i = 0; i < words.length; i++) {
                                if (words[i].equalsIgnoreCase(word)) {
                                    System.out.println("Palabra encontrada en la posición " + (i + 1));
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Palabra no encontrada.");
                            }
                        }
                        break;
                    case 7:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            System.out.print("Ingrese la palabra que desea cambiar: ");
                            String oldWord = userSc.nextLine();
                            if (!sentence.contains(oldWord)) {
                                System.out.println("Palabra no encontrada. Intente nuevamente.");
                            } else {
                                System.out.print("Ingrese la nueva palabra: ");
                                String newWord = userSc.nextLine();
                                sentence = sentence.replaceFirst(oldWord, newWord);
                                System.out.println("Nueva oración: " + sentence);
                            }
                        }
                        break;
                    case 8:
                        if (sentence.isEmpty()) {
                            System.out.println("Primero debe crear una oración.");
                        } else {
                            System.out.print("Ingrese el contenido que desea agregar: ");
                            String content = userSc.nextLine();
                            sentence += " " + content;
                            System.out.println("Nueva oración: " + sentence);
                        }
                        break;
                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del menú.");
            }
        }

        userSc.close();
    }

    private static void showMenu() {
        System.out.println("\n--- Menú de opciones ---");
        System.out.println("1. " + (sentence.isEmpty() ? "Crear oración" : "Borrar oración"));
        System.out.println("2. Cantidad de caracteres de la oración");
        System.out.println("3. Cantidad de palabras de la oración");
        System.out.println("4. Mostrar palabras ordenadas alfabéticamente");
        System.out.println("5. Ingresar un número y devolver la palabra correspondiente");
        System.out.println("6. Buscar palabra dentro de la oración");
        System.out.println("7. Modificar palabra dentro de la oración");
        System.out.println("8. Agregar contenido a la oración");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
