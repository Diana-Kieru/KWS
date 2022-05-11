package org.example;

import org.example.module.AllSightings;
import org.example.module.Animal;
import org.example.module.EndangeredAnimal;
import org.example.module.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
//import static spark.Spark.get;

public class Main {static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567;
}
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.getAnimals());
            return new ModelAndView(model, "animals-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int animalid = Integer.parseInt(request.queryParams("animal"));
            String animalName = request.queryParams("animalname");

            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String type = request.queryParams("type");

            if(type.equals("animal")){
                Animal animal = new Animal(animalName);
                animal.save();
                Sightings newSighting = new Sightings(animalid,location,rangerName);
                newSighting.save();
            } else if(type.equals("endangered")){
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName,health,age);
                endangeredAnimal.save();
                Sightings anotherSighting = new Sightings(animalid, location, rangerName);
                anotherSighting.save();
            };
            response.redirect("/sightings");
            return null;


        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<AllSightings> allSightings = AllSightings.getAll();
            for (AllSightings animalsightings:allSightings){
                animalsightings.setName("samuel");


            }
            model.put("sightings", AllSightings.getAll());
            model.put("animal", EndangeredAnimal.all());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
