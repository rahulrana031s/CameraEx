package com.example.locustest.viewHolders

import com.example.locustest.adapters.MUltiViewAdapter
import com.example.locustest.adapters.MultiAdapterViewHolder
import com.example.locustest.databinding.EmptyViewHolderBinding
import com.example.locustest.modal.LocusDataModalItem

class EmptyViewHolder(binding: EmptyViewHolderBinding) : MultiAdapterViewHolder(binding.root) {
    override fun bind(
        position: Int,
        mList: LocusDataModalItem,
        listener: MUltiViewAdapter.OnItemClickListener
    ) {
    }

}
