package br.pucrs;

import java.util.LinkedList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    /**
     * 1. Vamos começar com um algoritmo já estudado e conhecido em AEDI. O Merge Sort é um algoritmo de ordenação baseado nos seguintes passos:
     * 
     * <ul>
     *   <li>Recursivamente ordene a metade esquerda do vetor</li>
     *   <li>Recursivamente ordene a metade direita do vetor</li>
     *   <li>Mescle (faça o merge) das duas metades para ter o vetor ordenado</li>
     * </ul>  
     * 
     * @implNote implemente o algortimo abaixo:
     * 
     * <pre>{@code
     * MERGE-SORT(L: List with n elements) : Ordered list with n elements
     *     IF (list L has one element)
     *         RETURN L.
     *     Divide the list into duas halves A and B.
     *     A ← MERGE-SORT(A).
     *     B ← MERGE-SORT(B).
     *     L ← MERGE(A, B).
     *     RETURN L.
     * }</pre>
     * 
     * @implNote Teste-o para vetores de inteiros com conteúdos randômicos e tamanhos 32, 2048 e 1.048.576. 
     * Nestes testes, contabilize o número de iterações que o algoritmo executa e o tempo gasto
     * 
     * @param list with n elements
     * @return Ordered list with n elements
     */
    public LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        // caso erro
        if (list == null) {
            throw new IllegalArgumentException("List is null.");
        }

        for (Integer element : list) {
            if (element == null) {
                throw new IllegalArgumentException("List has null elements.");
            }
        }

        // call
        return mergeSort(list, 0, list.size());
    }

    /**
     * 
     * @param list with all n elements
     * @param start position (inclusive).
     * @param end position (exclusive).
     * @return Ordered list (between start to end) but with all n elements
     */
    private LinkedList<Integer> mergeSort(LinkedList<Integer> list, int start, int end) {
        // caso erro
        if (end < start) {
            throw new IllegalArgumentException("Start position before end position.");
        }

        // caso base
        int size = end - start;
        if (size == 0 || size == 1) {
            return list;
        }

        // caso recursivo

        int half = start + size / 2;
        mergeSort(list, start, half);
        mergeSort(list, half, end);

        int lhsPosition = start;
        int rhsPosition = half;

        /**
        * This loop is part of the in-place merge sort algorithm. It compares elements 
        * from the left half and the right half of the list and ensures they are merged 
        * in sorted order directly within the list. The merging continues as long as 
        * there are unprocessed elements in both halves.
        *
        * The loop will iterate under the following conditions:
        *
        * 1. lhsPosition < rhsPosition: 
        *    - Ensures that we are still processing elements in the left half that could 
        *      potentially need to be swapped with elements from the right half. 
        *    - If lhsPosition == rhsPosition, it means all elements in the left 
        *      half have been processed, and the loop can stop.
        *
        * 2. rhsPosition < end: 
        *    - Ensures that there are still unprocessed elements in the right half of the list.
        *    - If rhsPosition == end, it means the right half is fully processed, 
        *      and the loop can stop.
        *
        * The loop continues until one of these conditions is no longer met, at which 
        * point all elements that needed to be merged have been handled.
        *
        */
        while (lhsPosition < rhsPosition && rhsPosition < end) {
            if (list.get(lhsPosition) < list.get(rhsPosition)) {
                lhsPosition += 1;
            } else {
                Integer element = list.remove(rhsPosition);
                list.add(lhsPosition, element);

                lhsPosition += 1;
                rhsPosition += 1;
            }
        }

        return list;
    }

    /**
     * 
     * @param A
     * @param n
     * @return
     */
    long maxVal1(long A[], int n) {  
        long max = A[0];
        for (int i = 1; i < n; i++) {  
            if( A[i] > max ) 
                max = A[i];
        }
        return max;
    }

    /**
     * 
     * @param A
     * @param init
     * @param end
     * @return
     */
    long maxVal2(long A[], int init, int end) {  
        if (end - init <= 1)
            return Math.max(A[init], A[end]);  
        else {
              int m = (init + end)/2;
              long v1 = maxVal2(A,init,m);   
              long v2 = maxVal2(A,m+1,end);  
              return Math.max(v1,v2);
             }
    }
}
