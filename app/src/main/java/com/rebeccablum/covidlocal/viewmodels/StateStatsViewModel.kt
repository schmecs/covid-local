package com.rebeccablum.covidlocal.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rebeccablum.covidlocal.api.ApiService
import com.rebeccablum.covidlocal.models.CurrentStateInfo
import kotlinx.coroutines.launch

class StateStatsViewModel : ViewModel() {

    val selectedState = MutableLiveData<CurrentStateInfo>()
    val stateList = MutableLiveData<List<CurrentStateInfo>>()

    // TODO: handle injection
    init {
        val api = ApiService.getApiService()

        viewModelScope.launch {
            val newInfo = getCurrentStateInfos(api)
            stateList.postValue(newInfo)
        }
    }

    fun setSelectedState(position: Int) {
        stateList.value?.let {
            if (it.isNotEmpty() && it.size > position) {
                selectedState.value = it[position]
            }
        }
    }

    private suspend fun getCurrentStateInfos(api: ApiService): List<CurrentStateInfo> {
        return api.getCurrentStatesInfo()
    }
}
