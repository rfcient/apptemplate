package com.example.apptemplet.ui.detail

import android.os.Bundle
import android.os.TokenWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.apptemplet.R
import com.example.apptemplet.core.BaseFragment
import com.example.apptemplet.databinding.FragmentUserDetailBinding
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.utils.domain.Status
import com.example.apptemplet.utils.extensions.observeWith


class UserDetailFragment : BaseFragment<UserDetailViewModel, FragmentUserDetailBinding>
    (R.layout.fragment_user_detail,
    UserDetailViewModel::class.java), View.OnClickListener {

    private var userId:Int = 1;
    lateinit var dataItem:DataItem
    val args: UserDetailFragmentArgs by navArgs()

    override fun init() {
        super.init()
        binding.viewModel?.isLoading?.set(true)
        dataItem =  args.user
        binding.btnSubmit.setOnClickListener(this)

      /*  with(binding){
            viewState = UserDetailViewState(Status.SUCCESS,"", dataItem)
        }*/
        dataItem?.id?.let {
            binding.viewModel?.getUserDetailViewState(it)?.observeWith(viewLifecycleOwner){
                with(binding){
                    it?.let {
                        it.data?.let {
                            dataItem = it
                        }
                        viewState = it
                    }
                    binding.viewModel?.isLoading?.set(false)
                }
            }
        }
    }

    override fun onClick(view: View) {

        when(view.id){
            R.id.btnSubmit -> {
                if(binding.edtName.text.toString().isEmpty()){
                    Toast.makeText(activity, "Name is required", Toast.LENGTH_SHORT).show()
                    return
                }

                if(binding.edtMail.text.toString().isEmpty()){
                    Toast.makeText(activity,"Email is required", Toast.LENGTH_SHORT).show()
                    return
                }

                val fullName = binding.edtName.text.toString()
                val nameArray = fullName.split(" ")

                val fName = nameArray.get(0)
                val lName = nameArray.get(1)
                val email = binding.edtMail.text.toString()
                dataItem.email = email
                dataItem.firstName = fName
                dataItem.lastName = lName
                binding.viewModel?.updateUserDetails(dataItem)
            }
        }
    }
}