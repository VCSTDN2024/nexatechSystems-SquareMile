package Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.squaremilev1.R
import com.example.squaremilev1.databinding.FragmentLoginBinding
import com.example.squaremilev1.databinding.FragmentRegisterBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    // Firebase Authentication reference
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using view binding
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Initialize Firebase App if not already initialized
        if (FirebaseApp.getApps(requireContext()).isEmpty()) {
            FirebaseApp.initializeApp(requireContext())
        }

        // Initialize FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)

        // Navigate back to LoginFragment when clicking on "Back to Login" text
        binding.txtBackLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        // Handle registration button click
        binding.button2.setOnClickListener {
            val name = binding.editTextText.text.toString().trim()
            val emailAddress = binding.editTextText3.text.toString().trim()
            val password = binding.textView5.text.toString().trim()

            if (name.isEmpty() || emailAddress.isEmpty() || password.isEmpty()) {
                // Display error message
                Toast.makeText(requireActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // All fields are filled, proceed with registration

                // Save the user data to SharedPreferences
                saveUserData(name, emailAddress, password)

                // Register the user with Firebase Authentication
                firebaseAuth.createUserWithEmailAndPassword(emailAddress, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registration successful, show success message
                        Toast.makeText(requireActivity(), "Registration successful", Toast.LENGTH_SHORT).show()

                        // Navigate to login screen
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    } else {
                        // Registration failed, show error message
                        Toast.makeText(requireActivity(), "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    // Save user data to SharedPreferences
    private fun saveUserData(name: String, emailAddress: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("emailAddress", emailAddress)
        editor.putString("password", password)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}