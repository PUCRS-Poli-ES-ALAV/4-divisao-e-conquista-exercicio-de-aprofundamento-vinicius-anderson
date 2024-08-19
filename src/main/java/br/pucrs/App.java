import java.util.ArrayList;
package br.pucrs;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public ArrayList<Integer> mergeSort(ArrayList<Integer> lista){
        int tamanho = lista.size();
        if (tamanho == 1) return lista.get(0);



        ArrayList<Integer> a = mergeSort(lista.subList(0, tamanho/2));
        ArrayList<Integer> b = mergeSort(lista.subList(tamanho/2 + 1, tamanho-1));
        
        ArrayList<Integer> l = new ArrayList<Integer>();




        while (!a.isEmpty() && !b.isEmpty()){
            if (a.getFirst() < b.getFirst()) {
                Integer e = a.remove(0);
                l.add(e);
            } else {
                Integer e = b.remove(0);
                l.add(e);
            }
        }

        if (a.isEmpty()) {
            while (!b.isEmpty()) {
                Integer e = b.removeFirst();
                l.add(e);
            }
        } else if (b.isEmpty()) {
            while (!b.isEmpty()) {
                Integer e = b.removeFirst();
                l.add(e);
            }
        }



    }
}
