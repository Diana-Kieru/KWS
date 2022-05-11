package org.example.module;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class Animal extends Wildlife implements DatabaseManagement{
    public static final String ANIMAL_TYPE = "animal";

    public Animal(String name){
        this.name = name;
        this.type = ANIMAL_TYPE;
        if (name.isEmpty()){
            throw new IllegalArgumentException("Please enter the animal's name.");
        }
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM animals WHERE type='animal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }

    public static Animal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

    public static List<Object> getAnimals() {
        List<Object> allAnimals = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlFire = "SELECT * FROM animals WHERE type='animal';";
            List<Animal> animals = con.createQuery(sqlFire)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
            allAnimals.addAll(animals);

            String sqlWater = "SELECT * FROM animals WHERE type='endangered-animal';";
            List<EndangeredAnimal> endangeredAnimals = con.createQuery(sqlWater)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
            allAnimals.addAll(endangeredAnimals);
        }

        return allAnimals;
    }

}

