/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.elsquadratsmagics;

import java.util.Scanner;

/**
 * Classe principal. És on es demana a l'usuari per les dimensions del quadrat i
 * el seu contingut.
 *
 * @author Bea i Yamila
 */
public class MainClass {

    /**
     * Mètode main
     *
     * @param args
     */
    public static void main(String[] args) {

        // Declaració de variables
        String resposta; // String per saber si vol una longitud personalitzada
        // Array per guardar la cadena de numeros de cada columna
        String[] cadenaNums;
        int num; //int per guardar els numeros de la array
        QuadratMagic qm = null; // Instància de QuadratMagic incialitzada com null
        /*
            boolean per saber si ha introduït bé la resposta i guardar el valor
            del mètode de la classe QuadratMagic
        */
        boolean respostaCorrecte = false, magic;
        // Finals afirmatiu i negatiu
        final String VALOR_PERSONALITZAT = "S", VALOR_DEFECTE = "N";

        // Declaració d'un escànner
        Scanner sc = new Scanner(System.in);

        // Missatge per mostrar les dimensions per defecte
        System.out.println("Dimensions de la capsa per defecte: 3X3");
        // Missatge per preguntar si vol personalitzar les dimensions
        System.out.print("Vols modificar les dimensions per defecte (S/N): ");

        // do-while per comprovar si la resposta és correcte o no
        do {
            // Guarda la cadena de text en la variable
            resposta = sc.nextLine();

            // Condicional per comprovar si vol o no personalitzar la longitud
            if (resposta.equalsIgnoreCase(VALOR_PERSONALITZAT)) {
                // Si és que sí, li pregunta per la longitud
                System.out.print("Introdueix una longitud: ");
                /*
                    Crida al constructor amb paràmetre i guarda el valor del
                    mètode demanarLongitud()
                */
                qm = new QuadratMagic(demanarLongitud());
                // Fa certa la varaiable booleana per sortir del bucle
                respostaCorrecte = true;
            } else if (resposta.equalsIgnoreCase(VALOR_DEFECTE)) {
                // // Si és que no, crida al consctructor per defecte
                qm = new QuadratMagic();
                // Fa certa la varaiable booleana per sortir del bucle
                respostaCorrecte = true;
            } else {
                // Si no és cap, mostra un missatge d'error
                System.out.print("ERROR. Resposta incorrecte."
                        + "\nTorna a introduir-la (S/N): ");
            }
        } while (!respostaCorrecte);

        // Missatge  per indicar que farem i instruccions a seguir
        System.out.println("\n--- Ompliment del quadrat màgic per files ---"
                + "\nNota: separar els nombres per ',', espais o '.'");
        
        // Primer "for" per recòrrer la matriu per files
        for (int i = 0; i < qm.matriu.length; i++) {
            // S'imprimeix la fila on estem situats
                System.out.print("Fila " + (i + 1) + ": ");
                // Guarda el valor del mètode llegirEnterTeclat() en l'array
                cadenaNums = llegirEnterTeclat();
            // Segon "for" per recòrrer la matriu per columnes
            for (int j = 0; j < qm.matriu[i].length; j++) {
                /*
                    Guarda el valor de cada posició de l'array en un int
                    Ho fa fent una conversió de String a int
                */
                num = Integer.parseInt(cadenaNums[j]);
                /*
                    Crida al mètode setValorMatriu, on la "i" són les files,
                    la "j" són les columnes i num els valors a introduir
                */ 
                qm.setValorMatriu(i, j, num);
            }
        }

        /*
            Crida al mètode esMagic(), ficant com a paràmetre la nostre matriu,
            per comprovar si és un quadrat màgic o no
        */
        magic = qm.esMagic(qm.matriu);

        // Condicional per mirar si el valor de magic és cert o no
        if (magic) {
            // Si ho és, mostra el missatge de que és un quadrat màgic
            System.out.println("És un quadrat màgic.");
        } else {
            // Si no ho és, mostra el missatge de que no és un quadrat màgic
            System.out.println("No és un quadrat màgic.");
        }

    }

    /**
     * Mètode per llegir cadenes de numeros separats per comes, punts i espais
     * @return una array de tipus String amb els valors guardats
     */
    public static String[] llegirEnterTeclat() {

        // Declaració de l'escàner
        Scanner sc = new Scanner(System.in);

        // Declaració de Strings
        String cadena;
        // final per especificar quins símbols faran de separador
        final String spl = "[,\\s\\.]";
        // Declaració de l'array per guardar els nombres ja separats
        String[] nums;

        // Demenem una cadena de nombres a l'usuari
        cadena = sc.nextLine();

        // Separa la cadena i guarda els valors en l'array
        nums = cadena.split(spl);

        // Retorna el resultat de l'array
        return nums;
    }

    /**
     * Mètode per demanar una longitud per definir les dimensions del quadrat
     * @return un int amb la longitud
     */
    public static int demanarLongitud() {
        
        //Declaració de variables
        int longitud = 0; // int per guardar la longitud
        // boolean per saber que és una longitud correcte
        boolean numCorrecte = false;
        // final per dir el mínim de longitud
        final int MINIM_LONGITUD = 2;

        // do-while per tornar a preguntar si és un longitud invàlida
        do {
            // Declaració de l'escàner
            Scanner sc = new Scanner(System.in);
            // Condicional per saber si és enter l'entrada de l'usuari
            if (sc.hasNextInt()) {
                // Guarda el valor si és enter
                longitud = sc.nextInt();
                // Condicional intern per saber si és compleix el mínim de longitud
                if (longitud >= MINIM_LONGITUD) {
                    // Si ho compleix surt del bucle
                    numCorrecte = true;
                } else {
                    // Si no, surt un missatge d'error i no surt del bucle
                    System.err.print("ERROR. No és un nombre positiu."
                            + "\nTorna a introduir de nou el valor: ");
                }
            } else {
                // Si no és enter, surt un missatge d'error i no surt del bucle
                System.err.print("ERROR. No és un nombre enter."
                        + "\nTorna a introduir de nou el valor: ");
            }
        } while (!numCorrecte);

        // Retorna el resultat de longitud
        return longitud;
    }

}
