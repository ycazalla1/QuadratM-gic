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

    // Declaració d'atributs
    int[][] matriu; // Matriu que representa el quadrat
    int longitud; // Longitud de les files i columnes
    // Final per definir la longitud per defecte
    final static int LONGITUD_DEFECTE = 3;

    /**
     * Constructor per defecte. Inicialitza una matriu de 3x3
     */
    public QuadratMagic() {
        this.longitud = LONGITUD_DEFECTE;
        this.matriu = new int[LONGITUD_DEFECTE][LONGITUD_DEFECTE];
    }

    /**
     * Constructor amb longitud personalitzada
     *
     * @param longitud mida del quadrat
     */
    public QuadratMagic(int longitud) {
        this.longitud = longitud;
        this.matriu = new int[longitud][longitud];
    }

    /**
     * Getter de longitud
     *
     * @return longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Mètode per assignar un valor en cada posició de la matriu
     *
     * @param fila Posició de la fila
     * @param columna Posició de la columna
     * @param valor Valor a assignar
     */
    public void setValorMatriu(int fila, int columna, int valor) {
        matriu[fila][columna] = valor;
    }

    /**
     * Mètode que comprova si la matriu introduïda és un quadrat màgic
     *
     * @param matriu Matriu a comprovar
     * @return Retorna true si és un quadrat màgic i false si no ho és
     */
    public boolean esMagic(int[][] matriu) {

        // Declaracions de variables
        // Arrays per emmagatzemar la suma de cada fila i columna
        int suma = 0, sumaFiles = 0, sumaColumnes = 0;
        // Variables per a les sumes de les diagonals
        int sumaDiago1 = 0, sumaDiago2 = 0;
        
        final int VALOR_INICI = 0;

        // Calcula la suma de la primera fila per usar com a referència
        for (int j = 0; j < longitud; j++) {
            // Suma dels valors de la primera fila
            suma += matriu[VALOR_INICI][j];// Guarda la suma com a referència
        }

        /*
            for per recòrrer la matriu per calcular les sumes de files, columnes
            i diagonals
         */
        for (int i = 0; i < this.longitud; i++) {
            for (int j = 0; j < this.longitud; j++) {

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
                if (i + j == (this.longitud - 1)) {
                    /*
                        En comptes de comprovar que siguin iguals, si sumem
                        les dues posicions i comperem amb un contador a l'inversa
                        es pot recòrrer una diagonal inversa
                     */
                    sumaDiago2 += matriu[i][j];
                }
            }

        }

        // Comprova sumes de files
        for (int i = 0; i < longitud; i++) {
            sumaFiles = 0; // Reinicia cada cop que pasa de fila a 0
            for (int j = 0; j < longitud; j++) {
                // Suma cada valor de la fila
                sumaFiles += matriu[i][j];
            }
            // Comprova cada cop si és igual a la suma de referència
            if (suma != sumaFiles) {
                // Si no són iguals retorna false
                return false;
            }
        }

        // Comprova sumes de columnes
        for (int j = 0; j < longitud; j++) {
            sumaColumnes = 0; // Reinicia cada cop que pasa de columna a 0
            for (int i = 0; i < longitud; i++) {
                // Suma cada valor de la columna
                sumaColumnes += matriu[i][j];
            }
            // Comprova cada cop si és igual a la suma de referència
            if (suma != sumaColumnes) {
                // Si no són iguals retorna false
                return false;
            }
        }

        // Comprova si ambdues diagonals són iguals a la suma de referència
        if (sumaDiago1 != suma || sumaDiago2 != suma) {
            // Si un dels dos no ho és, retorna false
            return false;
        }

        // Si tot és igual retorna true
        return true;
    }

    /**
     * Mètode toString
     * @return una cadena de text amb els valors dels atributs
     */
    @Override
    public String toString() {
        return "QuadratMagic{" + "matriu=" + matriu + ", longitud=" + longitud + '}';
    }

}
