public class CalculandoPromedio {
    public static void main(String[] args) {
        float[] numArray = new float[20];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = i + 1.5f;
        }

        float sum = 0;
        for (float numero : numArray) {
            sum += numero;
        }

        float promedio = sum / numArray.length;
        System.out.println("Suma de los elementos del array: " + sum);
        System.out.println("Promedio de los elementos del array. " +promedio);
    }
}
