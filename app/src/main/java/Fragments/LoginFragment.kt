package Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.squaremilev1.R
import com.example.squaremilev1.databinding.FragmentLoginBinding
import com.example.squaremilev1.databinding.FragmentWishlistBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var loginAuth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using view binding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Initialize Firebase App (if not already initialized)
        if (FirebaseApp.getApps(requireContext()).isEmpty()) {
            FirebaseApp.initializeApp(requireContext())
        }

        // Initialize FirebaseAuth
        loginAuth = FirebaseAuth.getInstance()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to Register Fragment when the SignUp text is clicked
        binding.txtSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        // Authenticate User when the login button is clicked
        binding.button.setOnClickListener {
            // Initialize SharedPreferences
            sharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)

            // Get user inputs
            val email = binding.editTextText2.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()

            // Check if email and password are not empty
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Retrieve saved user data from SharedPreferences
                val savedEmail = sharedPreferences.getString("emailAddress", "")
                val savedPassword = sharedPreferences.getString("password", "")

                // Check if the user exists in SharedPreferences and log them in
                if (email == savedEmail && password == savedPassword) {
                    // Login successful, navigate to WishlistFragment
                    val wishIntent = Intent(requireActivity(), WishlistFragment::class.java)
                    startActivity(wishIntent)
                    requireActivity().finish() // Close the current activity
                } else {
                    // Attempt FirebaseAuth login if SharedPreferences check fails
                    loginAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Login successful
                                Toast.makeText(requireActivity(), "Login successful", Toast.LENGTH_SHORT).show()
                                val wishIntent = Intent(requireActivity(), WishlistFragment::class.java)
                                startActivity(wishIntent)
                                requireActivity().finish()
                            } else {
                                // Login failed, display error message
                                Toast.makeText(requireActivity(), "Firebase Authentication Failed", Toast.LENGTH_SHORT).show()
                            }
                        }.addOnFailureListener { exception ->
                            Toast.makeText(requireActivity(), "Error: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
            } else {
                // Show error if fields are empty
                Toast.makeText(requireActivity(), "Please enter both Email and Password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}