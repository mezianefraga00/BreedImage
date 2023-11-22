package com.example.bathandbodyandbeyondinterview.breed_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bathandbodyandbeyondinterview.R
import com.example.bathandbodyandbeyondinterview.dataClasses.Categories
import com.example.bathandbodyandbeyondinterview.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // init Adapter
        val recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        val adapter = SearchAdapter() { it: String ->
            binding.search.setQuery("",false)
            binding.search.clearFocus()
            findNavController().navigate(R.id.action_searchFragment_to_imageFragment, bundleOf(Pair("name",it)))

        }
        recyclerview.adapter = adapter
        adapter.updateData(Categories.Supplier.category)

        //close drop menu onClick close
        binding.search.setOnCloseListener {
            binding.recyclerView.visibility = View.GONE
            false
        }
        // handle search querry
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                var newdata = Categories.Supplier.category.filter {
                    it == query
                }
                adapter.updateData(newdata)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                binding.recyclerView.visibility = View.VISIBLE
                if (newText.isBlank()) binding.recyclerView.visibility = View.GONE
                var breedList: List<String> =
                    Categories.Supplier.category.filter { s -> s.toLowerCase().contains(newText.toLowerCase()) }
                adapter.updateData(breedList)
                return false
            }

        })
    }
}