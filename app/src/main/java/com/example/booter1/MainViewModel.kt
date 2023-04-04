package com.example.booter1

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    repository: BootsRepository
) : ViewModel() {
    val boots = repository.getAll()
        .asLiveData(viewModelScope.coroutineContext).distinctUntilChanged()
}