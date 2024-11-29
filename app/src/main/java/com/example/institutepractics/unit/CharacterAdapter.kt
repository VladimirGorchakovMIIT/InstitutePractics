package com.example.institutepractics.unit

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.institutepractics.R
import com.example.institutepractics.databinding.CharacterItemBinding
import com.example.institutepractics.models.Character

class CharacterAdapter(private var items: List<Character>):RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {
    class CharacterHolder(item: View) : RecyclerView.ViewHolder(item){
        val binding = CharacterItemBinding.bind(item)

        fun bind(character: Character) = with(binding){
            nameCharacter.text = character.name
            cultureCharacter.text = character.culture
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<Character>) {
        this.items = newData
        notifyDataSetChanged()
    }
}