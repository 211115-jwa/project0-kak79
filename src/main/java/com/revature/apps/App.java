package com.revature.apps;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.util.ArrayList;
import java.util.List;

import com.revature.data.DogPostgres;
import com.revature.exceptions.InvalidEntryException;
import com.revature.models.Dog;
import com.revature.services.DogServImp;
import com.revature.services.DogService;

import io.javalin.Javalin;

public class App 
{
	
	public static DogService ds = new DogServImp();;
	

	public static void main(String[] args) 
	{
		
		
		DogPostgres dp = new DogPostgres();

		Javalin app = Javalin.create().start(8080);
		
		app.routes(() -> 
		{
			path("/dogs", ()-> 
			{
				get(ctx -> 
				{
					
					String dogGender = ctx.queryParam("gender");
					String dogSize = ctx.queryParam("size");
					
					if (dogGender != null && !"".equals(dogGender)) 
					{
						
			
						try 
						{
							
							List<Dog> dog = ds.getAllDogsWhereGenderIs(dogGender);
							
								String dogList = "";
								
								for (Dog dg : dog) 
								{
									dogList += "<p>" + dg + "</p>";
								}
								ctx.result(dogList);
							
								
						} 
						catch (InvalidEntryException e) 
						{
							ctx.result("Dog Gender Must be Either m OR f!! \\n https://http.cat/400.jpg");
						}
						
						
						
					}
					else if (dogSize != null && !"".equals(dogSize))
					{
						if (dogGender != "XS" || dogGender != "S" || dogGender != "M" || dogGender != "L" || dogGender != "XL") 
						{
							ctx.result("Dog Gender Must be Either XS, S, M, L or XL!! \n https://http.cat/400");
						}
						else 
						{
							List<Dog> dog = new ArrayList<>();
							dog = dp.getAllDogsWhereSizeIs(dogSize);
							String dogList = "";
							
							for (Dog dg : dog) 
							{
								dogList += "<p>" + dg + "</p>";
							}
							ctx.result(dogList);
						}
					}
					else 
					{
						List<Dog> dog = new ArrayList<>();
						dog = ds.getAllDogs();
						String dogList = "";
						
						for (Dog dg : dog) 
						{
							dogList += "<p>" + dg + "</p>";
						}
						ctx.result(dogList);
					}
				});
				
				post(ctx -> 
				{
					Dog newDog = ctx.bodyAsClass(Dog.class);
					if (newDog !=null) 
					{
						ds.createADog(newDog);
						ctx.result("https://http.cat/201");
					} 
					else 
					{
						ctx.result("https://http.cat/400");
					}
				});

				path("/{id}", ()-> 
				{
					get(ctx -> 
					{
						try 
						{
							int dogID = Integer.parseInt(ctx.pathParam("id")); 
							Dog dog = ds.getOneById(dogID);
							if (dog != null)
								ctx.json(dog);
							else
								ctx.result("https://http.cat/404");
						} 
						catch (NumberFormatException e) 
						{
							ctx.result("Dog ID must be a numeric value \n https://http.cat/400");
						}

					});
					
					put(ctx -> 
					{
						try 
						{
							int dogID = Integer.parseInt(ctx.pathParam("id"));
							Dog dogToEdit = ctx.bodyAsClass(Dog.class);
							if (dogToEdit != null && dogToEdit.getId() == dogID) 
							{
								dogToEdit = ds.editADog(dogToEdit);
								if (dogToEdit != null)
									ctx.json(dogToEdit);
								else
									ctx.result("https://http.cat/404");
							} 
							else 
							{
								ctx.result("https://http.cat/409");
							}
						}
						catch (NumberFormatException e) 
						{
							ctx.result("Dog ID must be a numeric value \n https://http.cat/400");
						}

					});

				});
			});
		});

	}

}
