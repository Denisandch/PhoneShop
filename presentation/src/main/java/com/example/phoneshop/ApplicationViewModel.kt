package com.example.phoneshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.PhoneDescriptionRepository
import com.example.domain.usecase.PhoneListRepository
import com.example.phoneshop.detailscreen.DescriptionData
import com.example.phoneshop.mainscreen.MainScreenData
import kotlinx.coroutines.launch

class ApplicationViewModel(
    private val phoneListRepository: PhoneListRepository,
    private val descriptionRepository: PhoneDescriptionRepository
) : ViewModel(), DescriptionData, MainScreenData {

    private val _phoneDescription = MutableLiveData<PhoneDescription>()
    val phoneDescription: LiveData<PhoneDescription> = _phoneDescription

    private val _phoneList = MutableLiveData<List<Phone>>()
    val phoneList: LiveData<List<Phone>> = _phoneList

    override fun getDescription(phoneID: Int) {
        viewModelScope.launch {
            _phoneDescription.value = descriptionRepository.getData(phoneID)
        }
    }

    override fun saveDescription(description: PhoneDescription) {
        viewModelScope.launch {
            descriptionRepository.saveData(description)
        }
    }

    override fun getPhoneList() {
        viewModelScope.launch {
            _phoneList.value = phoneListRepository.getData()
        }
    }

    override fun savePhoneList(list: List<Phone>) {
        viewModelScope.launch {
            phoneListRepository.saveData(list)
        }
    }
}