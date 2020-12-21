package com.example.apptemplet.core

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.apptemplet.R
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.utils.domain.Status
import com.example.apptemplet.utils.extensions.hide
import com.example.apptemplet.utils.extensions.show
import com.squareup.picasso.Picasso

/**
 * Created by Furkan on 2019-10-16
 */

@BindingAdapter("app:visibility")
fun setVisibilty(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.show()
    } else {
        view.hide()
    }
}

@BindingAdapter("app:progress")
fun setProgress(view: View, status: Status){
    if(status == Status.LOADING){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}


@BindingAdapter("app:setIcon")
fun setIcon(view: ImageView, iconPath: String?) {
    if (iconPath.isNullOrEmpty())
        return
    Picasso.get().load(iconPath).into(view)
}

@BindingAdapter("app:userName")
fun setUserName(view: TextView, dataItem: DataItem?){
    dataItem?.let {
        view.setText(dataItem.firstName+" "+dataItem.lastName)
    }
}

@BindingAdapter("app:setErrorView")
fun setErrorView(view: View, viewState: BaseViewState?) {
    if (viewState?.shouldShowErrorMessage() == true)
        view.show()
    else
        view.hide()

    view.setOnClickListener { view.hide() }
}

@BindingAdapter("app:setErrorText")
fun setErrorText(view: TextView, viewState: BaseViewState?) {
    if (viewState?.shouldShowErrorMessage() == true)
        view.text = viewState.getErrorMessage()
    else
        view.text = view.context.getString(R.string.unexpected_exception)
}
