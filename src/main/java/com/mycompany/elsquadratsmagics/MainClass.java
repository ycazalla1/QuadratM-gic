/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.elsquadratsmagics;

import java.util.Scanner;

/**
 *
 * @author Bea i Yamila Hay que pedir al usuario los números y luego decir si es
 * una caja mágica o no
 */
public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = 0;
        String resposta, cadena, subCadena = "";
        final int DIMENSIONS_DEFECTE = 3;
        
        int[][] llistaNumeros = new int[DIMENSIONS_DEFECTE][DIMENSIONS_DEFECTE];

        System.out.print("Dimensions de la capsa per defecte: " + DIMENSIONS_DEFECTE
                + "X" + DIMENSIONS_DEFECTE + "\nVols modificar les dimensions"
                        + "per defecte (S/N): ");
        resposta = sc.nextLine();

        if (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
            System.out.println("ERROR. Resposta incorrecte.");
        } else if (resposta.equalsIgnoreCase("S")) {
            llistaNumeros = demanarDimensions();
        }
        
        for (int i = 0; i < llistaNumeros.length; i++) {
            System.out.println("--- Fila " + (i+1) + " ---");
            for (int j = 0; j < llistaNumeros[i].length; j++) {
                System.out.print("Columna " + (j+1) + " : ");
                num = sc.nextInt();
            }
        }

        QuadratMagic qm = new QuadratMagic();
        qm.esMagic(llistaNumeros);

    }

    public static int[][] demanarDimensions() {
        
        Scanner sc = new Scanner(System.in);

        int[][] llistaNumeros;
        int fila, columna;

        System.out.println("Introdueix les dimensions del quadrat:");

        System.out.print("\t- Files: ");
        fila = sc.nextInt();

        System.out.print("\t- Columnes: ");
        columna = sc.nextInt();

        llistaNumeros = new int[fila][columna];
        
        return llistaNumeros;

    }

}
