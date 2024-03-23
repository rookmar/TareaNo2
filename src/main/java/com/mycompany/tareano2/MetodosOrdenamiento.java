/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareano2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marlon Ramirez
 */
public class MetodosOrdenamiento {
 
    
    public void OrdenamientoSeleccion(int arreglo1[]){
        for (int i = 0; i < arreglo1.length -1 ; i++) {
            int minimo = i;
            for (int j = 1+1; j < arreglo1.length; j++) {
                if(arreglo1[j] < arreglo1[minimo]){
                    minimo = j;
                }               
            }
            int aux = arreglo1[i];
            arreglo1[i] = arreglo1[minimo];
            arreglo1[minimo]=aux;
        }
    }
    public void imprimr (int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            
        }      
    }   
      public void OrdenamientoBurbuja(int arreglo2[]){
          int n = arreglo2.length;
          for (int i = 0; i < n - 1; i++) {
              for (int j = 0; j < n - i - 1; j++) {
                  if(arreglo2[j] > arreglo2[j+1]){
                      int aux2 = arreglo2[j];
                      arreglo2[j]= arreglo2[j+1];
                      arreglo2[j+1] = aux2;
                      
                  }
                  
              }

          }    
    }
      
    public void OrdenamientoInsercion(int arreglo3[]){
                int n = arreglo3.length;
        for (int i = 1; i < n; ++i) {
            int key = arreglo3[i];
            int j = i - 1;

            while (j >= 0 && arreglo3[j] > key) {
                arreglo3[j + 1] = arreglo3[j];
                j = j - 1;
            }
            arreglo3[j + 1] = key;
        }
    } 
   
   public void OrdenamientoCombinacion(int[] arr, int l, int r) {
        if (l < r) {
            // Encuentra el punto medio del arreglo
            int m = (l + r) / 2;

            OrdenamientoCombinacion(arr, l, m);
            OrdenamientoCombinacion(arr, m + 1, r);


            Combinacion(arr, l, m, r);
        }
    }

    public void Combinacion(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    
    public void OrdenamientoRapida(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);


            OrdenamientoRapida(arr, low, pi - 1);
            OrdenamientoRapida(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;


                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    
   public void OrdenaminetoMonton(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < n && arr[l] > arr[largest])
            largest = l;

      
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public void OrdenamientoConteo(int[] arr) {
        int max = getMax(arr);
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[max + 1];


        for (int i = 0; i <= max; ++i) {
            count[i] = 0;
        }


        for (int i = 0; i < n; ++i) {
            ++count[arr[i]];
        }

        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1];
        }


        for (int i = 0; i < n; ++i) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < n; ++i) {
            arr[i] = output[i];
        }
    }

    public void OrdenamientoRaiz(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    
        public void OrdenamientoCubo(int[] arr) {
        int max = getMax(arr);
        int digits = countDigits(max);

        for (int d = 0; d < digits; d++) {
            List<List<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            for (int num : arr) {
                int digit = getDigit(num, d);
                buckets.get(digit).add(num);
            }

            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (int num : bucket) {
                    arr[index++] = num;
                }
            }
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    private static int getDigit(int num, int d) {

        num /= Math.pow(10, d);
        return num % 10;
    }
}


