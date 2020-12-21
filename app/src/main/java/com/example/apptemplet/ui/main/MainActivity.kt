package com.example.apptemplet.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.apptemplet.R
import com.example.apptemplet.core.BaseActivity
import com.example.apptemplet.databinding.ActivityMainBinding
import com.example.apptemplet.utils.domain.Status
import com.example.apptemplet.utils.extensions.observeWith
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding?.viewModel?.toolbarTitle?.set("Employees")
    }

    override fun getLayoutRes() = R.layout.activity_main

    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }
}