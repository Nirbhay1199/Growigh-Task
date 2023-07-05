package com.nirbhay.growightask

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nirbhay.growightask.adapters.RecyclerViewAdapter
import com.nirbhay.growightask.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity(){
    private lateinit var binding: ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#006CA3")

        val layoutManager = LinearLayoutManager(this)

        binding.recyclerView.layoutManager = layoutManager

        val adapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = adapter

        binding.nestedScroll.viewTreeObserver.addOnScrollChangedListener {
            val view = binding.nestedScroll.getChildAt(binding.nestedScroll.childCount - 1)
            val diff = view.bottom - (binding.nestedScroll.height + binding.nestedScroll.scrollY)
            val isScrolledToBottom = diff <= 0

            if (isScrolledToBottom){
                binding.refreshBtn.visibility = View.VISIBLE
            }else{
                binding.refreshBtn.visibility = View.GONE
            }
        }

        binding.refreshBtn.setOnClickListener {
            binding.nestedScroll.smoothScrollTo(0,0)
            binding.refreshBtn.visibility = View.GONE
            adapter.onButtonClick()
        }


    }




}