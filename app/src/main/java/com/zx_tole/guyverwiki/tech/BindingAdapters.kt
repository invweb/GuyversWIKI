package com.zx_tole.guyverwiki.tech

import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


@BindingAdapter("imageUrl", requireAll = false)
fun TextView.bindSrcUrl(
    url: String
) {
    Glide.with(context).load(url).apply(RequestOptions().fitCenter()).into(
        object : CustomTarget<Drawable>(500,500){
            override fun onLoadCleared(placeholder: Drawable?) {
                setCompoundDrawablesRelativeWithIntrinsicBounds(
                    placeholder,
                    null,
                    null,
                    null
                )
            }

            override fun onResourceReady(
                resource: Drawable,
                transition: Transition<in Drawable>?
            ) {
                setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    null,
                    resource
                )
            }
        }
    )
}