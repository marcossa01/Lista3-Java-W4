package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] iArr = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2501, 8};

        int tamanhoArray = iArr.length;

        //int maiorDigito = MaiorQuantidadeDigitos(iArr);
        int maiorDigito = Integer.toString(MaiorQuantidadeDigitos(iArr)).length();

        radixSort(iArr, tamanhoArray);

        for (int i : iArr) {
            //String.format incrementa zeros a esquerda
            System.out.println(String.format("%0" + maiorDigito + "d", i));
        }
    }

    public static int MaiorQuantidadeDigitos(int[] iArr) {
        int maior = 0;

        //Pega maior quantidade de digitos
        /* int quantidadeDigitos = 0;

        String[]  array = new String[iArr.length];

        //Transforma array de int para String
        for (int i = 0; i < iArr.length; i++) {
            array[i] = Integer.toString(iArr[i]);
        }

        for (int i = 0; i < array.length; i++) {
            quantidadeDigitos = array[i].length();
            if(quantidadeDigitos > maior) {
                maior = quantidadeDigitos;
            }
         */

        //Pega o maior número
        for (int i = 0; i < iArr.length; i ++) {
            if(iArr[i] > maior) {
                maior = iArr[i];
            }
        }
        return maior;
    }

    static void countSort(int[] iArr, int tamanhoArray, int exp) {
        int[] saida = new int[tamanhoArray];
        int[] contagem = new int[100000];
        Arrays.fill(contagem, 0);

        //Armazena a contagem de ocorrencias na contagem
        for(int i = 0; i < tamanhoArray; i++){
            contagem[(iArr[i] / exp) % 100000] ++ ;
        }

        //Contruir o Array de saída
        for(int i = 1; i < 100000; i++) {
            contagem[i] += contagem[i - 1];
        }

        //Construir Array de saída
        for (int i = tamanhoArray - 1; i >= 0; i--) {
            saida[contagem [ (iArr[i] / exp) % 100000] - 1] = iArr[i];
            contagem[(iArr[i] / exp) % 100000]--;
        }

        //Copie a matriz de saída para iArr[], de modo que iArr[] agora contém números classificados de acordo com o dígito atual
        for (int i = 0; i < tamanhoArray; i++) {
            iArr[i] = saida[i];
        }
    }

    static void radixSort(int[] iArr, int n) {

        //Encontrando Maior número do array
        int m = iArr.length;
        for(int exp = 1; m / exp > 0; exp *=100000) {
            countSort(iArr, n, exp);
        }
    }
}
