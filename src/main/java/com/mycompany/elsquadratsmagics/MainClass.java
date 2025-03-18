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
        boolean triarDimensions = false;
        final int DIMENSIONS_DEFECTE = 3;

        int[][] llistaNumeros = new int[DIMENSIONS_DEFECTE][DIMENSIONS_DEFECTE];

        System.out.print("Dimensions de la capsa per defecte: " + DIMENSIONS_DEFECTE
                    + "X" + DIMENSIONS_DEFECTE + "\nVols modificar les dimensions"
                    + "per defecte (S/N): ");
        do {
            resposta = sc.nextLine();

            if (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
                System.err.print("ERROR. Resposta incorrecte."
                        + "\nTorna a ficar una resposta (S/N): ");
            } else if (resposta.equalsIgnoreCase("S")) {
                llistaNumeros = demanarDimensions();
                triarDimensions = true;
            }

        } while (!triarDimensions);

        omplirMatriu(llistaNumeros);

        QuadratMagic qm = new QuadratMagic();
        boolean magic = qm.esMagic(llistaNumeros);

        if (magic) {
            System.out.println("És un quadrat màgic.");
        } else {
            System.out.println("No és un quadrat màgic.");
        }

    }

    public static int[][] demanarDimensions() {

        int dimensions = 0;
        int[][] llistaNumeros;
        boolean dmsCorrecte = false;

        System.out.print("Introdueix les dimensions del quadrat: ");
        do {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                dimensions = sc.nextInt();
                if (dimensions <= 0) {
                    System.err.print("ERROR. No és un nombre positiu."
                        + "\nTorna'l a introduïr: ");
                } else {
                    dmsCorrecte = true;
                }
            } else {
                System.err.print("ERROR. No és un nombre enter."
                        + "\nTorna'l a introduïr: ");
            }
        } while (!dmsCorrecte);

        llistaNumeros = new int[dimensions][dimensions];

        return llistaNumeros;

    }
    
    public static void omplirMatriu(int[][] matriu) {
        
        int num;
        boolean numCorrecte = false;
        
        for (int i = 0; i < matriu.length; i++) {
            System.out.println("--- Fila " + (i + 1) + " ---");
            for (int j = 0; j < matriu[i].length; j++) {
                do {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Columna " + (j + 1) + " : ");
                    if (sc.hasNextInt()) {
                        num = sc.nextInt();
                        if (num <= 0) {
                            System.err.println("ERROR. No és un nombre positiu.");
                        } else {
                            numCorrecte = true;
                        }
                    } else {
                        System.err.println("ERROR. No és un nombre enter.");
                    }
                } while (!numCorrecte);
                
                
            }
        }
    }

}
