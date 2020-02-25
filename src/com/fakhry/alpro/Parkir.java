package com.fakhry.alpro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Parkir {
    private static Scanner input = new Scanner(System.in);
    private static byte availability = 0;

    static void tiketMasuk(String[][] arr) {
        int i = 0;
        availability = 0;
        while (i < arr[1].length) {
            if (arr[i][2].equals("0")) {
                availability = 1; //It means there is a parking space still available
                System.out.print("Masukkan Nomer Plat Kendaraan Anda : ");

                String plat = input.nextLine().toUpperCase();
                arr[i][0] = plat;

                String waktuMasuk = new SimpleDateFormat("dd-HH-mm-ss").format(Calendar.getInstance().getTime());
                arr[i][1] = waktuMasuk;

                arr[i][2] = Integer.toString(Time.currentTimeInSec());
                arr[i][2] = Integer.toString(0);
                i = arr[1].length;
            } else {
                i++;
            }
        }
        if (availability == 0) {
            System.out.println("Maaf, tempat parkir telah full!");
        }
    }

    static void tiketKeluar(String[][] arr) {
        System.out.print("Masukkan Nomer Plat Kendaraan Anda : ");
        String plat = input.nextLine().toUpperCase();

        for (int i = 0; i < arr[1].length; i++) {
            int waktuKeluar = 2775843;
//            int waktuKeluar = Time.currentTimeInSec();
            if (arr[i][0].equals(plat)) {
                availability = 1;
                Price.hitungBiayaParkir(waktuKeluar, Integer.parseInt(arr[i][2]));
                arr[i][0] = "0";
                arr[i][1] = "0";
                arr[i][2] = "0";
            }
        }
        if (availability == 0) {
            System.out.println("Gagal menemukan plat kendaraan, silakan coba lagi!");
            tiketKeluar(arr);
        }
    }

    static void printTables(String[][] tab) {
        System.out.println("Data Parkiran");
        for (int i = 0; i < tab.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
