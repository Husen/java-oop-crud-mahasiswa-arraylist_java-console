package com.z.challenge.service;

import com.z.challenge.model.Mahasiswa;
import com.z.challenge.repository.MahasiswaImpRepo;

public class MahasiswaImpService implements IMahasiswaService{
    MahasiswaImpRepo mahasiswaImpRepo = new MahasiswaImpRepo();
    @Override
    public void add(String name, int age, String jurusan) {
        var size = mahasiswaImpRepo.get().size() + 1;
        if (size > 5) {
            System.out.println("Database full");
        } else {
            Mahasiswa mahasiswa = new Mahasiswa(name, age, jurusan);
            mahasiswaImpRepo.add(mahasiswa);
            System.out.println("Berhasil tambah data");
        }
    }

    @Override
    public void delete() {
        var size = mahasiswaImpRepo.get().size();
        if (size < 1) {
            System.out.println("List data kosong");
        } else {
            mahasiswaImpRepo.delete();
            System.out.println("Berhasil hapus data");
        }
    }

    @Override
    public void get() {
        var size = mahasiswaImpRepo.get().size();
        if (size < 1) {
            System.out.println("List data mahasiswa kosong");
        } else {
            int i = 1;
            for (var mahasiswa : mahasiswaImpRepo.get()) {
                System.out.println("No : " + i++);
                System.out.println(mahasiswa);
                System.out.println();
            }
        }
    }

    @Override
    public void get(int index) {
        var size = mahasiswaImpRepo.get().size() + 1;
        try {
            if (index > size) {
                System.out.println("index tidak tersedia !");
                return;
            }
            var mahasiswa = mahasiswaImpRepo.get(index);
            System.out.println("\n-----------------------------------\n");
            System.out.println("\t\t=== View By Index ===");
            System.out.println("No : " + (index + 1));
            System.out.println(mahasiswa);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("index tidak valid");
        }
    }
}
