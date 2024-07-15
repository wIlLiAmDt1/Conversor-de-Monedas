package com.aluracursos.conversor.base;

import com.aluracursos.conversor.proceso.ConsultaApi;
import com.aluracursos.conversor.proceso.ConvertirValor;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        ConvertirValor conversor = new ConvertirValor();
        ArrayList<Valores> historial = new ArrayList();

        while (opcion != 14) {
            System.out.println("""
                    **************************************************
                    Sea bienvenido/a al Conversor de Monedas =] \n
                    1) Dolar =>> Peso argentino
                    2) Peso argentino =>> Dolar
                    3) Dolar =>> Real brasileño
                    4) Real brasileño =>> Dolar
                    5) Dolar =>> Peso colombiano
                    6) Peso colombiano =>> Dolar
                    7) Dolar =>> Euro
                    8) Euro =>> Dolar
                    9) Dolar =>> Franco suizo
                    10) Franco suizo =>> Dolar
                    11) Dolar =>> Yen japonés
                    12) Yen japonés =>> Dolar
                    13) Mostrar el historial de conversiones
                    14) Salir
                    Elija una opción válida: \n
                    **************************************************
                    """);
            opcion = lectura.nextInt();
            if (opcion < 13) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                int valor = lectura.nextInt();
                if (opcion == 1) {
                    double valorApi = consulta.obtenerMoneda("USD").conversion_rates().ARS;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "USD", "ARS"));
                } else if (opcion == 2) {
                    double valorApi = consulta.obtenerMoneda("ARS").conversion_rates().USD;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "ARS", "USD"));
                } else if (opcion == 3) {
                    double valorApi = consulta.obtenerMoneda("USD").conversion_rates().BRL;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "USD", "BRL"));
                } else if (opcion == 4) {
                    double valorApi = consulta.obtenerMoneda("BRL").conversion_rates().USD;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "BRL", "USD"));
                } else if (opcion == 5) {
                    double valorApi = consulta.obtenerMoneda("USD").conversion_rates().COP;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "USD", "COP"));
                } else if (opcion == 6) {
                    double valorApi = consulta.obtenerMoneda("COP").conversion_rates().EUR;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "COP", "USD"));
                } else if (opcion == 7) {
                    double valorApi = consulta.obtenerMoneda("USD").conversion_rates().EUR;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "USD", "EUR"));
                } else if (opcion == 8) {
                    double valorApi = consulta.obtenerMoneda("EUR").conversion_rates().USD;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "EUR", "USD"));
                } else if (opcion == 9) {
                    double valorApi = consulta.obtenerMoneda("USD").conversion_rates().CHF;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "USD", "CHF"));
                } else if (opcion == 10) {
                    double valorApi = consulta.obtenerMoneda("CHF").conversion_rates().USD;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "CHF", "USD"));
                } else if (opcion == 11) {
                    double valorApi = consulta.obtenerMoneda("USD").conversion_rates().JPY;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "USD", "JPY"));
                } else {
                    double valorApi = consulta.obtenerMoneda("JPY").conversion_rates().USD;
                    historial.add(conversor.obtenerValorConvertido(valorApi, valor, "JPY", "USD"));
                }
            } else if (opcion == 13) {
                System.out.println(historial);
            }
        }
    }
}
