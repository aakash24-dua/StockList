package com.et.stocklist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.et.stocklist.domain.entity.Searchresult
import com.et.stocklist.utils.NetworkService
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewmodel(val networkService: NetworkService) : ViewModel() {


    var publishObject = PublishSubject.create<ArrayList<Searchresult>>()
    private suspend fun getList(): ArrayList<Searchresult>? {
        return try {
            val data =
                withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                    networkService.getList()
                }
            data.searchresult as ArrayList<Searchresult>
        } catch (e: Exception) {
            ArrayList()
        }
    }

    fun getStockList() {
        viewModelScope.launch {
            val it = getList()
            it?.let {
                updateData(it)
            }
        }
    }

    private fun updateData(it: ArrayList<Searchresult>) {
        publishObject.onNext(it)
    }

    fun sortListBy(selectedSort: Sort, response: ArrayList<Searchresult>): ArrayList<Searchresult> {
        when (selectedSort) {
            Sort.CURRENT_HIGH -> response.sortByDescending { it.current?.toDouble() }
            Sort.CURRENT_LOW -> response.sortBy { it.current?.toDouble() }
            Sort.CHANGE_HIGH -> response.sortByDescending { it.absolutechange?.toDouble() }
            Sort.CHANGE_LOW -> response.sortBy { it.absolutechange?.toDouble() }
        }
        return response
    }

    override fun onCleared() {
        super.onCleared()
    }

}