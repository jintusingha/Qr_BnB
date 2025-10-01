package com.jintu.qr_bnb.presentation.viewmodel

import com.jintu.qr_bnb.domain.usecase.GetMenuScreenUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jintu.qr_bnb.domain.mappers.toUiState
import com.jintu.qr_bnb.presentation.model.MenuScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject





@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getMenuScreenUseCase: GetMenuScreenUseCase
) : ViewModel() {

    private val _menuState = MutableStateFlow(
        MenuScreenUiState(tabNames = emptyList(), courseList = emptyList())
    )
    val menuState: StateFlow<MenuScreenUiState> = _menuState


    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex: StateFlow<Int> = _selectedTabIndex


    init {
        loadMenuData()
    }

    private fun loadMenuData() {
        viewModelScope.launch {
            val domainData = getMenuScreenUseCase()
            val uiState = domainData.toUiState()
            _menuState.value = uiState
        }
    }


    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun onTabSelected(index: Int) {
        _selectedTabIndex.value = index
    }
}
