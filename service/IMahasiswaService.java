package com.z.challenge.service;

public interface IMahasiswaService {
    void add(String name, int age, String jurusan);
    void delete();
    void get();
    void get(int index);
}
