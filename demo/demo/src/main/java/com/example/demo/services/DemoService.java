package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    private List<String> names = new ArrayList<>();


    public DemoService(){
        names.add("Sanjana");
    }

    public List<String> getNames() {
        return names;
    }

    public void addName(String name) {
        names.add(name);
    }

    public void updateName(int index, String name) {
        if (index >= 0 && index < names.size()) {
            names.set(index, name);
        }
    }

    public void deleteName(int index) {
        if (index >= 0 && index < names.size()) {
            names.remove(index);
        }
    }
}
