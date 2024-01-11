package com.example.ejournal.tools

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

fun ImageView.setImage(img: String?) {
    Picasso.get()
        .load(img)
        .into(this)
}

fun Fragment.showToast(msg: String) {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun View.viewVisibility(visibility: Boolean) {
    if (visibility) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}