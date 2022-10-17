package com.example.locustest.viewHolders

import android.net.Uri
import com.example.locustest.utils.Viewtypes
import com.example.locustest.adapters.MUltiViewAdapter
import com.example.locustest.adapters.MultiAdapterViewHolder
import com.example.locustest.databinding.PhotoItemBinding
import com.example.locustest.modal.LocusDataModalItem

class PhotoItemViewHolder(val binding: PhotoItemBinding) : MultiAdapterViewHolder(binding.root) {
    init {
        viewType = Viewtypes.PHOTO
    }

    override fun bind(
        position: Int,
        mList: LocusDataModalItem,
        listener: MUltiViewAdapter.OnItemClickListener
    ) {
        binding.imgMain.setOnClickListener {
            listener.onItemClick("PHOTO",position)
        }
        binding.imgClose.setOnClickListener {
            listener.onItemClick("Remove",position)
        }
        if(mList.uri!= null){
            binding.imgMain.setImageURI(Uri.parse(mList.uri))
        }
        binding.txtTitle.text = mList.title

        }
}
