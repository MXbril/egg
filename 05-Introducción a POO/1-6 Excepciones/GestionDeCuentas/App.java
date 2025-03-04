import java.util.Scanner;

import com.max.modelos.CantidadNegativaException;
import com.max.modelos.CuentaBancaria;
import com.max.modelos.SaldoInsuficienteException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria(500.0);

        try {
            System.out.println("Saldo inicial: " + cuenta.getSaldo() + " unidades.");
            System.out.print("Ingrese la cantidad que desea retirar: ");
            double cantidad = sc.nextDouble();
            cuenta.retirar(cantidad);
        } catch (CantidadNegativaException e) {
            System.out.println("Error: " +e.getMessage());
        } catch (SaldoInsuficienteException e) {
           System.out.println("Error: " +e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado: " +e.getMessage());
        } finally {
            sc.close();
            System.out.println("Transacción finalizada.");
        }
    }
}