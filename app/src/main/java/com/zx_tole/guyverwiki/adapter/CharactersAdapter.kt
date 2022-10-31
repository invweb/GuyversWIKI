package com.zx_tole.guyverwiki.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.zx_tole.guyverwiki.BR
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.ZoanoidItemBinding
import timber.log.Timber


class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>(){

    private var characters: List<StoryCharacter> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(characters: List<StoryCharacter>){
        this.characters = characters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ZoanoidItemBinding.inflate(inflater)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.binding.setVariable(BR.StoryCharacter, characters[position])
    }

    override fun getItemCount(): Int = characters.size

    inner class CharactersViewHolder(itemBinding: ZoanoidItemBinding) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener{
        val binding: ViewDataBinding = itemBinding

        init {
            binding.root.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            Timber.d("")
        }
    }
}