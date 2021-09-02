# thatIsNoMoon
Star Wars planet database

Para utilizar, basta fazer o pull do container no docker hub, pelo comando:

docker pull jmarcusfaria/that_is_no_moon:1.0.0

Em seguida, para subir a imagem, basta executar o comando abaixo:

docker run -p8080:8080 -e MONGODB_PASSWORD='PASSWORD' jmarcusfaria/that_is_no_moon:1.0.0

trocando o PASSWORD pela senha fornecida.

Para adicionar um planeta, com nome, clima e terreno, utilize a chamada POST localhost:8080/planet/save
com o JSON abaixo no corpo:

{
    "name": "name",
    "climate": "climate",
    "terrain": "terrain"
}

Para listar os planetas cadastrados, utilize o método GET localhost:8080/planet/

Para listar os planetas da API do Star Wars, utilize o método GET localhost:8080/planet/readOriginal/

Para fazer uma busca por nome, utilize o método GET localhost:8080/planet/byName/{name}
com o nome do planeta no lugar de {name}

Para fazer uma busca por id, utilize o método GET localhost:8080/planet/byId/{id}
com o id do planeta no lugar de {id}

Para remover um planeta, utilize o método DELETE localhost:8080/planet/delete/{id}
com o id do planeta no lugar de {id}