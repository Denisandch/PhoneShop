package com.example.phoneshop.detailscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.phoneshop.ApplicationViewModel
import com.example.phoneshop.R
import com.example.phoneshop.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {


    private lateinit var viewBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private val sharedViewModel by viewModel<ApplicationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.phoneDescription.observe(viewLifecycleOwner) {
            viewBinding.apply {
                phoneName.text = it.name
                phoneDescription.text = it.description
                phonePrice.text = it.price.toString()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(requireContext(), "${args.phoneID}", Toast.LENGTH_SHORT).show()
        sharedViewModel.getDescription(args.phoneID - 1)
    }


}