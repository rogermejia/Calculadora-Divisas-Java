/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora.divisa;

import static calculadora.divisa.App.convertCurrency;
import java.util.Scanner;


/**
 *
 * @author ASUS
 */
public class CalculadoraDivisa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Conversor de Divisas");
        System.out.println("====================");

        // Obtener la moneda de origen
        System.out.print("Introduce la moneda de origen (por ejemplo, USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        // Obtener la moneda de destino
        System.out.print("Introduce la moneda de destino (por ejemplo, EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        // Obtener la cantidad a convertir
        System.out.print("Introduce la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        // Realizar la conversión
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);

        // Mostrar el resultado
        System.out.println("Cantidad convertida: " + convertedAmount + " " + toCurrency);

        scanner.close();
    }
        
    }
    

