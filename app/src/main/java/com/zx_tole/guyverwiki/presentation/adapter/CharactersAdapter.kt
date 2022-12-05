package com.zx_tole.guyverwiki.presentation.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.zx_tole.guyverwiki.BR
import com.zx_tole.guyverwiki.R
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.ZoanoidItemBinding
import com.zx_tole.guyverwiki.tech.CHARACTER

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>(){

    private lateinit var navController: NavController
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
        holder.setItemPosition(position)
    }

    override fun getItemCount(): Int = characters.size

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    inner class CharactersViewHolder(itemBinding: ZoanoidItemBinding) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener{
        val binding: ViewDataBinding = itemBinding
        var localItemPosition: Int = 0
        var character: StoryCharacter? = null

        init {
            binding.root.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            character = characters[localItemPosition]
            val bundle = Bundle()
            bundle.putParcelable(CHARACTER, character)

            navController.navigate(
                R.id.CharacterFragment,
                bundle
            )
        }

        fun setItemPosition(position: Int) {
            localItemPosition = position
        }
    }
}