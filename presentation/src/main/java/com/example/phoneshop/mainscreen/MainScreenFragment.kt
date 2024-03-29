package com.example.phoneshop.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.phoneshop.ApplicationViewModel
import com.example.phoneshop.databinding.FragmentMainScreenBinding
import com.example.phoneshop.mainscreen.adapters.PhoneListAdapter
import com.example.phoneshop.mainscreen.adapters.PhoneListListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment(), PhoneListListener {

    private lateinit var viewBinding: FragmentMainScreenBinding
    private val adapter = PhoneListAdapter(this)
    private val sharedViewModel by viewModel<ApplicationViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.recyclerListPhones.adapter = adapter

        sharedViewModel.phoneList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        sharedViewModel.getPhoneList()
    }

    override fun phonePicked(phoneID: Int) {
        val action: NavDirections =
            MainScreenFragmentDirections.actionMainScreenFragmentToDetailFragment(phoneID)
        findNavController().navigate(action)
    }
}