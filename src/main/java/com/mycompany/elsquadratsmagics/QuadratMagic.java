/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elsquadratsmagics;

/**
 * Classe QuadratMagic. Comprova si cert o fals que el quadrat és màgic.
 *
 * @author Bea i Yamila
 */
public class QuadratMagic {

    /**
     * Constructor buit de la classe, ja que no en té d'atributs la classe
     */
    public QuadratMagic() {

    }

    /**
     * Mètode que comprova si la matriu introduïda és un quadrat màgic.
     *
     * @param matriu Matriu a comprovar.
     * @return Retorna true si és un quadrat màgic i false si no ho és.
     */
    public boolean esMagic(int[][] matriu) {

        // Declaracions de variables
        // Variable booleana per indicar si la matriu és màgica o no
        boolean magic = true;
        // Nombre de files i columnes de la matriu
        int n = matriu.length, l = matriu.length;
        // Arrays per emmagatzemar la suma de cada fila i columna
        int sumaFiles[] = new int[n], sumaColumnes[] = new int[l];
        // Variables per a les sumes de les diagonals
        int sumaDiago1 = 0, sumaDiago2 = 0;

        /*
            for per recòrrer la matriu per calcular les sumes de files, columnes
            i diagonals
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Suma dels valors de cada fila
                sumaFiles[i] += matriu[i][j];
                // Suma els valors de cada columna
                sumaColumnes[j] += matriu[i][j];

                // Suma dels valors de la diagonal
                if (i == j) {
                    /*
                        Suma quan veu que dues posicions de les files i columnes
                        són iguals, és la manera d'anar recorrent la matriu en
                        diagonal
                     */
                    sumaDiago1 += matriu[i][j];
                }

                // Suma dels valors de la diagonal invertida
                if (i + j == n - 1) {
                    /*
                        En comptes de comprovar que siguin iguals, si sumem
                        les dues posicions i comperem amb un contador a l'inversa
                        es pot recòrrer una diagonal inversa
                     */
                    sumaDiago2 += matriu[i][j];
                }
            }
        }

        // Emmagatzamem la suma de la primera fila per fer la comparació
        int suma = sumaFiles[0];

        // Fa el recorregut de les dues arrays creades per realitzar la suma
        for (int i = 0; i < n; i++) {
            if (sumaFiles[i] != suma || sumaColumnes[i] != suma) {
                /* 
                    Si troba alguna fila o columna que no és igual el quadrat
                    no serà un quadrat màgic
                */
                magic = false;
            }
        }

        // El mateix però amb les diagonals
        if (sumaDiago1 != suma || sumaDiago2 != suma) {
            magic = false;
        }

        return magic; // Retorna el valor de magic
    }

}
