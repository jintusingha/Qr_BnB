package com.jintu.qr_bnb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jintu.qr_bnb.presentation.model.MainResponseDto
import com.jintu.qr_bnb.domain.mappers.toViewModelModel
import com.jintu.qr_bnb.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val getCategoriesUseCase: GetCategoriesUseCase): ViewModel(){

    private val _mainScreenData= MutableLiveData<MainResponseDto>()
    val mainScreenData: LiveData<MainResponseDto> =_mainScreenData

    init {

        loadData()
    }

    private fun loadData() {

        viewModelScope.launch {
            try {

                val domainModel = getCategoriesUseCase()


                val viewModelModel = domainModel.toViewModelModel()
                _mainScreenData.value = viewModelModel

            } catch (e: Exception) {

                println("Error loading data: $e")
            }
        }
    }
}