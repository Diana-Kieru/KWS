# KWS
This website makes it easy for rangers to record wildlife sightings. Wildlife monitoring is essential for keeping track of animal movement patterns, habitat utilization, population demographics, snaring and poaching incidents and breakouts.
#### By  Diana Kieru

## Setup/Installation Requirements
* You need to have Java, IntelliJ, gradle, Junit, Jdk and sdk installed.
* Clone the repository
* Build (gradle build)
* Run the App (maven))
* Navigate to localhost:4567 on your browser
* In PSQL:
```
 CREATE DATABASE wildlife_tracker;
 CREATE TABLE animals (id serial PRIMARY KEY, name varchar, type varchar, health varchar, age varchar);
 CREATE TABLE sightings (id serial PRIMARY KEY, rangername varchar, lastseen TIMESTAMP, location varchar, animalid int);
```
## Known Bugs
There are no known bugs. Incase you experience any errors using this website kindly contact me at dianakieru1@gmail.com
## Technologies Used
* Java
* Spark
* Handlebars
* CSS
* Bootstrap
## Support and contact details
email: dianakieru1@gmail.com

## Live link
[Live Link]( https://deekws.herokuapp.com/ )
### License
[MIT License](./LICENSE)

Copyright (c) [2022] [Diana Kieru]
