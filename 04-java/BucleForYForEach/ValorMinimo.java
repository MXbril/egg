public class ValorMinimo {
    public static void main(String[] args) {
        int[] num1 = {2,6,1,9,4,7,3};
         int valorMin = num1[0];

         for (int i = 1; i < num1.length; i++) {
            if (num1[i] < valorMin) {
                valorMin = num1[i];
            }
         }
         System.out.println("El valor mínimo en el array es: " +valorMin);
    }
}
