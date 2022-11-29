package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> ()

    private val catAdapter = CatAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter=catAdapter
        }

        val stub = view.findViewById<TextView>(R.id.stub)
        val retryButton = view.findViewById<Button>(R.id.retry_button)
        val retryLayout = view.findViewById<LinearLayout>(R.id.retry_layout)
        val progress = view.findViewById<ProgressBar>(R.id.progress)

        viewModel.state.observe(viewLifecycleOwner){
            when(it){
                is MainViewModel.State.loading -> {
                    progress.isVisible = true
                    retryLayout.isVisible = false
                }
                is MainViewModel.State.Success->{
                    catAdapter.submitList(it.data)
                    retryLayout.isVisible = false
                    progress.isVisible = false
                }
                is MainViewModel.State.Error ->{
                    retryLayout.isVisible = true
                    progress.isVisible = true

                    stub.text="Ошибка: ${it.throwable}"
                    retryButton.setOnClickListener{
                        viewModel.load()
                    }
                }
            }
        }

        viewModel.load()


//        viewLifecycleOwner.lifecycleScope.launch {
//            stub.isVisible = true
//            stub.text="Загрузка..."
////            delay(1000)
//            stub.setOnClickListener(null)
//
//            try {
//                val list = withContext(Dispatchers.IO){viewModel.getCats()}
//                catAdapter.submitList(list)
//
//                stub.isVisible = false
//            }catch (error:Throwable){
//                stub.isVisible = true
//                stub.text="Ошибка: ${error.message}"
//                error.printStackTrace()
//                stub.setOnClickListener{
//                    //retry
//                }
//            }
//
//
//        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}