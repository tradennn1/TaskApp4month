package com.example.hw1a2.ui.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1a2.Prefs
import com.example.hw1a2.R
import com.example.hw1a2.databinding.ItemBoardBinding

class BoardAdapter(val context: Context ,val  navController: NavController) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {


    private val list = arrayListOf("Hello","Привет","Салам")
    private val image = arrayListOf(R.raw.lotti_anim_one,R.raw.lotti_anim_two,R.raw.lotti_anim_three)

    private val text = arrayListOf("Здраствуйте ","как дела?"," ты очень красивая")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

    }


    override fun getItemCount() =3




    inner class ViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.textTittle.text = list[position]
            binding.textDesc.text = text[position]
            binding.lottione.setAnimation(image[position])
            if
                    (position == text.lastIndex) {
                binding.btnStart.visibility = View.VISIBLE
            } else {
                binding.btnStart.visibility = View.INVISIBLE

            }

            binding.btnStart.setOnClickListener {
                Prefs(context).saveState()
                navController.navigateUp()

            }

        }
    }
    }