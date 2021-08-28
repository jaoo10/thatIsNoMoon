package com.jaoo10.thatIsNoMoon;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThatIsNoMoonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThatIsNoMoonApplication.class, args);

		//ConnectionString connectionString = new ConnectionString("mongodb+srv://dbclient:starkiller@cluster0.xfpfo.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		//MongoClientSettings settings = MongoClientSettings.builder()
		//		.applyConnectionString(connectionString)
		//		.build();
		//MongoClient mongoClient = MongoClients.create(settings);
		//mongoClient.startSession();
		//MongoDatabase database = mongoClient.getDatabase("dbSWUniverse");
	}

}
