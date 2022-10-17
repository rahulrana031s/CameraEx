package com.example.locustest.viewHolders

import android.view.View
import android.widget.CompoundButton
import com.example.locustest.utils.Viewtypes
import com.example.locustest.adapters.MUltiViewAdapter
import com.example.locustest.adapters.MultiAdapterViewHolder
import com.example.locustest.databinding.CommentItemBinding
import com.example.locustest.modal.LocusDataModalItem

class CommentItemViewHolder(val binding: CommentItemBinding) : MultiAdapterViewHolder(binding.root) {
    init {
        viewType = Viewtypes.COMMENT
    }

    override fun bind(
        position: Int,
        mList: LocusDataModalItem,
        listener: MUltiViewAdapter.OnItemClickListener
    ) {
        binding.textTitleComment.text = mList.title
        binding.switchComment.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.textAreaComment.visibility = View.VISIBLE

            }else{
                binding.textAreaComment.visibility = View.GONE
            }
        })
    }

}
