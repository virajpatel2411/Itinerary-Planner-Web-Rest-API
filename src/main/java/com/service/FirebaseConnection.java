package com.service;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseConnection {
	
	@PostConstruct
	public void connect() throws IOException {

		FileInputStream serviceAccount = new FileInputStream("itinerary-planner.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://itinerary-planner-d6bf7.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

	}
}
