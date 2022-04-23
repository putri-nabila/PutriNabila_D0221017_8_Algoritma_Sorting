package TugasAsd7;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomQuickSort {
    public static void main(String[] args) {
        ArrayList<Double> elements = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Banyak Data : ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke "+i+" : ");
            Double nilai = scan.nextDouble();
            elements.add(nilai);
        }
        System.out.println("Data Asli         : "+elements);
        randomQuickSort(elements, 0, elements.size()-1);
        System.out.print("Random Quick Sort : ");
        System.out.print("[");
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i)+" ");
        }
        System.out.print("]");
        scan.close();
    }
    public static void swap(ArrayList<Double> elements,int i, int j){
        Double temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    public static int partition(ArrayList<Double> elements, int beg, int end){
        int random = beg + ((int)Math.random()*(elements.size()))/(end-beg+1);
        int last = end;
        swap(elements, random, end);
        end--;
        
        while(beg <= end){
            if(elements.get(beg)<elements.get(last))beg++;
            else{
                swap(elements, beg, end);
                end--;
            }
        }
        swap(elements, beg, last);
        
        return beg;
    }
    public static void randomQuickSort(ArrayList<Double> elements, int beg, int end){
        if(beg >= end)return;
        if(beg < 0)return;
        if(end > elements.size()-1)return;
        
        int pivot = partition(elements, beg, end);
        randomQuickSort(elements, beg, pivot-1);
        randomQuickSort(elements, pivot+1, end);
    }
    
}
