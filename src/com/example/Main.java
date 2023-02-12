package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String txtString = "Hola Mundo!";
        System.out.println(reverse(txtString)); //Imprime String inverso

        //Array de Strings a recorrer
        String []arrString = {"Esto ","es ","un ","String ","a ","recorrer!"};
        for (String item : arrString) {
            System.out.println(item);
        }
        //Fin Array de Strings a recorrer
        //Inicio Array Bidimensional de Integers
        int[][] arrBidiInt = new int [2][3];
        arrBidiInt[0][0] = 1;
        arrBidiInt[0][1] = 3;
        arrBidiInt[0][2] = 5;
        arrBidiInt[1][0] = 7;
        arrBidiInt[1][1] = 9;
        arrBidiInt[1][2] = 11;

        for (int i=0; i<arrBidiInt.length; i++) {
            System.out.println("La posición es: "+i);
            for (int j=0;j<arrBidiInt[i].length;j++) {
                System.out.println("Sus valores para arrBidiInt i="+i +" j="+j+" son: "+arrBidiInt[i][j]);
            }
        }
        //Fin Array Bidimensional de Integers
        //Inicio Vector
        Vector<Integer> vector = new Vector<>();
        vector.add(22);
        vector.add(36);
        vector.add(12);     //Se añaden 5 elementos
        vector.add(48);
        vector.add(69);
        System.out.println("Los valores iniciales del vector son: " +vector);
        vector.remove(3);
        vector.remove(2);   //Se eliminan los elementos en índice 2, 3 y se imprimen
        System.out.println("Los valores actuales del vector son: " +vector);
        //Fin Vector
        //Inicio ArrayList a LinkedList
        ArrayList<String> arrayListStr = new ArrayList<>();
        arrayListStr.add("Esto");
        arrayListStr.add("es");
        arrayListStr.add("una");
        arrayListStr.add("cadena");
        System.out.println("Los valores de la ArrayList son: ");
        for (String itemAL:arrayListStr){
            System.out.println(itemAL);
        }
        LinkedList<String> linkedArrayListStr = new LinkedList<>(arrayListStr);
        System.out.println("Los valores de la LinkedList son: ");
        for (String itemLL:linkedArrayListStr){
            System.out.println(itemLL);
        }
        //Fin ArrayList a LinkedList
        //Inicio ArrayList Int sin pares
        ArrayList<Integer> arrLIntSP = new ArrayList<>();
        int contIter = 1;
        for (int i=0; i<10; i++) {
            arrLIntSP.add(contIter);                //Se añade el valor de contIter al ArrayList hasta fin del bucle
            contIter++;
        }
        for(int i=0; i<arrLIntSP.size(); i++) {
            if (arrLIntSP.get(i)%2 == 0) {
                arrLIntSP.remove(i);                //Se eliminan los valores pares (cuyo resto sea 0)
            }
        }
        System.out.println("Los valores de la ArrayList Int sin pares son: "+arrLIntSP);
        //Fin ArrayList Int sin pares
        //Inicio Try Catch Finally de DividePorCero
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dos números a dividir: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        try {
            int result = DividePorCero(a, b);
            System.out.println("El resultado de la división es: "+result);
        }catch (Exception e){
            System.out.println("NO SE DIVIDE POR 0, PALURDO DE 8 PATAS");
        }finally {
            System.out.println("Demo de código");
        }
        //Fin Try Catch Finally de DividePorCero
        //Inicio InputStream y PrintStream
        String fileIn = "src/fileIn.txt";
        String fileOut = "src/fileOut.txt";
        try{
            InputStream fichIn = new FileInputStream(fileIn);
            PrintStream fichOut = new PrintStream(fileOut);
            fichOut = copiarFich(fichIn,fichOut);
            byte[] datos = fichIn.readAllBytes();
            for(byte dataE : datos){
                System.out.println(dataE);
            }
            fichIn.close();
            fichOut.close();
        }catch (FileNotFoundException e){
            System.out.println("No se halla el fichero");
        } catch (IOException e) {
            System.out.println("Error Fichero");
        }
        //Fin InputStream y PrintStream
    }

    public static String reverse(String strReverse) {       //Función para invertir un String
        StringBuilder sb = new StringBuilder(strReverse);
        sb.reverse();
        return sb.toString();
        }
    public static int DividePorCero(int a, int b) throws ArithmeticException, IOException{
        int result;
        try{
            result = a/b;
        }catch (ArithmeticException e){
            throw new IOException();
        }
        return result;
    }
    public static PrintStream copiarFich(InputStream fichIn,PrintStream fichOut){
        try {
            byte[] datos = fichIn.readAllBytes();
            for (byte dato:datos){
                fichOut.println((char)dato);
            }
        } catch (IOException e){
            System.out.println("Imposible leer fichero"+e.getMessage());
        }
        return fichOut;
    }
}
