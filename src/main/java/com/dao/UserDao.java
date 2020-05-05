package com.dao;

import org.springframework.stereotype.Repository;

import com.bean.UserBean;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Repository
public class UserDao {


	public void insertUser(UserBean userBean) throws FirebaseAuthException {
		FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
		DatabaseReference databaseReference = firebaseDatabase.getReference();

		FirebaseAuth auth = FirebaseAuth.getInstance();

		System.out.println(userBean.getEmail());
		System.out.println(userBean.getPassword());

		CreateRequest createRequest = new CreateRequest().setEmail(userBean.getEmail())
				.setPassword(userBean.getPassword());

		UserRecord userRecord = auth.createUser(createRequest);

		databaseReference.child("Users").child(userRecord.getUid()).setValue(userBean,
				new DatabaseReference.CompletionListener() {

					@Override
					public void onComplete(DatabaseError error, DatabaseReference ref) {

						System.out.println(error);
						System.out.println(ref);

					}
				});
	}

}
