package com.example.institutepractics.unit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.institutepractics.databinding.ListItemBinding
import com.example.institutepractics.models.Character

class CharactersAdapter(private var characters: List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

    fun updateData(newCharacters: List<Character>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    class CharacterViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            with(binding) {
                nameTextView.text = character.name ?: "-"
                cultureTextView.text = character.culture ?: "-"
                bornTextView.text = character.born ?: "-"
                titlesTextView.text = character.titles.joinToString() ?: "-"
                aliasesTextView.text = character.aliases.joinToString() ?: "-"
                playedByTextView.text = character.playedBy.joinToString() ?: "-"
            }
        }
    }
}