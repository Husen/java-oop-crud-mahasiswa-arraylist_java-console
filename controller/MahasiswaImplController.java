package com.z.challenge.controller;

import com.z.challenge.service.MahasiswaImpService;
import com.z.challenge.view.App;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MahasiswaImplController implements IMahasiswaController{
    Scanner in;
    MahasiswaImpService mahasiswaImpService = new MahasiswaImpService();

    public MahasiswaImplController(Scanner input) {
        this.in = input;
    }

    @Override
    public void addMahasiswa() {
        System.out.println("\n-----------------------------------\n");
        System.out.println("\t\t=== Add Mahasiswa ===");
        System.out.print("Nama (3-20 karakter) : ");
        var inName = in.next();
        while (!inName.matches("[a-zA-Z]{3,20}")) {
            System.out.println("Nama hanya bisa dengan karakter huruf dan min 3 , max 20");

            System.out.print("Nama (3-20 karakter) : ");
            inName = in.next();
        }

        System.out.print("Umur (min 17 tahun) : ");
        int inAge = 0;
        try {
            inAge = in.nextInt();
            while (inAge < 17) {
                System.out.println("Usia min 17 tahun");

                System.out.print("Umur (min 17 tahun) : ");
                inAge = in.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("err " + e);
            System.out.println("invalid input age");
            App app = new App();
            app.menu();
        }

        System.out.print("Jurusan (maks 10 karakter) : ");
        var inJurusan = in.next();
        while (!inJurusan.matches("[a-zA-Z]{1,10}")) {
            System.out.println("Jurusan max 10 karakter huruf");

            System.out.print("Jurusan (maks 10 karakter) : ");
            inJurusan = in.next();
        }
            mahasiswaImpService.add(inName, inAge, inJurusan);
    }

    @Override
    public void deleteMahasiswa() {
        mahasiswaImpService.delete();
    }

    @Override
    public void show() {
        System.out.println("\n-----------------------------------\n");
        System.out.println("\t\t=== View Mahasiswa ===");
        System.out.println("1. View By Index");
        System.out.println("2. View All");
        System.out.print("\nMasukan menu yang di pilih : ");
        var selectShow = in.next();
        while (!selectShow.matches("[1-2]")) {
            System.out.println("Menu " + selectShow + " pada view tidak tersedia");

            System.out.print("\nMasukan menu yang di pilih : ");
            selectShow = in.next();
        }
        if (selectShow.equals("1")) {
            System.out.print("Masukan Index : ");
            int indexMhs;
            try {
                indexMhs = in.nextInt();
                mahasiswaImpService.get(indexMhs - 1);
            } catch (InputMismatchException e) {
                System.out.println("err " + e);
                System.out.println("invalid input index");
                App app = new App();
                app.menu();
            }
        } else if (selectShow.equals("2")) {
            mahasiswaImpService.get();
        }
    }
}
