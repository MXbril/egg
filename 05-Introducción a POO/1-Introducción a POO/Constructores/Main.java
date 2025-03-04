public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Toyota", "Corola", 2020);
        auto1.imprimirDatos();
        Auto auto2 = new Auto("Honda", "Civic");
        auto2.imprimirDatos();
        Auto auto3 = new Auto("Ford");
        auto3.imprimirDatos();
        Auto auto4 = new Auto();
        auto4.imprimirDatos();
    }
}
