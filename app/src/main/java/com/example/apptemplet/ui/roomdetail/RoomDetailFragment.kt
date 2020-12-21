package com.example.apptemplet.ui.roomdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apptemplet.R
import com.example.apptemplet.core.BaseFragment
import com.example.apptemplet.databinding.FragmentUserDetailBinding
import com.example.apptemplet.ui.detail.UserDetailViewModel

class RoomDetailFragment : BaseFragment<RoomDetailViewModel, FragmentUserDetailBinding>(R.layout.room_detail_fragment, RoomDetailViewModel::class.java) {
    override fun init() {
        super.init()
    }
}