/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elsquadratsmagics;

/**
 *
 * @author Bea i Yamila
 */
public class QuadratMagic {

    public QuadratMagic() {

    }

    public boolean esMagic(int[][] matriu) {

        boolean magic;

        int n = matriu.length, l = matriu.length;
        int sumaFiles[] = new int [n], sumaColumnes[] = new int [l];
        int sumaDiago1 = 0, sumaDiago2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                sumaFiles[i] += matriu[i][j];
                sumaColumnes[j] += matriu[i][j];

                
                if (i == j) {
                    sumaDiago1 += matriu[i][j];
                }

                
                if (i + j == n - 1) {
                    sumaDiago2 += matriu[i][j];
                }
            }
        }

        int suma = sumaFiles[0];
        
        magic = sumaColumnes[0] == suma && sumaDiago1 == suma &&
                sumaDiago2 == suma;

        return magic;
    }

}
