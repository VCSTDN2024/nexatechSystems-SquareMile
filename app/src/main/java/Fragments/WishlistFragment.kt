package Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.squaremilev1.R
import com.example.squaremilev1.databinding.FragmentWishlistBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    private lateinit var firebaseAuth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize Firebase App
        FirebaseApp.initializeApp(requireContext())
        binding.txtLogin.setOnClickListener{
            findNavController().navigate(R.id.action_wishlistFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}