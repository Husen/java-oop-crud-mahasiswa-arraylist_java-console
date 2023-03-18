package com.z.challenge.view;

import com.z.challenge.controller.MahasiswaImplController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    MahasiswaImplController mahasiswaImplController = new MahasiswaImplController(input);
    public void menu() {
        boolean run = true;
        while (run) {
            System.out.println("\n-----------------------------------");
            System.out.println("\t\t=== Main Menu ===");
            System.out.println("-----------------------------------");
            System.out.println("1. Add Mahasiswa");
            System.out.println("2. Delete Mahasiswa (Last Record)");
            System.out.println("3. Show Mahasiswa");
            System.out.println("4. Exit");

            System.out.print("\nMasukan menu yang dipilih : ");
            int selectMenu;
            try {
                selectMenu = input.nextInt();

                if (selectMenu < 1 || selectMenu > 4) {
                    System.out.println("Menu tidak tersedia !");
                    menu();
                } else {
                    switch (selectMenu) {
                        case 1 -> mahasiswaImplController.addMahasiswa();
                        case 2 -> mahasiswaImplController.deleteMahasiswa();
                        case 3 -> mahasiswaImplController.show();
                        case 4 -> {
                            System.out.println("\t\tGoodBye :(");
                            run = false;
                            System.exit(0);
                        }

                    }
                }
                } catch (InputMismatchException e) {
                System.out.println("err " + e);
                System.out.println("invalid input menu !");
                run = false;
            }
        }
    }
}
