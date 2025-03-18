/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.elsquadratsmagics;

import java.util.Scanner;

/**
 * Classe principal.
 * És on es demana a l'usuari per les dimensions del quadrat i el seu contingut.
 * @author Bea i Yamila
 */
public class MainClass {

    /**
     * Mètode main
     * @param args 
     */
    public static void main(String[] args) {

        // Declaració de l'escàner
        Scanner sc = new Scanner(System.in);

        // Declaració de variables
        String resposta;
        // Controla si l'usuari vol modificar les dimensions
        boolean triarDimensions = false;
        // Constant per les dimensions per defecte del quadrat
        final int DIMENSIONS_DEFECTE = 3;

        // Creació d'una matriu amb les dimensions per defecte
        int[][] llistaNumeros = new int[DIMENSIONS_DEFECTE][DIMENSIONS_DEFECTE];

        // Missatge per confirmar si vol modificar les dimensions
        System.out.print("Dimensions de la capsa per defecte: " + DIMENSIONS_DEFECTE
                    + "X" + DIMENSIONS_DEFECTE + "\nVols modificar les dimensions"
                    + "per defecte (S/N): ");
        // Bucle per comprovar que la resposta és vàlida
        do {
            resposta = sc.nextLine();

            /* 
                Si la resposta no és "S" ni "N", es mostra un missatge d'error i
                es torna a demanar la resposta
            */
            if (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
                System.err.print("ERROR. Resposta incorrecte."
                        + "\nTorna a ficar una resposta (S/N): ");
            } else if (resposta.equalsIgnoreCase("S")) {
                // Si no, crida al mètode demanarDimensions()
                llistaNumeros = demanarDimensions();
                // triarDimensions es fica cert per sortir del bucle
                triarDimensions = true;
            }

        } while (!triarDimensions);

        // Crida al mètode per omplir la matriu
        omplirMatriu(llistaNumeros);

        // Crea una instància de QuadratMagic
        QuadratMagic qm = new QuadratMagic();
        // Crida al mètode esMagic() per verificar si és màgic
        boolean magic = qm.esMagic(llistaNumeros);

        // Si magic es cert vol dir que és un quadrat magic; si no, no
        if (magic) {
            System.out.println("És un quadrat màgic.");
        } else {
            System.out.println("No és un quadrat màgic.");
        }

    }

    /**
     * Mètode per demanar les dimensions del quadrat.
     * @return Matriu amb les dimensions.
     */
    public static int[][] demanarDimensions() {

        // Declaracions de varibles
        int dimensions = 0; // Variable per emmagatzemar les dimensions
        // Matriu que es crearà amb les dimensions triades
        int[][] llistaNumeros;
        // Controla si les dimensions introduïdes són correctes
        boolean dmsCorrecte = false;

        // Es demana a l'usuari que introdueixi les dimensions
        System.out.print("Introdueix les dimensions del quadrat: ");
        // Bucle per assegurar-se que l'usuari introdueix un número enter positiu
        do {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                // Si és enter guarda guarda el valor en la variable
                dimensions = sc.nextInt();
                if (dimensions <= 0) {
                    // Si no és positiu surt un missatge d'error
                    System.err.print("ERROR. No és un nombre positiu."
                        + "\nTorna'l a introduïr: ");
                } else {
                    // Si és, surt del bucle
                    dmsCorrecte = true;
                }
            } else {
                // Si no és enter, surt un missatge d'error
                System.err.print("ERROR. No és un nombre enter."
                        + "\nTorna'l a introduïr: ");
            }
        } while (!dmsCorrecte);

        // Assigna a la matriu les dimensions especificades per l'usuari
        llistaNumeros = new int[dimensions][dimensions];

        return llistaNumeros; // Es retorna la matriu

    }
    
    /**
     * Mètode per omplir la matriu.
     * @param matriu Matriu que serà omplerta.
     */
    public static void omplirMatriu(int[][] matriu) {
        
        // Declaració de variables
        int num; // Variable per emmagatzemar els nombres
        // Controla si el nombre introduït és vàlid
        boolean numCorrecte = false;
        
        // Primer "for" per recòrrer la matriu per files
        for (int i = 0; i < matriu.length; i++) {
            // S'imprimeix la línia on estem situats
            System.out.println("--- Fila " + (i + 1) + " ---");
            // Segon "for" per recòrrer la matriu per columnes
            for (int j = 0; j < matriu[i].length; j++) {
                /* 
                    Bucle per assegurar-se que l'usuari introdueix un número enter
                    positiu
                */
                do {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Columna " + (j + 1) + " : ");
                    if (sc.hasNextInt()) {
                        // Si és enter guarda guarda el valor en la variable
                        num = sc.nextInt();
                        if (num <= 0) {
                            // Si no és positiu surt un missatge d'error
                            System.err.println("ERROR. No és un nombre positiu.");
                        } else {
                            // Si és, surt del bucle
                            numCorrecte = true;
                        }
                    } else {
                        // Si no és enter surt un missatge d'error
                        System.err.println("ERROR. No és un nombre enter.");
                    }
                } while (!numCorrecte);
                
            }
        }
    }

}
