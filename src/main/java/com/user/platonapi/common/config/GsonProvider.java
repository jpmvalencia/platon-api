package com.user.platonapi.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.user.platonapi.common.adapters.InstantAdapter;

import java.time.Instant;

public class GsonProvider {
    public static Gson createGson() {
        return new GsonBuilder().registerTypeAdapter(Instant.class, new InstantAdapter()).create();
    }
}
