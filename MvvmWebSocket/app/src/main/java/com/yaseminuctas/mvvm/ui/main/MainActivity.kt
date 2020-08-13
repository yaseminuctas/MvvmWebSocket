package com.yaseminuctas.mvvm.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaseminuctas.mvvm.R
import com.yaseminuctas.mvvm.data.network.Datum
import com.yaseminuctas.mvvm.databinding.ActivityMainBinding
import com.yaseminuctas.mvvm.ui.DatumAdapter
import com.yaseminuctas.mvvm.util.BaseActivity
import com.yaseminuctas.mvvm.util.Const
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter: DatumAdapter by lazy{
        DatumAdapter(ArrayList<Datum>())
    }
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
    }

    override fun onResume() {
        super.onResume()

        viewModel.start()
    }

    private fun initDataBinding() {
        binding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
            )

        toolbar.title = Const.USER_NAME
        setSupportActionBar(binding.toolbar)

        binding.viewModel = viewModel
        viewModel.getData()
        layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter

        viewModel.datumList.observe(this, Observer { data ->
            adapter.dataList = data
            adapter.notifyDataSetChanged()
        })
        viewModel.mainTitle.observe(this, Observer {
            if (it != null)
                toolbar.title = it
        })
    }
}

