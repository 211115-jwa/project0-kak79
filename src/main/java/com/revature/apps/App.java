package com.revature.apps;

import com.revature.services.DogService;

import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		
		DogService ds = new DogService();

		Javalin app = Javalin.create().start(8080);
		
		app.get("/dog", ctx -> {
			ds.getAllDogs();
		});

	}

}
