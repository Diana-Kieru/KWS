package org.example.module;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class AllSightings {
    private int animalId;
    private String location;
    private String rangerName;
    private Timestamp lastSeen;
    public String name;
    public int id;
    public String health;
    public String age;
    public String type;

    public AllSightings(int animalId, String location, String rangerName, Timestamp lastSeen, String name, int id, String health, String age, String type) {
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
        this.lastSeen = lastSeen;
        this.name = name;
        this.id = id;
        this.health = health;
        this.age = age;
        this.type = type;


    }
    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setLastSeen(Timestamp lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<AllSightings> getAll(){
        String sql = "SELECT * FROM animals INNER JOIN sightings ON sightings.animalId = animals.id ORDER BY lastSeen";

        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(AllSightings.class);
        }
    }
}


