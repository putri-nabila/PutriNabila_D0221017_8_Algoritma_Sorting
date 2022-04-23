package TugasAsd7;

import java.util.*;
import java.lang.Math;

public class CountingSort {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, j, i;
        System.out.print("Input Banyak Data : ");
        n = input.nextInt();
        int[] data = new int[n];
        
        for (i = 0; i <= n - 1; i++) {
            System.out.print("Elemen ke "+i+" : ");
            data[i] = input.nextInt();
        }
        
        // Mencetak data array
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
        
        // Memulai counting sort
        // Pertama cari nilai MIN dan MAX
        int mIN, mAX;
        
        mIN = 99999;
        mAX = (int) (-99999);
        for (i = 0; i <= n - 1; i++) {
            if (data[i] > mAX) {
                mAX = data[i];
            }
            if (data[i] < mIN) {
                mIN = data[i];
            }
        }
        
        // Membuat array arrCount berukuan (MAX-MIN)+1
        int nCount;
        
        nCount = mAX - mIN + 1;
        int[] arrCount = new int[nCount];
        
        // Inisialisasi array arrCount
        for (i = 0; i <= nCount - 1; i++) {
            arrCount[i] = 0;
        }
        
        // Melakukan counting
        for (i = 0; i <= n - 1; i++) {
            int value;
            
            value = data[i];
            j = value - mIN;
            arrCount[j] = arrCount[j] + 1;
        }
        
        // Meletakkan hasil counting ke array hasil sorting
        int k;
        
        k = 0;
        for (i = 0; i <= nCount - 1; i++) {
            if (arrCount[i] > 0) {
                int nK;
                
                nK = arrCount[i];
                int value;
                
                value = mIN + i;
                for (j = 1; j <= nK; j++) {
                    data[k] = value;
                    k = k + 1;
                }
            }
        }
        
        // Mencetak hasil sorting
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }
}
