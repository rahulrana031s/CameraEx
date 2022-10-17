package com.example.locustest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.locustest.R
import com.example.locustest.utils.Viewtypes
import com.example.locustest.databinding.CommentItemBinding
import com.example.locustest.databinding.EmptyViewHolderBinding
import com.example.locustest.databinding.PhotoItemBinding
import com.example.locustest.databinding.SingleChoiceItemBinding
import com.example.locustest.modal.LocusDataModalItem
import com.example.locustest.viewHolders.CommentItemViewHolder
import com.example.locustest.viewHolders.EmptyViewHolder
import com.example.locustest.viewHolders.PhotoItemViewHolder
import com.example.locustest.viewHolders.SingleChoiceViewHolder

class MUltiViewAdapter(

    val context: Context,
    val listener: OnItemClickListener,
    private val mList: ArrayList<LocusDataModalItem>): RecyclerView.Adapter<MultiAdapterViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    interface OnItemClickListener{
        fun onItemClick(type: String, position:Int)
    }
    private val viewTypes = arrayOf(
        Viewtypes.PHOTO,
        Viewtypes.SINGLE_CHOICE,
        Viewtypes.COMMENT
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiAdapterViewHolder {
        return when (viewType) {
            1 -> {
                val binding: PhotoItemBinding = DataBindingUtil.inflate(
                    layoutInflater, R.layout.photo_item, parent,
                    false)
                val viewHolder = PhotoItemViewHolder(binding)
                viewHolder
            }
           2 -> {
                val binding: SingleChoiceItemBinding = DataBindingUtil.inflate(
                    layoutInflater, R.layout.single_choice_item, parent,
                    false)
                val viewHolder = SingleChoiceViewHolder(binding)
                viewHolder
            }
           3 -> {
                val binding: CommentItemBinding =
                    DataBindingUtil.inflate(layoutInflater,
                        R.layout.comment_item, parent, false)
                val viewHolder = CommentItemViewHolder(binding)
                viewHolder
            }

            else -> {
                val binding: EmptyViewHolderBinding = DataBindingUtil.inflate(
                    layoutInflater, R.layout.empty_view_holder, parent, false
                )
                val viewHolder = EmptyViewHolder(binding)
                viewHolder
            }
        }
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MultiAdapterViewHolder, position: Int) {


        if (mList[position].type == "PHOTO") {
            (holder as PhotoItemViewHolder).bind(position,mList[position],listener)
        }
        if (mList[position].type == "SINGLE_CHOICE") {
            (holder as SingleChoiceViewHolder).bind(position, mList[position],listener)
        }
        if (mList[position].type == "COMMENT") {
            (holder as CommentItemViewHolder).bind(position, mList[position],listener)
        }



    }

    override fun getItemViewType(position: Int): Int {
        if(mList.get(position).type == "PHOTO"){
            return 1
        }else if(mList.get(position).type == "SINGLE_CHOICE"){
            return 2
        } else if(mList.get(position).type == "COMMENT"){
            return 3
        }else return 4
    }
}
