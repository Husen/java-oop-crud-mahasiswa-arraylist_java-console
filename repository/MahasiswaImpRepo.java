package com.z.challenge.repository;

import com.z.challenge.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaImpRepo implements IMahasiswaRepo{
    private ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
    @Override
    public void add(Mahasiswa mahasiswa) {
        this.mahasiswas.add(mahasiswa);
    }

    @Override
    public void delete() {
        this.mahasiswas.remove(this.mahasiswas.size() - 1);
    }

    @Override
    public ArrayList<Mahasiswa> get() {
        return this.mahasiswas;
    }

    @Override
    public Mahasiswa get(int index) {
        return this.mahasiswas.get(index);
    }
}
