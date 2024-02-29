package com.example.homworks6java.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.homworks6java.ui.PhotosAdapter
import com.example.homworks6java2.R
import com.example.homworks6java2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val photosAdapter = PhotosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        goToInsert()
        subscribeToPhotos()
    }

    private fun goToInsert() {
        binding.fabGoToInsert.setOnClickListener {
            findNavController().navigate(R.id.insertFragment2)
        }
    }

    private fun initialize() {
        binding.rvPhotos.adapter = photosAdapter
    }

    private fun subscribeToPhotos() {
        viewModel.getPhotos().observe(viewLifecycleOwner) { photos ->
            photos?.let {
                photosAdapter.setPhotos(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}