package com.saturnpro.tzapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saturnpro.tzapp.RaitingModel
import com.saturnpro.tzapp.databinding.CardRaitungItemBinding
import com.saturnpro.tzapp.ItemModel
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CardRaitingAdapter @Inject constructor(private val picasso: Picasso):
    RecyclerView.Adapter<CardRaitingAdapter.RaitingViewHolder>(){
        private lateinit var binding: CardRaitungItemBinding
        private lateinit var raitingList: List<ItemModel>

        var onItemClick: ((RaitingModel) -> Unit)? = null

    fun uploadData(raitingHeaderArrayList: List<ItemModel>) {
        this.raitingList = raitingHeaderArrayList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardRaitingAdapter.RaitingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = CardRaitungItemBinding.inflate(inflater, parent, false)
        return RaitingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardRaitingAdapter.RaitingViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        print(raitingList.size)
        return raitingList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }



    inner class RaitingViewHolder(binding: CardRaitungItemBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        private var _position = 0

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //onItemClick?.invoke(raitingList[_position])
        }

        fun bind(position: Int) {
            _position = position
            picasso.load("${raitingList[position].image}")
                .into(binding.profileImages)
            binding.textview.text = raitingList[position].title
        }
    }
}