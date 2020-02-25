package com.fakhry.alpro;

import java.text.NumberFormat;
import java.util.Locale;

class Price {

    static void hitungBiayaParkir(int waktuKeluar, int waktuMasuk) {
        int price = 0;
        int waktuTotal = waktuKeluar - waktuMasuk;
        if (waktuTotal < 3600) { //kalau kurang dari sejam
            price = 2000;

        } else if (waktuTotal > 3600 && waktuTotal < 86400) { //kalau lebih dari sejam dan kurang dari 1 hari
            int hours = waktuTotal / 3600;
            price = 1500;
            for (int i = 0; i < hours; i++) {
                price = price + 500;
            }
        } else if (waktuTotal > 86400) { // kalau lebih dari 1 hari
            int days = waktuTotal / 86400;
            for (int i = 1; i < days; i++) {
                price = price + 20000;
            }
        } else {
            System.out.println("Gagal menghitung biaya parkir!");
        }
        System.out.println("Parkir selama\t= " + Time.secToHours(waktuTotal));
        System.out.println("Total Biaya Parkir\t= " + currency(price) + ".");
    }

    static String currency(int money) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeID);
        return formatter.format(money);
    }
}
