package TugasAsd7;

import java.util.ArrayList;
import java.util.Scanner;

public class Sorting {
    
    //METHOD ISI DATA
    static ArrayList<Double> inisialisasi(){
        ArrayList<Double> arrList = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        System.out.print("Input Banyak Data : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Double nilai = sc.nextDouble();
            arrList.add(nilai);
        }
        return arrList;
    }
    
    //METHOD CETAK
    static void cetak (ArrayList<Double> cetak){
        System.out.print("[");
        for(Double value : cetak){
            System.out.print(" "+value+" ");
        }
        System.out.println("]");
    }
    
    //METHOD KLONING
    static ArrayList<Double> kloning(ArrayList<Double> kloning){
        ArrayList<Double> arrList1 = null;
        if(kloning != null){
            arrList1 = new ArrayList<>();
            for(Double value1 : kloning){
                arrList1.add(value1);
            }
        }
        return arrList1;
    }
    
    //METHOD SORTING
    static void tukarNilai (ArrayList<Double> tukarNilai, int indexA, int indexB){
        if(indexA >= 0 && indexA <tukarNilai.size() && indexB >= 0 && indexB <tukarNilai.size() && indexA != indexB){
            Double A, B, C;
            A = tukarNilai.get(indexA);
            B = tukarNilai.get(indexB);
            C = A;
            A = B;
            B = C;
            tukarNilai.set(indexA, A);
            tukarNilai.set(indexB, B);
        }
    }
    
    //ALGORITMA BUBBLE SORT
    static void bubbleSort (ArrayList<Double> bubble){
        int n = bubble.size();
        boolean adaPertukaran = true;
        do{
            adaPertukaran = false;
            for (int i = 1; i < n; i++) {
                if(bubble.get(i-1) > bubble.get(i)){
                    tukarNilai(bubble, (i-1), i);
                    adaPertukaran = true;
                }
            }
            n--;
        }while(adaPertukaran);
    }
    
    //ALGORITMA SELECTION SORT
    static void selectionSort(ArrayList<Double> selection){
        int n = selection.size();
        for (int i = 0; i < n-1; i++) {
            int jMIN = i;
            for (int j = i+1; j < n; j++) {
                jMIN = j;
            }
            if (jMIN != i){
                tukarNilai(selection, i, jMIN);
            }
        }
    }
    
    //ALGORITMA INSERTION SORT
    static void insertionSort(ArrayList<Double> insertion){
        int n = insertion.size();
        int i = 1;
        int j;
        while(i < n){
            Double temp = insertion.get(i);
            for (j = i; j > 0; j--) {
                if(temp < insertion.get(j-1)){
                    insertion.set(j, insertion.get(j-1));
                }else{
                    break;
                }
            }
            insertion.set(j, temp);
            i++;
        }
    }
    
    //ALGORITMA MERGE SORT
    static void mergeSort(ArrayList<Double> merge){
        int n = merge.size();
        if(n<2){
            return;
        }
        int tengah = n/2;
        
        ArrayList<Double> mergeKiri = new ArrayList<>();
        for (int i = 0; i < tengah; i++) {
            mergeKiri.add(merge.get(i));
        }
        
        ArrayList<Double> mergeKanan = new ArrayList<>();
        for (int i = tengah; i < n; i++) {
            mergeKanan.add(merge.get(i));
        }
        
        mergeSort(mergeKiri);
        mergeSort(mergeKanan);
        
        merge(merge, mergeKiri, mergeKanan);
    }
    
    static void merge(ArrayList<Double> merge, ArrayList<Double> mergeKiri, ArrayList<Double> mergeKanan){
        int i = 0, j=0, k=0;
        int sKiri = mergeKiri.size();
        int sKanan = mergeKanan.size();
        
        while(i<sKiri && j<sKanan){
            if (mergeKiri.get(i)<mergeKanan.get(j)) {
                merge.set(k++, mergeKiri.get(i++));
            }
            else{
                merge.set(k++, mergeKanan.get(j++));
            }
        }
        while(i<sKiri){
            merge.set(k++, mergeKiri.get(i++));
        }
        while(j<sKanan){
            merge.set(k++, mergeKanan.get(j++));
        }
    }
    
    //ALGORITMA QUICK SORT
    static int partisi (ArrayList<Double> arrList, int low, int high){
        Double pivot = arrList.get(high);
        int i = low-1;
        for (int j = low; j < high; j++) {
            if(arrList.get(j)<pivot){
                i++;
                tukarNilai(arrList, i, j);
            }
        }
        tukarNilai(arrList, i+1, high);
        return i+1;
    }
    static void quickSort(ArrayList<Double> arrList, int low, int high){
        if (low<high) {
            int indexPartisi = partisi(arrList, low, high);
            quickSort(arrList, low, indexPartisi-1);
            quickSort(arrList, indexPartisi+1, high);
        }
    }
            
    public static void main(String[] args) {
        ArrayList<Double> data = inisialisasi();
        System.out.print("Data Asli      : ");
        cetak(data);
        
        ArrayList<Double> data1 = kloning(data);
        System.out.print("Bubble Sort    : ");
        bubbleSort(data1);
        cetak(data1);
        
        ArrayList<Double> data2 = kloning(data);
        System.out.print("Selection Sort : ");
        selectionSort(data2);
        cetak(data1);
        
        ArrayList<Double> data3 = kloning(data);
        System.out.print("Insertion Sort : ");
        insertionSort(data3);
        cetak(data3);
        
        ArrayList<Double> data4 = kloning(data);
        System.out.print("Merge Sort     : ");
        mergeSort(data4);
        cetak(data4);
        
        ArrayList<Double> data5 = kloning(data);
        System.out.print("Quick Sort     : ");
        quickSort(data5, 0, data5.size()-1);
        cetak(data5);
        
    }
    
}

