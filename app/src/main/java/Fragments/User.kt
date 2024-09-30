package Fragments

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class User {
    var userID: String
    var userEmail: String
    var userPassword: String
    private lateinit var firebaseAuth: FirebaseAuth

    // Constructor
    constructor(ID: String, Email: String, Password: String) {
        this.userID = ID
        this.userEmail = Email
        this.userPassword = Password

        // Initialize FirebaseAuth instance
        firebaseAuth = FirebaseAuth.getInstance()
    }

    /****** Register User and Insert Data into Firebase Authentication ******/
    fun registerUser(callback: (Boolean, String?) -> Unit) {
        // Register the user with Firebase Authentication
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // User registered successfully in Firebase Authentication
                    val currentUser: FirebaseUser? = firebaseAuth.currentUser
                    currentUser?.let {
                        // Get the current user ID from Firebase Authentication
                        val userID = it.uid
                        callback(true, userID) // Return success with userID
                    }
                } else {
                    // User registration failed in Firebase Authentication
                    callback(false, task.exception?.message)
                }
            }
    }
}