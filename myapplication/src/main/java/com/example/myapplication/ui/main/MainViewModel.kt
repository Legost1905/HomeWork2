package com.example.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView.State
import com.example.myapplication.businesslayer.CatProvider
import com.example.myapplication.datalayer.IAccessor
import com.example.myapplication.objects.Cat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val state:MutableLiveData<State> = MutableLiveData()

    val scope = CoroutineScope(Dispatchers.IO)

    private val accessor = IAccessor.create()
    private val provider = CatProvider(accessor)
    suspend fun getCats() = provider.getCats(0, 100)

    fun load(){
        state.postValue(State.loading)

        scope.launch {
            try{
                val l = getCats()
                state.postValue(State.Success(l))
            }catch (error:Throwable){
                state.postValue(State.Error(error))
            }
        }
    }

    sealed class State{
        object loading:State()
        class Success(val data: List<Cat>):State()
        class Error(val throwable: Throwable):State()
    }

}