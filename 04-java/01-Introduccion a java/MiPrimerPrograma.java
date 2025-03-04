import java.util.Scanner;

public class MiPrimerPrograma {
    public static void main(String[] args) {
        Scanner areaPerimetro = new Scanner(System.in);

        // Pedir al usuario que ingrese el valor de la base del rectángulo
        System.out.print("Por favor, ingresa el valor de la base del rectángulo: ");
        double baseRectangulo = areaPerimetro.nextDouble();

        // Pedir al usuario que ingrese el valor de la altura del rectángulo
        System.out.print("Por favor, ingresa el valor de la altura del rectángulo: ");
        double alturaRectangulo = areaPerimetro.nextDouble();

        // Calcular el perímetro del rectángulo
        double perimetro = 2 * baseRectangulo + 2 * alturaRectangulo;

        // Mostrar el resultado del perímetro por consola
        System.out.println("El perímetro del rectángulo es: " + perimetro);

        // Calcular el área del rectángulo
        double area = baseRectangulo * alturaRectangulo;

        // Mostrar el resultado del área por consola
        System.out.println("El área del rectángulo es: " + area);

        // Cerrar el objeto Scanner
        areaPerimetro.close();

// Verificación de Edad
        // Scanner fecha = new Scanner(System.in);

        // System.out.print("Por favor, ingrese su año de nacimiento: ");
        // int añoNacimiento = fecha.nextInt();

        // final int ANIOACTUAL = 2024;
        // int calculoEdad = ANIOACTUAL - añoNacimiento;

        // if (calculoEdad >= 18) {
        //     System.out.println("Eres mayor de edad. Tienes " +calculoEdad+ " años.");
        // } else {
        //     System.out.println("Eres menor de edad. Tienes " +calculoEdad+ " años.");
        // }
        
        // fecha.close();

//Usando los operadores de comparación
        // Scanner condiciones = new Scanner(System.in);
        // System.out.print("Por favor ingresar el primer número: ");
        // int numero1 = condiciones.nextInt();
        // System.out.print("Por favor ingresar el segundo número: ");
        // int numero2 = condiciones.nextInt();

        // String mayor = (numero1 > numero2) ? "es mayor" : "no es mayor";
        // System.out.println("El primer número " +mayor+ " que el segundo número");

        // String distinto = (numero1 != numero2) ? "diferente" : "igual";
        // System.out.println("El primer número es " +distinto+ " al segundo número");

        // String divisible = (numero1 % 2 == 0) ? "divisible" : "no divisible";
        // System.out.println("El primer número es " + divisible + " por 2.");
        
        // System.out.print("Por favor ingresar el tercer número: ");
        // int numero3 = condiciones.nextInt();
        // System.out.print("Por favor ingresar el cuarto número: ");
        // int numero4 = condiciones.nextInt();

        // String mayor1 = (numero1 > numero2) ? "es mayor" : "no es mayor";
        // String mayor2 = (numero3 > numero4) ? "es mayor" : "no es mayor";
        // System.out.println("El primer número " +mayor1+ " que el segundo número y el tercer número " +mayor2+ " que el cuarto número");

        // String mayor3 = ((numero1 > numero2) || (numero3 > numero4)) ? "es mayor" : "no es mayor";
        // System.out.println("El primer número " +mayor3+ " que el segundo número y el tercer número " +mayor3+ " que el cuarto número");

        // condiciones.close();

// Actividad introdusir primer y segundo numero.
        // int num1 = 11;
        // int num2 = 7;

        // int suma = num1 + num2;
        // int resta = num1 - num2;
        // int multiplicacion = num1 * num2;
        // int division = num1 / num2;
        // int modulo = num1 % num2;

        // System.out.println("La suma de "+num1+" y " +num2+ " es de: "+suma);
        // System.out.println("La resta de "+num1+" y " +num2+ " es de: "+resta);
        // System.out.println("La multiplicación de "+num1+" y " +num2+ " es de: "+multiplicacion);
        // System.out.println("La división de "+num1+" y " +num2+ " es de: "+division);
        // System.out.println("El modulo de "+num1+" y " +num2+ " es de: "+modulo);

        // Scanner user = new Scanner(System.in);
        // System.out.print("Por favor ingrese el primer número: ");
        // int numero1 = user.nextInt();
        // System.out.print("Por favor ingrese el segundo número: ");
        // int numero2 = user.nextInt();

        // int sumarTodo = numero1 + numero2;
        // System.out.println("La suma ingresada por el usuario es: "+sumarTodo);


// Actividad ingrese el nombre y edad.
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Por favor ingrese un nombre: ");
        // String nombre = scanner.nextLine();
        // int edad;
        // System.out.print("Por favor ingrese su edad: ");
        // edad = scanner.nextInt();
        // System.out.println("Su nombre es "+nombre+" y su edad es "+edad);

// introduccion a Java
        // String nombre = "Max";
        // int edad = 25;
        // boolean esEstudiante = true;
        // char apellidoInicial = 'C';
        // long numeroGrande = 987654321L;
        // float altura = 1.70f;

        // String mensajeBienvenida = "Bienvenido a Java";
        // double temperaturaActual = 19;
        // boolean  datoLogico = true;

        // System.out.println("Hola Mundo!");
        // System.out.println("Bienvenido a tu curso de Java");
        // System.out.println("Mi nombre es " + nombre);
        // System.out.println("Mi edad es " + edad);

        // System.out.println("Variable boolean: " + esEstudiante);
        // System.out.println("Variable string: " + nombre);
        // System.out.println("Variable char: " + apellidoInicial);

        // System.out.println("Mi nombre es " + nombre + ", y tengo " + edad + " años");

        // System.out.println("Este curso te dice " + mensajeBienvenida +". Este dato es usado para diferentes caracteres");
        // System.out.println("Esta varible sirve para medir la temperatura que es de " + temperaturaActual);
        // System.out.println("Este valor sirve para representar entre verdadero y falso es un dato logico " + datoLogico);
    }
}

// 1.La temperatura media de una ciudad durante el verano (en grados Celsius).
//(double) Este dato permite  decimal y un amplio numero de valores.

// 2.El precio de un producto en una tienda (en dólares y centavos).
//(double) Este dato permite  decimal y un amplio numero de valores.

// 3.El nombre completo de una persona.
//(string) Este dato contiene valores alfabeticos.

// 4.La fecha de nacimiento de una persona.
//(LocalDate) Este dato puede representar fechas.

// 5.El número de habitantes de una ciudad.
//(long) Este dato puede almacenar una gran cantidad de valores numericos

// 6.La duración de una película (en minutos).
//(int) Este dato sirve para represdentar enteros.

// 7.Si un artículo está disponible o no en una tienda (true/false).
//(boolean) Este dato es espesificamente usado para representar verdadero y falso.

// 8.La distancia entre dos ciudades (en kilómetros).
//(double) Este dato puede representar los decimales y valores grandes.

// 9.El número de teléfono de una persona.
//(string) Este dato puede tener valores de caracteres especiales.

// 10.La cantidad de existencias de un producto en una tienda.
//(int) Este dato puede contener la cantidad de existencias de productos ya que estos no pueden ser decimales.