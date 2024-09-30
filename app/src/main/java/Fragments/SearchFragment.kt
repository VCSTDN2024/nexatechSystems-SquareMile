package Fragments

import Adapters.CityInfoAdapter
import Models.CityInfoResponse
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.CityInfoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import com.example.squaremilev1.R
import com.google.firebase.FirebaseApp

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var searchBox: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CityInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)

        // Initialize Firebase if not already initialized
        if (FirebaseApp.getApps(requireContext()).isEmpty()) {
            FirebaseApp.initializeApp(requireContext())
        }

        // Initialize UI components
        searchBox = rootView.findViewById(R.id.searchBox)
        val searchButton: Button = rootView.findViewById(R.id.searchButton)
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Set the search button click listener
        searchButton.setOnClickListener {
            val cityName = searchBox.text.toString()
            if (cityName.isNotEmpty()) {
                fetchCityInfo(cityName)
            } else {
                Toast.makeText(context, "Enter a city name", Toast.LENGTH_SHORT).show()
            }
        }

        return rootView
    }

    private fun fetchCityInfo(cityName: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://16.171.23.23/") // Use the correct base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(CityInfoApi::class.java)
        val call = api.getCityInfo(cityName)

        call.enqueue(object : Callback<CityInfoResponse> {
            override fun onResponse(call: Call<CityInfoResponse>, response: Response<CityInfoResponse>) {
                if (response.isSuccessful) {
                    val cityInfo = response.body()
                    if (cityInfo != null) {
                        // Pass data to the adapter and update the RecyclerView
                        adapter = CityInfoAdapter(cityInfo.hotels, cityInfo.restaurants, cityInfo.pois)
                        recyclerView.adapter = adapter
                    } else {
                        Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Error: Response unsuccessful", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CityInfoResponse>, t: Throwable) {
                Log.e("API Error", t.message.toString())
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}