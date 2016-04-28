package com.quelmarabout.common;

import com.google.gson.Gson;

public enum GsonSingleton {
    INSTANCE;

    public static Gson getInstance() {
	return INSTANCE.getGson();
    }

    private Gson gson;

    private GsonSingleton() {
	gson = new Gson();
    }

    private Gson getGson() {
	return gson;
    }
}
