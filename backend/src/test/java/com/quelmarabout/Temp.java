package com.quelmarabout;

import com.google.gson.Gson;
import com.quelmarabout.common.GsonSingleton;
import com.quelmarabout.dto.Query;

public class Temp {

    public static void main(String[] args) {
	Gson instance = GsonSingleton.getInstance();
	Query test = new Query();
	int[] services = { 1, 4 };
	test.setServiceIds(services);

	String json = instance.toJson(test);

	System.out.println(json);
    }

}
