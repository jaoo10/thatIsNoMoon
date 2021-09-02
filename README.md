# thatIsNoMoon
Star Wars planet database

Para utilizar, basta fazer o pull do container no docker hub, pelo comando:

docker pull jmarcusfaria/that_is_no_moon:1.0.0

Em seguida, para subir a imagem, basta executar o comando abaixo:

docker run -p8080:8080 -e MONGODB_PASSWORD='PASSWORD' jmarcusfaria/that_is_no_moon:1.0.0

trocando o PASSWORD pela senha fornecida.