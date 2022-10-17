package com.example.locustest.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.locustest.modal.LocusDataModalItem

abstract class MultiAdapterViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(
        position: Int,
        mList: LocusDataModalItem,
        listener: MUltiViewAdapter.OnItemClickListener
    )

    var viewType: Int = -1

}
