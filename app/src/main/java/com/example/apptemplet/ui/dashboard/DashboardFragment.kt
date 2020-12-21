package com.example.apptemplet.ui.dashboard

import android.app.Activity
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptemplet.BR
import com.example.apptemplet.R
import com.example.apptemplet.core.BaseFragment
import com.example.apptemplet.databinding.FragmentDashboardBinding
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.ui.dashboard.adapter.UserListAdapter
import com.example.apptemplet.utils.dialogYesOrNo
import com.example.apptemplet.utils.domain.Status
import com.example.apptemplet.utils.extensions.observeWith


class DashboardFragment : BaseFragment<DashboardFragmentViewModel, FragmentDashboardBinding>(
    R.layout.fragment_dashboard,
    DashboardFragmentViewModel::class.java
) {
    override fun init() {
        super.init()
        initUserListAdapter()
        binding.viewModel?.isLoading?.set(true)
        binding.viewModel?.getUserDataViewState()?.observeWith(viewLifecycleOwner) {
            with(binding) {
                viewState = it
                binding.viewModel?.isLoading?.set(false)
//                notifyPropertyChanged(BR.viewModel);
                it?.data?.let { userList -> submitDataToAdapter(userList) }
                /*  if(viewState.status.){

                  }else if(viewState.status==Status.ERROR){

                  }else{
                      //show loader
                  }*/
            }
        }
    }

    private fun submitDataToAdapter(list: List<DataItem>) {
        list?.let {
            if (it != null)
                (binding?.recyclerUser?.adapter as UserListAdapter).submitList(list)
        }
    }

    private fun initUserListAdapter() {
        val adapter = UserListAdapter { item, view, position ->
            when (view.id) {
                R.id.imgDelete -> {
                    Log.d("Delete Item Clicked:", item.firstName + " " + item.lastName)
                    activity?.let {
                        dialogYesOrNo(
                            it,
                            "Delete!",
                            "Are you sure to delete this record?",
                            DialogInterface.OnClickListener { dialog, which ->
                                binding?.viewModel?.deleteRecord(item)
                            })
                    }
                }

                R.id.img_edit -> {
                    Log.d("Edit Item Clicked:", item.firstName + " " + item.lastName)
//                    val action = DashboardFragmentDirection.
                    val action = DashboardFragmentDirections.dashboardToDetailFragment(item)
                    findNavController().navigate(action)
                }
            }
//            Log.d("Item Clicked:", item.firstName + " " + item.lastName)
        }
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val mDividerItemDecoration = DividerItemDecoration(
            binding.recyclerUser.getContext(),
            DividerItemDecoration.VERTICAL
        )
// or DividerItemDecoration.HORIZONTALL
        // or DividerItemDecoration.HORIZONTALL
        activity?.getDrawable(R.drawable.lineshape)?.let { mDividerItemDecoration.setDrawable(it) }
        binding.recyclerUser.addItemDecoration(mDividerItemDecoration)
    }
}