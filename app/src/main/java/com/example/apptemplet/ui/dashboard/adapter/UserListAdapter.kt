package com.example.apptemplet.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.apptemplet.R
import com.example.apptemplet.core.BaseAdapter
import com.example.apptemplet.databinding.UserItemBinding
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.domain.model.UserResponse
import org.jetbrains.annotations.NotNull

class UserListAdapter(private val callback: (DataItem, View, Int)-> Unit) : BaseAdapter<DataItem>(diffCallback) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewModel = UserItemViewModel()
        mBinding.viewModel = viewModel
        mBinding.rootView.setOnClickListener { view ->
            mBinding.viewModel?.item?.get()?.let {dataItem->
                passClickEnvet(dataItem, view, mBinding)
            }
        }

        mBinding.imgEdit.setOnClickListener { view ->
            mBinding.viewModel?.item?.get()?.let { dataItem ->
                passClickEnvet(dataItem, view, mBinding)
            }
        }

        mBinding.imgDelete.setOnClickListener { view ->
            mBinding.viewModel?.item?.get()?.let { dataItem ->
                passClickEnvet(dataItem, view, mBinding)
            }
        }

        return mBinding
    }

    private fun passClickEnvet(
        dataItem: DataItem,
        view: View,
        mBinding: UserItemBinding
    ) {
        callback.invoke(dataItem, view, mBinding.root.getTag(R.string.position) as Int)
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as UserItemBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean = oldItem == newItem

}
