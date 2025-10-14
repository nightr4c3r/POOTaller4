package com.example.taller3.Repositories;

import com.example.taller3.Models.Moto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MotoRepository {
    private static final List<Moto> MOTOS = new ArrayList<>();

    private MotoRepository() {
        // no instances
    }

    public static void add(Moto moto) {
        if (moto == null) return;
        MOTOS.add(moto);
    }

    public static List<Moto> getAll() {
        return Collections.unmodifiableList(MOTOS);
    }

    public static int size() {
        return MOTOS.size();
    }

    public static void clear() {
        MOTOS.clear();
    }
}
