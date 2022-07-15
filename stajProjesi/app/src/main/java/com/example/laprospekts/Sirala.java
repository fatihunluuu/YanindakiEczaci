package com.example.laprospekts;

import java.util.Comparator;
import java.util.HashMap;

public class Sirala implements Comparator<HashMap<String, String>> {
    @Override
    public int compare(final HashMap<String, String> i1, final HashMap<String, String> i2){
        return i1.get("ilac_adi").compareTo(i2.get("ilac_adi"));
    }
}
