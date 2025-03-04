
public class SumarElementos {
    public static void main(String[] args) {
        int[] nums = {5, 10, 15};

        int suma = nums[0] + nums[1] + nums[2];
        // int suma = Arrays.stream(nums).sum();
        System.out.println("La suma de los elementos es: " +suma);
    }
}