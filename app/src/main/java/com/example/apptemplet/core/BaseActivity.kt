package com.example.apptemplet.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.user_item.*
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(private val mViewModelClass: Class<VM>) :
    DaggerAppCompatActivity() , BaseView{

    @Inject
    internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    val viewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory).get(mViewModelClass)
    }

    /**
     * If you want to inject Dependency Injection
     * on your activity, you can override this.
     */
    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewModel(viewModel)
        onInject()
        setupBindingLifecycleOwner()
    }

    /**
     *
     *  You need override this method.
     *  And you need to set viewModel to binding: binding.viewModel = viewModel
     *
     */

    abstract fun initViewModel(viewModel: VM)

    private fun setupBindingLifecycleOwner() {
        binding.lifecycleOwner = this
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showMessage(message: String) {
        showSnackBar(message)
    }

    override fun showError(message: String) {
        showSnackBar(message)
    }

    private fun showSnackBar(message: String) {
        val snack = Snackbar.make(rootView, message, Snackbar.LENGTH_INDEFINITE)
        /*  snack.setAction("Click Me") {
              // TODO when you tap on "Click Me"
          }*/
        snack.show()
    }
}
