package com.example.bathandbodyandbeyondinterview.breed_search_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bathandbodyandbeyondinterview.databinding.FragmentDogImagesBinding
import com.example.bathandbodyandbeyondinterview.retrofit.ApiHelper
import com.example.bathandbodyandbeyondinterview.retrofit.RetrofitBuilder

class DogImagesFragment : Fragment() {
    private var _binding: FragmentDogImagesBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: DogImagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogImagesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init View Model
        viewModel = ViewModelProvider(
            this@DogImagesFragment,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        )[DogImagesViewModel::class.java]

        //init Adapter
        val recyclerview = binding.recyclerViewImage
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        val adapter = DogImagesAdapter()
        recyclerview.adapter = adapter

        val bundle = arguments
        val message = bundle!!.getString("name")
        if (message != null) {
            viewModel.displayBreedImage(message)
        }
        viewModel.listImageUrls.observe(this.viewLifecycleOwner) {

            adapter.displayImage(it)
            binding.progressBar.visibility = View.GONE

        }
        viewModel.error.observe(viewLifecycleOwner) { imageNotFound ->
            Toast.makeText(this.context, imageNotFound, Toast.LENGTH_SHORT).show()
        }
        binding.btnHome.setOnClickListener {
            findNavController().navigateUp()

        }
    }

}