package com.example.locustest.viewHolders

import com.example.locustest.utils.Viewtypes
import com.example.locustest.adapters.MUltiViewAdapter
import com.example.locustest.adapters.MultiAdapterViewHolder
import com.example.locustest.databinding.SingleChoiceItemBinding
import com.example.locustest.modal.LocusDataModalItem

class SingleChoiceViewHolder(val binding: SingleChoiceItemBinding) : MultiAdapterViewHolder(binding.root) {
    init {
        viewType = Viewtypes.SINGLE_CHOICE
    }

    override fun bind(
        position: Int,
        mList: LocusDataModalItem,
        listener: MUltiViewAdapter.OnItemClickListener
    ) {
        binding.txtSingle.text = mList.title
    }
}
