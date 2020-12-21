package com.example.apptemplet.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.user_item.*

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding>(@LayoutRes val layout: Int, viewModelClass: Class<VM>) : Fragment() , BaseView{

    open lateinit var binding: DB
    lateinit var dataBindingComponent: DataBindingComponent
    private fun init(inflater: LayoutInflater, container: ViewGroup) {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        viewModel?.attachView(this)
    }

    open fun init() {}

    private val viewModel by lazy {
        (activity as? BaseActivity<*, *>)?.viewModelProviderFactory?.let { ViewModelProvider(this, it).get(viewModelClass) }
    }

    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(activity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init(inflater, container!!)
        init()
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    open fun refresh() {}

    open fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }

    override fun hideLoading() {
    }

    override fun showLoading() {
    }

    override fun showMessage(message: String) {
        showSnackBar(message)
    }

    override fun showError(message: String) {
        showSnackBar(message)
    }

    private fun showSnackBar(message: String) {
        val snack = activity?.currentFocus?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT) }
      /*  snack.setAction("Click Me") {
            // TODO when you tap on "Click Me"
        }*/
//        Toast.makeText(activity,)
        snack?.show()
    }
}
