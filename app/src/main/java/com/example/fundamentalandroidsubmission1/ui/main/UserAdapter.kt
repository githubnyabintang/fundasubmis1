package com.example.fundamentalandroidsubmission1.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.fundamentalandroidsubmission1.data.model.User
import com.example.fundamentalandroidsubmission1.databinding.UserItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val list = ArrayList<User>()

    fun setList(users: ArrayList<User>){
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }
    inner class UserViewHolder(val binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user:User){
            binding.apply{
                Glide.with(itemView)
                    .load(user.avatarURL)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(ivUser)
                tvUser.text = user.login
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder((view))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}






