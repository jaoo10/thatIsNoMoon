# thatIsNoMoon
Star Wars planet database

The project is stored in Docker hub, to download it, execute the command below:

docker pull jmarcusfaria/that_is_no_moon:1.0.0

And to run the image, the command below:

docker run -p8080:8080 -e MONGODB_PASSWORD='PASSWORD' jmarcusfaria/that_is_no_moon:1.0.0

changing PASSWORD to your password

To add a planet, POST localhost:8080/planet/save
with JSON body:

{
    "name": "name",
    "climate": "climate",
    "terrain": "terrain"
}

To list added planets, GET localhost:8080/planet/

To list the original API planets, GET localhost:8080/planet/readOriginal/

To search by name, GET localhost:8080/planet/byName/{name}
replacing {name} with the name of the planet

To search by ID, GET localhost:8080/planet/byId/{id}
replacing {id} with the ID of the planet

To remove a planet, DELETE localhost:8080/planet/delete/{id}
replacing {id} with the ID of the planet
