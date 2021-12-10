package com.revature.apps;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.invalidEntryException;
import com.revature.models.Dog;
import com.revature.services.DogService;

import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		
		DogService ds = new DogService();

		Javalin app = Javalin.create().start(8080);
		
		app.routes(() -> {
			path("/dogs", ()-> {
				get(ctx -> {
					
					
					String dogGender = ctx.queryParam("gender");
					String dogSize = ctx.queryParam("size");
					
					if (dogGender != null && !"".equals(dogGender)) 
					{
						try  
						{
							List<Dog> dog = new ArrayList<>();
							dog = ds.getAllDogsWhereGenderIs(dogGender);
							String sDg = "";
							
							for (Dog dg : dog) 
							{
								sDg += "<p>" + dg + "</p>";
							}
							ctx.result(sDg);
						}
						catch (invalidEntryException i)
						{	
							i.printStackTrace();
						}
						
					}
					else if (dogSize != null && !"".equals(dogSize))
					{
						List<Dog> dog = new ArrayList<>();
						dog = ds.getAllDogsWhereSizeIs(dogSize);
						String sDg = "";
						
						for (Dog dg : dog) 
						{
							sDg += "<p>" + dg + "</p>";
						}
						ctx.result(sDg);						
					}
					else 
					{
						List<Dog> dog = new ArrayList<>();
						dog = ds.getAllDogs();
						String sDg = "";
						
						for (Dog dg : dog) {
							sDg += "<p>" + dg + "</p>";
						}
						ctx.result(sDg);
					}
				});
				
				post(ctx -> {
					ctx.result("POST to /dog successful");
				});

				path("/{id}", ()-> {
					get(ctx -> {
						String id = ctx.pathParam("id");
						ctx.result("GET to /dog/"+ id +" successful");
					});
					
					put(ctx -> {
						String id = ctx.pathParam("id");
						ctx.result("PUT to /dog/"+ id +" successful");
					});

				});
			});
		});

	}

}
