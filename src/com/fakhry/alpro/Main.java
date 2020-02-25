package com.fakhry.alpro;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        String[][] arr = new String[3][3];

        //arr.length = sum of rows
        //arr[1].length = sum of coulumns

        //mengisi semua elemen pada array dengan 0;
        for (String[] strings : arr) {
            Arrays.fill(strings, "0");
        }
        try {
            while (true) {
                Parkir.printTables(arr);
                System.out.println("*********************************");
                System.out.println("1.\tParkir Masuk\n2.\tParkir Keluar\nApkah anda ingin parkir masuk(1) atau parkir keluar(2)?");
                choose = input.nextInt();
                input.nextLine();
                if (choose == 1) {
                    Parkir.tiketMasuk(arr);
                } else if (choose == 2) {
                    Parkir.tiketKeluar(arr);
                } else {
                    System.out.println("Anda salah memasukkan Inputan");
                }
                System.out.println("*********************************");
            }
        }catch (Exception e){
            System.out.println("Error! Silakan jalankan ulang program.");
        }
    }
}