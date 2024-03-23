/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareano2;

import java.util.Scanner;

/**
 *
 * @author Marlon Ramirez
 */
public class TareaNo2 {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        MetodosOrdenamiento metodo = new MetodosOrdenamiento();
        
        int[] arreglo = {5, 2, 9, 1, 4};
        int opcion = 0;
        
          do{
            System.out.println("\n");  
            System.out.println("Seleccione el método de ordenamiento:");
            System.out.println("1. Selection sort (selección)");
            System.out.println("2. Bubble sort (burbuja)");
            System.out.println("3. Insertion sort (inserción)");
            System.out.println("4. Merge sort (combinación)");
            System.out.println("5. Quick sort (rápida)");
            System.out.println("6. Heap sort (montón)");
            System.out.println("7. Counting sort (conteo)");
            System.out.println("8. Radix sort (raíz)");
            System.out.println("9. Bucket sort (cubo)");
            System.out.println("10 Salir");
        opcion = scanner.nextInt();
            switch (opcion) {
            case 1:
                metodo.OrdenamientoSeleccion(arreglo);
                metodo.imprimr(arreglo);
                
                break;
            case 2:
                metodo.OrdenamientoBurbuja(arreglo);
                metodo.imprimr(arreglo);
                
                break;
            case 3:
                metodo.OrdenamientoInsercion(arreglo);
                metodo.imprimr(arreglo);
                break;
            case 4:
                metodo.OrdenamientoCombinacion(arreglo, 0, arreglo.length - 1);
                metodo.imprimr(arreglo);
                
                break;
            case 5:
                metodo.OrdenamientoRapida(arreglo, 0, arreglo.length - 1);
                metodo.imprimr(arreglo);
                break;
            case 6:
                metodo.OrdenaminetoMonton(arreglo);
                metodo.imprimr(arreglo);
                break;
            case 7:
                metodo.OrdenamientoConteo(arreglo);
                metodo.imprimr(arreglo);
                break;
            case 8:
                metodo.OrdenamientoRaiz(arreglo);
                metodo.imprimr(arreglo);
                
                break;
            case 9:
                metodo.OrdenamientoCubo(arreglo);
                metodo.imprimr(arreglo);
                
                break;                
            default:
                System.out.println("Opción no válida");
        }
          }while(opcion !=10);  
        

        System.out.println("Array ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
    
}
