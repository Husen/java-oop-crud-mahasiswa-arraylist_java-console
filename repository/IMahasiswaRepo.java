package com.z.challenge.repository;

import com.z.challenge.model.Mahasiswa;

import java.util.ArrayList;

public interface IMahasiswaRepo {
    void add(Mahasiswa mahasiswa);
    void delete();
    ArrayList<Mahasiswa> get();
    Mahasiswa get(int index);
}
